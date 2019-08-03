import java.util.Timer;

import gui.Display;
import gui.DisplayCommunications;
import tower.TowerCommunication;
import sensor.SensorCommunication;

public class Runner {

	public static void main(String[] args) {
		
		// instantiate tower and display
		DisplayCommunications dc = new DisplayCommunications(new Display());
		TowerCommunication tc = new TowerCommunication(dc);
		
		// with these we can instantiate weather sensor
		SensorCommunication sc = new SensorCommunication(tc, dc);
		
		// now get the sensor to give readings every second
		Timer time = new Timer();
		Running run = new Running(sc);
		time.schedule(run, 1000);
	}
		
}

