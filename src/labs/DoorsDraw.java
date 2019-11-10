package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class DoorsDraw implements IDoors {

	@Override
	public void drawRectDoors(Doors doors, Graphics g, int x, int y) {
		g.setColor(Color.black);
		
		switch(doors) {
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

	@Override
	public void drawTriangleDoors(Doors doors, Graphics g, int x, int y) {
		Polygon points;
		g.setColor(Color.black);
		
		switch(doors) {
		case THREE:			
			points = new Polygon();
			points.addPoint(x + 58, y + 25);
			points.addPoint(x + 54, y + 35);
			points.addPoint(x + 62, y + 35);
			g.fillPolygon(points);
			
			
			points = new Polygon();
			points.addPoint(x + 45, y + 25);
			points.addPoint(x + 41, y + 35);
			points.addPoint(x + 49, y + 35);
			g.fillPolygon(points);
			
			
			points = new Polygon();
			points.addPoint(x + 32, y + 25);
			points.addPoint(x + 28, y + 35);
			points.addPoint(x + 36, y + 35);
			g.fillPolygon(points);
			break;
		case FOUR:
			points = new Polygon();
			points.addPoint(x + 71, y + 25);
			points.addPoint(x + 67, y + 35);
			points.addPoint(x + 75, y + 35);
			g.fillPolygon(points);
			
			
			points = new Polygon();
			points.addPoint(x + 58, y + 25);
			points.addPoint(x + 54, y + 35);
			points.addPoint(x + 62, y + 35);
			g.fillPolygon(points);
			
			
			points = new Polygon();
			points.addPoint(x + 32, y + 25);
			points.addPoint(x + 28, y + 35);
			points.addPoint(x + 36, y + 35);
			g.fillPolygon(points);
			
			
			points = new Polygon();
			points.addPoint(x + 19, y + 25);
			points.addPoint(x + 15, y + 35);
			points.addPoint(x + 23, y + 35);
			g.fillPolygon(points);
			break;
		case FIVE:
			points = new Polygon();
			points.addPoint(x + 71, y + 25);
			points.addPoint(x + 67, y + 35);
			points.addPoint(x + 75, y + 35);
			g.fillPolygon(points);
			
			
			points = new Polygon();
			points.addPoint(x + 58, y + 25);
			points.addPoint(x + 54, y + 35);
			points.addPoint(x + 62, y + 35);
			g.fillPolygon(points);
			
			
			points = new Polygon();
			points.addPoint(x + 45, y + 25);
			points.addPoint(x + 41, y + 35);
			points.addPoint(x + 49, y + 35);
			g.fillPolygon(points);
			
			
			points = new Polygon();
			points.addPoint(x + 32, y + 25);
			points.addPoint(x + 28, y + 35);
			points.addPoint(x + 36, y + 35);
			g.fillPolygon(points);
			
			
			points = new Polygon();
			points.addPoint(x + 19, y + 25);
			points.addPoint(x + 15, y + 35);
			points.addPoint(x + 23, y + 35);
			g.fillPolygon(points);
			
			
			break;
		}
		
	}

	@Override
	public void drawElipseDoors(Doors doors, Graphics g, int x, int y) {

		g.setColor(Color.black);
		
		switch(doors) {
		case THREE:
			g.fillOval(x+54, y+25, 8, 10);
			g.fillOval(x+41, y+25, 8, 10);
			g.fillOval(x+28, y+25, 8, 10);
			break;
		case FOUR:
			g.fillOval(x+67, y+25, 8, 10);
			g.fillOval(x+54, y+25, 8, 10);
			g.fillOval(x+28, y+25, 8, 10);
			g.fillOval(x+15, y+25, 8, 10);
			break;
		case FIVE:
			g.fillOval(x+67, y+25, 8, 10);
			g.fillOval(x+54, y+25, 8, 10);
			g.fillOval(x+41, y+25, 8, 10);
			g.fillOval(x+28, y+25, 8, 10);
			g.fillOval(x+15, y+25, 8, 10);
			break;
		}
		
	}
}
