package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;


public class Parking<T extends ITransport, D extends DoorsDraw> implements Serializable, Comparable<Parking<T,D>>,Iterable<T> {
	
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
	
	public int putBusInParking(T bus) throws ParkingOverflowException, ParkingAlreadyHaveException{
		if(parking.size() == countPlaces) {
			throw new ParkingOverflowException(); 
		}
		for(int i =0 ;i < this.countPlaces; i++) {
			if(!this.parking.containsKey(i)) {
				this.parking.put(i, bus);
				this.parking.get(i).setPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15, this.pictureWidth, this.pictureHeight);
				return i;
			}
			if(bus.getClass().getTypeName() == parking.get(i).getClass().getTypeName()) {
				if(bus instanceof Bus) {
					if(((Bus)bus).equals(parking.get(i))) {
						throw new ParkingAlreadyHaveException();
					}
				} else {
					if(((BaseBus)bus).equals(parking.get(i))) {
						throw new ParkingAlreadyHaveException();
					}
				}
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
		for (ITransport bus : parking.values()) {
			bus.drawBus(g, draw);
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

	public int count() {
		return parking.size();
	}
	
	public Iterator<T> iterator() {
		return parking.values().iterator();
	}

	@Override
	public int compareTo(Parking<T, D> arg0) {
		if(this.count() > arg0.count()) {
			return -1;
		} else if (this.count() < arg0.count()) {
			return 1;
		} else {
			Integer [] thisKeys = this.parking.keySet().toArray(new Integer[this.count()]);
			Integer [] otherKeys = arg0.parking.keySet().toArray(new Integer[this.count()]);
			for(int i = 0;i<parking.size();i++) {
				if(this.parking.get(thisKeys[i]).getClass().getName().equals(BaseBus.class.getName()) && 
						arg0.parking.get(otherKeys[i]).getClass().getName().equals(Bus.class.getName())) {
					return 1;
				}
				if(this.parking.get(thisKeys[i]).getClass().getName().equals(Bus.class.getName()) && 
						arg0.parking.get(otherKeys[i]).getClass().getName().equals(BaseBus.class.getName())) {
					return -1;
				}
				if(this.parking.get(thisKeys[i]).getClass().getName().equals(BaseBus.class.getName()) && 
						arg0.parking.get(otherKeys[i]).getClass().getName().equals(BaseBus.class.getName())) {
					return ((BaseBus)this.parking.get(thisKeys[i]))
							.compareTo((BaseBus)arg0.parking.get(otherKeys[i]));
				}
				if(this.parking.get(thisKeys[i]).getClass().getName().equals(Bus.class.getName()) && 
						arg0.parking.get(otherKeys[i]).getClass().getName().equals(Bus.class.getName())) {
					return ((Bus)this.parking.get(thisKeys[i]))
							.compareTo((Bus)arg0.parking.get(otherKeys[i]));
				}
			}
		}
		return 0;
	}
}
