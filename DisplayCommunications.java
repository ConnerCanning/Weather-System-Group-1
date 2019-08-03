
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
			display.temp.setText("");
			display.humidity.setText("");
			display.rainfall.setText("");
			display.windSpeed.setText("");
			display.windDirection.setText("");
 	}
	
	public void giveForecast(String s) {
		if (this.on) {
			display.giveForecast("Weather Forecast: " + s);
		}
		else
			display.forecast.setText("");
	}
}
