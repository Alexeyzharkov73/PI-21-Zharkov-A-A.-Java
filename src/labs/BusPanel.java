package labs;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BusPanel extends JPanel {
	private Parking<BaseBus, DoorsDraw> parking;
	
	
	public void setParking(Parking<BaseBus, DoorsDraw> parking) {
		this.parking = parking;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		parking.draw(g, new DoorsDraw());
		
	}
	
	public int setBus(ITransport bus) {
		return parking.putBusInParking(bus);
	}
	public ITransport getBus(int ticket) {
		return parking.getBusInParking(ticket);
	}
}
