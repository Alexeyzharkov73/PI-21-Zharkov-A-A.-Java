package labs;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class LogError {
	public static Logger logger;
	
	public LogError(String path) throws SecurityException, IOException {
		logger = Logger.getLogger("LogError");
        SimpleFormatter formatter = new SimpleFormatter();  
		Handler h = new FileHandler(path);
		h.setFormatter(formatter);
		logger.addHandler(h);
		logger.setUseParentHandlers(false);
	}
	
	public static void log(String message) {
		String DATE_FORMAT_NOW = "dd-MM-yyyy";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String now = sdf.format(cal.getTime());
		logger.log(Level.WARNING, message + " " + now);
	}
}
