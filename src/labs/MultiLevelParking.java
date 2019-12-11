package labs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class MultiLevelParking implements Serializable{
	
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
	
	public void saveData(String fileName){
		 try {  
		        FileOutputStream fileStream = new FileOutputStream(fileName);  
		        ObjectOutputStream os = new ObjectOutputStream(fileStream);  
		        os.writeObject(parking);  
		    }  
		    catch (Exception e) {
		    	System.out.println("save data error");
		    }
	}
	
	public void saveDataCurrent(String fileName, int level){
		 try {  
		        FileOutputStream fileStream = new FileOutputStream(fileName);  
		        ObjectOutputStream os = new ObjectOutputStream(fileStream);  
		        os.writeObject(parking.get(level));  
		    }  
		    catch (Exception e) {
		    	System.out.println("save data error");
		    }
	}
	
	public void loadData(String fileName){
		try {
			FileInputStream inStream = new FileInputStream(fileName);
			ObjectInputStream inObject = new ObjectInputStream(inStream);
			parking = (	ArrayList<Parking<ITransport,DoorsDraw>> )inObject.readObject();
		} catch (Exception ex) {
			System.out.println("load data error");
		}
	}
	
	public void loadDataCurrent(String fileName, int index){
		try {
			FileInputStream inStream = new FileInputStream(fileName);
			ObjectInputStream inObject = new ObjectInputStream(inStream);
			parking.set(index, (Parking<ITransport,DoorsDraw>)inObject.readObject());
		} catch (Exception ex) {
			System.out.println("load data error");
		}
	}
	
}