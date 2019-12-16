package labs;

import java.awt.Color;
import java.awt.Graphics;
import javax.print.attribute.standard.MediaSize.Other;


public class BaseBus extends Vehicle implements Comparable<Object> {
	
	protected int busWidth = 120;
	protected int busHeight = 80;
	
	public BaseBus(int maxSpeed, int weight, Color mainColor) {
		this.maxSpeed = maxSpeed;
		this.weight = weight;
		this.colorBody = mainColor;
		this.doorsForm = 0;
	}

	@Override
	public void moveTransport(Direction direction) {
		int step = maxSpeed * 100 / weight;
		switch (direction)
		{
		case RIGHT:
			if (posX + step < pictureWidth + busWidth) {
				posX += step;
			}
			break;
		case LEFT:
			if (posX - step >= 0) {
				posX -= step;
			}
			break;
		case UP:
			if (posY - step >= 0) {
				posY -= step;
			}
			break;
		case DOWN:
			if (posY + step < pictureHeight + busHeight) {
				posY += step;
			}
			break;
		}
		
	}

	@Override
	public void drawBus(Graphics g, IDoors draw) {
		g.setColor(this.colorBody);
		g.fillRect(posX, posY + 15, 90, 30);
		g.setColor(Color.black);
		g.drawRect(posX, posY + 15, 90, 30);
		g.setColor(this.colorBody);
		g.fillRect(posX + 90, posY + 30, 13, 15);
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(posX, posY + 35, 25, 20);
		g.fillOval(posX + 65, posY + 35, 25, 20);
		
		g.setColor(Color.BLUE);
		g.fillRect(posX, posY + 17, 10, 10);
		g.fillRect(posX + 20, posY + 17, 10, 10);
		g.fillRect(posX + 40, posY + 17, 10, 10);
		g.fillRect(posX + 60, posY + 17, 10, 10);
		g.fillRect(posX + 80, posY + 17, 10, 10);
		
		switch(doorsForm){
		case 0:
			draw.drawRectDoors(Doors.THREE, g, posX, posY);
			break;
		case 1:
			draw.drawElipseDoors(Doors.THREE, g, posX, posY);
			break;
		default:
			draw.drawTriangleDoors(Doors.THREE, g, posX, posY);
			break;
		}
		
	}
	
	public static boolean moreOrEquals(BaseBus first, BaseBus second) {
		return first.getMaxSpeed() >= second.getMaxSpeed();
	}
	
	public static boolean lessOrEquals(BaseBus first, BaseBus second) {
		return first.getMaxSpeed() <= second.getMaxSpeed();
	}
	
	public void setBodyColor(Color color) {
		this.colorBody = color;
	}
	
	@Override
	public int compareTo(Object other) {
		BaseBus o = null;
		if(other == null) {
			return 1;
		}
		if(other instanceof BaseBus) {
			o = (BaseBus)other;
		} else {
			return 1;
		}
		if(maxSpeed != o.maxSpeed) {
			return maxSpeed > o.maxSpeed ? 1 : -1;
		}
		if(weight != o.weight) {
			return weight > o.weight ? 1 : -1;
		}
		if(colorBody.getRGB() != o.colorBody.getRGB()) {
			return colorBody.getRGB() > o.colorBody.getRGB() ? 1 : -1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		BaseBus otherShip = null;
		if(o instanceof BaseBus) {
			otherShip = (BaseBus)o;
		} else {
			return false;
		}
		if(maxSpeed != otherShip.maxSpeed) {
			return false;
		}
		if(weight != otherShip.weight) {
			return false;
		}
		if(colorBody.getRGB() != otherShip.colorBody.getRGB()) {
			return false;
		}
		return true;
	}
}
