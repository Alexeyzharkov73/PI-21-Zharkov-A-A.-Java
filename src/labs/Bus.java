package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Bus extends BaseBus{
	
	private Color dopColor;
	private boolean isDorsDraw;
	private Doors doorsCount;
	private int doorsForm;
	
	
	public Bus(int maxSpeed, int weight, Color color, Color dopColor, boolean isDoorsDraw, Doors doorsCount) {
		super(maxSpeed, weight, color);
		this.dopColor = dopColor;
		this.isDorsDraw = isDoorsDraw;
		this.doorsCount = doorsCount;
		this.doorsForm = new Random().nextInt(3);
	}
	
	public void drawBus(Graphics g) {
		g.setColor(this.colorBody);
		g.fillRect(posX, posY, 75, 15);
		g.fillRect(posX + 60, posY + 17, 10, 10);
		g.setColor(Color.black);
		g.drawRect(posX, posY, 75, 15);
		
		g.setColor(this.dopColor);
		
		g.fillRect(posX, posY + 15, 90, 20);
		g.setColor(Color.black);
		g.drawRect(posX, posY + 15, 90, 20);
		
		g.setColor(Color.darkGray);
		g.fillOval(posX, posY + 30, 25, 20);
		g.fillOval(posX + 70, posY + 30, 25, 20);
		
		if(this.isDorsDraw) {
			switch(doorsForm){
			case 0:
				new DoorsDraw().drawRectDoors(doorsCount, g, posX, posY);
				break;
			case 1:
				new DoorsDraw().drawElipseDoors(doorsCount, g, posX, posY);
				break;
			default:
				new DoorsDraw().drawTriangleDoors(doorsCount, g, posX, posY);
				break;
			}
		}
		
		g.setColor(Color.BLUE);
		
		g.fillRect(posX, posY + 8, 10, 9);
		g.fillRect(posX + 20, posY + 8, 10, 9);
		g.fillRect(posX + 40, posY + 8, 10, 9);
		g.fillRect(posX + 60, posY + 8, 10, 9);
		
		
	}

}
