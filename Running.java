import java.util.TimerTask;

public class Running extends TimerTask {
	
	private SensorCommunication sc;
	
	public Running(SensorCommunication theSC) {
		sc = theSC;
	}
	public void run() {
		sc.getWeather();
	}
}