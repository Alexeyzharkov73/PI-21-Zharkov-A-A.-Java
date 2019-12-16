package labs;

public class ParkingAlreadyHaveException extends Exception {
	public ParkingAlreadyHaveException() {
		super("На парковке уже есть такой автобус.");
	}
}
