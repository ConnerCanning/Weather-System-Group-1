import StatusReporter;
import WeatherReporter;

public class SensorCommunication implements WeatherReporter, StatusReporter {

	private TowerCommunication myTC;
	private DisplayCommunication myDC;
	
	public SensorCommunication(TowerCommunication tc, DisplayCommunication dc) {
		myTC = tc;
		myDC = dc;
	}
	public void getWeather() {
		WeatherData wd = SensorDataAnalysis.getWeather();
		myTC.giveWeather(wd);
		myDC.giveWeather(wd);
	}
	
	public boolean getStatus() {
		return true;
	}
}
