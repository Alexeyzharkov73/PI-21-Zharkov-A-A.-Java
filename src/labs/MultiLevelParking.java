package labs;

import java.util.ArrayList;

public class MultiLevelParking {
	
	ArrayList<Parking<ITransport, DoorsDraw>> parking;
	private int countPlaces = 20;
	
	public MultiLevelParking(int lvls, int pictureWidth, int pictureHeight) {
		parking = new ArrayList<Parking<ITransport, DoorsDraw>>();
		for(int i = 0;i<lvls;i++) {
			parking.add(new Parking<ITransport, DoorsDraw>(countPlaces,pictureWidth, pictureHeight));
		} 
	}
	
	public Parking<ITransport, DoorsDraw> getParking(int index){
		if(index >= 0 && index < countPlaces) {
			return parking.get(index);
		}
		return null;
	}
	
	public ITransport getBus(int parking, int ticket) {
		if (parking >= 0 && parking < countPlaces) {
			return this.parking.get(parking).getBusInParking(ticket);
		}
		return null;
	}
	
}