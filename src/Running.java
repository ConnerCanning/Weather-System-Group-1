import java.util.TimerTask;
import sensor.SensorCommunication;

public class Running extends TimerTask {
	
	private SensorCommunication sc;
	
	public Running(SensorCommunication theSC) {
		sc = theSC;
	}
	public void run() {
		sc.getWeather();
	}
}