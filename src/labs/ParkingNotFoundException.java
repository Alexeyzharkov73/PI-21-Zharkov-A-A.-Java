package labs;

public class ParkingNotFoundException extends NullPointerException {
	public ParkingNotFoundException(int i) {
		super("Не найден автобус по месту " + i);
	}
}
