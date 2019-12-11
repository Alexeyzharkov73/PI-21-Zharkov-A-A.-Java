package labs;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BusPanel extends JPanel {
	private MultiLevelParking parking;
	public static int currentLevel = 0;
	
	public void setParking(MultiLevelParking parking) {
		this.parking = parking;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		parking.getParking(currentLevel).draw(g, new DoorsDraw());
		
	}
	
	public int setBus(ITransport bus) {
		return parking.getParking(currentLevel).putBusInParking(bus);
	}
	public ITransport getBus(int ticket) {
		return parking.getBus(currentLevel, ticket);
	}
}
