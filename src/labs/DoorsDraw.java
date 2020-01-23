package labs;

import java.awt.Color;
import java.awt.Graphics;

public class DoorsDraw {
	
	private Doors doors;
	
	public DoorsDraw(Doors doors) {
		this.doors = doors;
	}
	
	public void draw(Graphics g, int x, int y){
		g.setColor(Color.black);
		
		switch(this.doors) {
		case THREE:
			g.fillRect(x+54, y+25, 8, 10);
			g.fillRect(x+41, y+25, 8, 10);
			g.fillRect(x+28, y+25, 8, 10);
			break;
		case FOUR:
			g.fillRect(x+67, y+25, 8, 10);
			g.fillRect(x+54, y+25, 8, 10);
			g.fillRect(x+28, y+25, 8, 10);
			g.fillRect(x+15, y+25, 8, 10);
			break;
		case FIVE:
			g.fillRect(x+67, y+25, 8, 10);
			g.fillRect(x+54, y+25, 8, 10);
			g.fillRect(x+41, y+25, 8, 10);
			g.fillRect(x+28, y+25, 8, 10);
			g.fillRect(x+15, y+25, 8, 10);
			break;
		}
	}
}
