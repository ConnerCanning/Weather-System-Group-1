package src;

import java.util.Arrays;

public class WeatherData {
	private double temp;
	private double rainAmount;
	private double humidity;
	private int windSpeed;
	private char windDirection;
	private int[] rawValues;
	private boolean sensorStatus;
	
	private static String delimiter = ", ";
	
	public WeatherData(double theTemp, double theRainAmount, double theHumidity,
			int theWindSpeed, char theWindDirection, boolean theSensorStatus) {
		temp = theTemp;
		rainAmount = theRainAmount;
		humidity = theHumidity;
		windSpeed = theWindSpeed;
		windDirection = theWindDirection;
		sensorStatus = theSensorStatus;
		rawValues = new int[6];
		rawValues[0] = (int) theTemp;
		rawValues[1] = (int) theRainAmount;
		rawValues[2] = (int) theHumidity;
		rawValues[3] = (int) theWindSpeed;
		rawValues[4] = (int) theWindDirection;
		if (theSensorStatus) {
			rawValues[5] = 1;
		} else {
			rawValues[5] = 0;
		}
		
	}
	
	public double getTemp() {
		return temp;
	}
	
	public double getRainAmount() {
		return rainAmount;
	}
	
	public double getHumidity() {
		return humidity;
	}
	
	public int getWindSpeed() {
		return windSpeed;
	}
	
	public char getWindDirection() {
		return windDirection;
	}
	
	public boolean getSensorStatus() {
		return sensorStatus;
	}
	
	public int[] getRawValues() {
		return Arrays.copyOf(rawValues, rawValues.length);
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder(64);
		sb.append(temp);
		sb.append(delimiter);
		sb.append(rainAmount);
		sb.append(delimiter);
		sb.append(humidity);
		sb.append(delimiter);
		sb.append(windSpeed);
		sb.append(delimiter);
		sb.append(windDirection);
		sb.append(delimiter);
		sb.append(sensorStatus);
		return sb.toString();
	}
	
	/**
	 * Returns an alternative String representation of the weather data using
	 * raw data
	 * @return a String representation of raw weather data
	 */
	private String rawValues() {
		StringBuilder sb = new StringBuilder(64);
		for (int i = 0; i < rawValues.length; i++) {
			sb.append(rawValues[i]);
			sb.append(delimiter);
			
		}
		return sb.toString();
	}
	
}
