package labs;

public class ParkingOverflowException extends ArrayIndexOutOfBoundsException {
	public ParkingOverflowException() {
		super("На парковке нет свободных мест");
	}
}
