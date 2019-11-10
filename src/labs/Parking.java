package labs;

import java.awt.Color;
import java.awt.Graphics;

public class Parking<T extends BaseBus, D extends DoorsDraw> {
	
	private T[] parking;
	private int placeSizeWidth = 210;
	private int placeSizeHeight = 80;
	private int pictureWidth;
	private int pictureHeight;
	
	
	public Parking(int size, int pictureWidth, int pictureHeight) {
		this.pictureHeight = pictureHeight;
		this.pictureWidth = pictureWidth;
		parking = (T[])(new BaseBus[size]);
		for(int i = 0; i<size; i++) {
			parking[i] = null;
		}
				
	}
	
	public int putBusInParking(ITransport bus) {
		for(int i =0 ;i < parking.length; i++) {
			if(((T)parking[i]) == null) {
				parking[i] = (T) bus;
				((T)parking[i]).setPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15, this.pictureWidth, this.pictureHeight);
				return i;
			}
		}
		return -1;
	}
	
	public ITransport getBusInParking(int ticket) {
		if(((T)parking[ticket]) == null) {
			return null;
		}
		ITransport tmp = parking[ticket];
		parking[ticket] = null;
		return tmp;
	}
	
	public void draw(Graphics g, D draw) {
		drawMarking(g);
		for(int i = 0;i<parking.length;i++) {
			ITransport bus = parking[i];
			if(bus!=null) {
				bus.drawBus(g, draw);
			}
		}
	}
	
	public void drawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (parking.length / 5) * placeSizeWidth, 400);
		for(int i = 0; i < parking.length / 5; i++) {
			for(int j = 0; j< 6;j++) {
				g.drawLine(i * placeSizeWidth, j*placeSizeHeight,
						i*placeSizeWidth + 110, j * placeSizeHeight);
			}
			g.drawLine(i*placeSizeWidth, 0, i*placeSizeWidth, 400);
		}
	}
}
