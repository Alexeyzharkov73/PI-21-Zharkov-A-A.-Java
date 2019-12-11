package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.HashMap;

public class Parking<T extends ITransport, D extends DoorsDraw> implements Serializable{
	
	private HashMap<Integer, T> parking;
	private int countPlaces;
	private int placeSizeWidth = 210;
	private int placeSizeHeight = 80;
	private int pictureWidth;
	private int pictureHeight;
	
	
	public Parking(int size, int pictureWidth, int pictureHeight) {
		this.countPlaces = size;
		this.pictureHeight = pictureHeight;
		this.pictureWidth = pictureWidth;
		this.parking = new HashMap<Integer, T>();
				
	}
	
	public int putBusInParking(T bus) throws ParkingOverflowException{
		if(parking.size() == countPlaces) {
			throw new ParkingOverflowException(); 
		}
		for(int i =0 ;i < this.countPlaces; i++) {
			if(!this.parking.containsKey(i)) {
				this.parking.put(i, bus);
				this.parking.get(i).setPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15, this.pictureWidth, this.pictureHeight);
				return i;
			}
		}
		return -1;
	}
	
	public T getBusInParking(int ticket) throws ParkingNotFoundException{
		if(!this.parking.containsKey(ticket)) {
			throw new ParkingNotFoundException(ticket);
		}
		T tmp = parking.get(ticket);
		parking.remove(ticket);
		return tmp;
	}
	
	public void putBus(T bus) throws ParkingOverflowException{
		for(int i = 0; i<this.countPlaces; i++) {
			if(!this.parking.containsKey(i)) {
				parking.put(i, bus);
			}
		}
		throw new ParkingOverflowException();
	}
	
	public void setBus(int index, T bus) {
		if(this.parking.containsKey(index)) {
			throw new ParkingOccupiedPlaceException(index);
		}
		this.parking.put(index, bus);
	}
	
	public void draw(Graphics g, D draw) {
		drawMarking(g);
		for(int i = 0;i<countPlaces;i++) {
			if(parking.containsKey(i)) {
				parking.get(i).drawBus(g, draw);
			}
		}
	}
	
	public void drawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (countPlaces / 5) * placeSizeWidth, 400);
		for(int i = 0; i < countPlaces / 5; i++) {
			for(int j = 0; j< 6;j++) {
				g.drawLine(i * placeSizeWidth, j*placeSizeHeight,
						i*placeSizeWidth + 110, j * placeSizeHeight);
			}
			g.drawLine(i*placeSizeWidth, 0, i*placeSizeWidth, 400);
		}
	}
}
