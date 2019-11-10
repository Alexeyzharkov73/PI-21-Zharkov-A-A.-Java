package labs;

import java.awt.Graphics;

public interface IDoors {
	void drawRectDoors(Doors doors, Graphics g, int x, int y);
	void drawTriangleDoors(Doors doors, Graphics g, int x, int y);
	void drawElipseDoors(Doors doors, Graphics g, int x, int y);
	
}
