import java.util.Timer;
import java.util.TimerTask;

public class Runner {

	public static void main(String[] args) {
		
		// instantiate tower and display
		TowerCommunication tc = new TowerCommunication();
		DisplayCommunication dc = new DisplayCommunication();
		
		// with these we can instantiate weather sensor
		SensorCommunication sc = new SensorCommunication(tc, dc);
		
		// now get the sensor to give readings every second
		Timer time = new Timer();
		Running run = new Running(sc);
		time.schedule(run, 1000);
	}
		
}

