package interfaces;

import sensor.WeatherData;

public interface WeatherConsumer {
	
	/**
	 * WeatherConsumer interface.
	 * 
	 * @param weatherData weather measurements.
	 */
	public void giveWeather(WeatherData weatherData);
}
