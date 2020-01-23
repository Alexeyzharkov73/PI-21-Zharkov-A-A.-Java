package labs;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BusPanel extends JPanel {
	private Bus bus;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(bus!=null) {
			bus.drawBus(g);
		}
	}
	
	public void setBus(Bus ship) {
		this.bus = ship;
	}
	public Bus getBus() {
		return bus;
	}
}
