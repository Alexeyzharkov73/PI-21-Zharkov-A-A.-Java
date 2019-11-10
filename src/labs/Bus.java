package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Bus{
	private Color colorBody;
	private Color dopColor;
	private int posX;
	private int posY;
	private int maxSpeed;
	private boolean isDorsDraw;
	private int busWidth = 100;
	private int busHeight = 60;
	private Doors doorsCount;
	private int pictureWidth;
	private int pictureHeight;
	private int weight;
	
	
	public Bus(int maxSpeed, int weight, Color color, Color dopColor, boolean isDoorsDraw, Doors doorsCount) {
		this.weight = weight;
		this.colorBody = color;
		this.maxSpeed = maxSpeed;
		this.dopColor = dopColor;
		this.isDorsDraw = isDoorsDraw;
		this.doorsCount = doorsCount;
	}
	
	public void setPosition(int x, int y, int width, int height) {
		posX = x;
		posY = y;
		busWidth = width;
		busHeight = height;
	}

	public void moveBus(Direction  direction) {
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
	
	public void drawBus(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(posX, posY, 75, 15);
		g.fillRect(posX, posY + 15, 90, 20);
		
		g.setColor(Color.BLACK);
		g.drawRect(posX, posY, 75, 15);
		g.drawRect(posX, posY + 15, 90, 20);
		
		g.setColor(Color.darkGray);
		g.fillOval(posX, posY + 30, 25, 20);
		g.fillOval(posX + 70, posY + 30, 25, 20);
		
		if(this.isDorsDraw) {
			new DoorsDraw(this.doorsCount).draw(g, posX, posY);
		}
		
		g.setColor(Color.BLUE);
		
		g.fillRect(posX, posY + 8, 10, 9);
		g.fillRect(posX + 20, posY + 8, 10, 9);
		g.fillRect(posX + 40, posY + 8, 10, 9);
		g.fillRect(posX + 60, posY + 8, 10, 9);
		
		
	}

	public Color getColorBody() {
		return colorBody;
	}

	public void setColorBody(Color colorBody) {
		this.colorBody = colorBody;
	}

	public Color getDopColor() {
		return dopColor;
	}

	public void setDopColor(Color dopColor) {
		this.dopColor = dopColor;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public boolean isDorsDraw() {
		return isDorsDraw;
	}

	public void setDorsDraw(boolean isDorsDraw) {
		this.isDorsDraw = isDorsDraw;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	


}
