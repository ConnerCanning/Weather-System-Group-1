package gui;

import sensor.WeatherData;

public class DisplayCommunications {
	
	Display display;
	public static boolean on;
	
	public void onOffSensor(boolean theOn) {
		on = theOn;
	}
	
	public DisplayCommunications(Display theDisplay) {
		System.out.println("dc created");
		this.display = theDisplay;
		on = true;
	}
	
	public void giveWeather(WeatherData object) {
		if (on) {
			display.giveWeather(object);
		}
		else {
			System.out.println("giveWeather but not on");
			display.temp.setText("");
			display.humidity.setText("");
			display.rainfall.setText("");
			display.windSpeed.setText("");
			display.windDirection.setText("");
			display.status.setText("");
		}
 	}
	
	public void giveForecast(String s) {
		if (on) 
			display.giveForecast(s);
		else
			display.forecast.setText("");
	}
}