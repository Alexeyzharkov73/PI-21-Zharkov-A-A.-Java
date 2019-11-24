package labs;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SmallBusPanel extends JPanel {
	
	private ITransport bus;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(bus!=null) {
			bus.setPosition(22, 150, 140, 221);
			bus.drawBus(g, new DoorsDraw());
		}
	}
	
	public void setShip(ITransport ship) {
		this.bus = ship;
	}
}
