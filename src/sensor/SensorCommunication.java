package sensor;

import interfaces.StatusReporter;
import gui.DisplayCommunications;
import interfaces.WeatherReporter;
import tower.TowerCommunication;

public class SensorCommunication implements WeatherReporter, StatusReporter {

	private TowerCommunication myTC;
	private DisplayCommunications myDC;
	private SensorDataAnalysis sensor;
	
	public SensorCommunication(TowerCommunication tc, DisplayCommunications dc) {
		myTC = tc;
		sensor = new SensorDataAnalysis();
		myDC = dc;
	}
	public WeatherData getWeather() {
		WeatherData wd = sensor.getWeather();
		myTC.giveWeather(wd);
		myDC.giveWeather(wd);
		return wd;
	}
	
	public boolean getStatus() {
		return true;
	}
}
