
public class DisplayCommunications {
	
	Display display;
	boolean on;
	
	public void onOffSensor(boolean on) {
		this.on = on;
	}
	
	public DisplayCommunications(Display display) {
		this.display = display;
	}
	
	public void giveWeather(WeatherData object) {
		if (this.on) {
			display.giveWeather(object);
		}
		else
			display.label.setText("");
 	}
	
	public void giveForecast(TowerForecast forecast) {
		if (this.on) {
			display.giveForecast(forecast);
		}
		else
			display.forecast.setText("");
	}
}
