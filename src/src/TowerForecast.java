package src;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents a weather forecast
 * @author Justin
 *
 */
public class TowerForecast {
	
	/** The generated weather forecast*/
	private String weatherForecast;
	
	/** Random object to generate weather forecast*/
	private Random randWeatherForecast;
	
	
	/**
	 * Initializes weather forecast
	 */
	public TowerForecast() {
		randWeatherForecast = new Random();
		weatherForecast = generateForecast();
	}
	
	/**
	 * Returns the weather forecast
	 * @return the weather forecast
	 */
	public String getWeatherForecast() {
		return weatherForecast;		
	}
	
	/**
	 * Returns a randomly generated weather condition
	 * @return a randomly generated weather condition
	 */
	private String generateForecast() {
		return Stream.of("Clear", "Mostly Clear", "Partly Cloudy", "Mostly Cloudy", "Cloudy").
				collect(Collectors.toList()).
				get(randWeatherForecast.nextInt(5));
		
	}
	
}
