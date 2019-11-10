package labs;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BusPanel extends JPanel {
	private ITransport bus;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(bus!=null) {
			bus.drawBus(g);
		}
	}
	
	public void setBus(ITransport bus) {
		this.bus = bus;
	}
	public ITransport getBus() {
		return bus;
	}
}
