package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public interface ITransport extends Serializable {
	void setPosition(int x, int y, int width, int height);
	void moveTransport(Direction direction);
	void drawBus(Graphics g, IDoors draw);
	void setBodyColor(Color color);
	void setDoorsForm(int form);
}
