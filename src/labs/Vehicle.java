package labs;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehicle implements ITransport {
	protected int posX;
	protected int posY;
	protected int pictureWidth;
	protected int pictureHeight;	
	protected int weight;
	protected Color colorBody;
	protected int maxSpeed;
	protected int doorsForm;

	@Override
	public void setPosition(int x, int y, int width, int height) {

		posX = x;
		posY = y;
		pictureWidth = width;
		pictureHeight = height;

	}

	public abstract void moveTransport(Direction direction);

	public abstract void drawBus(Graphics g, IDoors draw);
	
	public abstract void setBodyColor(Color color);

	public void setDoorsForm(int form) {
		this.doorsForm = form;
	}
	
	public int getWeight() {
		return weight;
	}


	public Color getColorBody() {
		return colorBody;
	}


	public int getMaxSpeed() {
		return maxSpeed;
	}

	
}
