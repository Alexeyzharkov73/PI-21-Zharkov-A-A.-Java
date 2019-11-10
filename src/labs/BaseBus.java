package labs;

import java.awt.Color;
import java.awt.Graphics;

public class BaseBus extends Vehicle {
	
	protected int busWidth = 120;
	protected int busHeight = 80;
	
	public BaseBus(int maxSpeed, int weight, Color mainColor) {
		this.maxSpeed = maxSpeed;
		this.weight = weight;
		this.colorBody = mainColor;
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
	public void drawBus(Graphics g) {
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
		
		g.setColor(Color.BLACK);
		g.fillRect(posX + 31, posY + 35, 8, 11);
		g.fillRect(posX + 51, posY + 35, 8, 11);
		
	}
	
}
