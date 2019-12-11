package labs;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JPanel;

public class SmallBusPanel extends JPanel {
	
	private HashSet<ITransport> bus = new HashSet<ITransport>();
	private ITransport currentBus;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(currentBus != null) {
			currentBus.setPosition(22, 150, 140, 221);
			currentBus.drawBus(g, new DoorsDraw());
		}
	}
	
	public void addBus(ITransport bus) {
		this.bus.add(bus);
		currentBus = bus;
	}
	
}
