package sensor;

import interfaces.StatusReporter;
import interfaces.WeatherReporter;
import tower.TowerCommunication;

public class SensorCommunication implements WeatherReporter, StatusReporter {

	private TowerCommunication myTC;
	//private DisplayCommunication myDC;
	private SensorDataAnalysis sensor;
	
	public SensorCommunication(TowerCommunication tc) {
		myTC = tc;
		sensor = new SensorDataAnalysis();
		//myDC = dc;
	}
	public WeatherData getWeather() {
		WeatherData wd = sensor.getWeather();
		myTC.giveWeather(wd);
		//myDC.giveWeather(wd);
		return wd;
	}
	
	public boolean getStatus() {
		return true;
	}
}
