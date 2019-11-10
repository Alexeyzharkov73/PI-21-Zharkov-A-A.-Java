package labs;

import java.awt.Graphics;

public interface ITransport {
	void setPosition(int x, int y, int width, int height);
	void moveTransport(Direction direction);
	void drawBus(Graphics g);
}
