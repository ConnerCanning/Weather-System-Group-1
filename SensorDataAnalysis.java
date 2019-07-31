
public class SensorDataAnalysis implements WeatherReporter {

	private static SensorHardware hard = new SensorHardware();
	
	public static WeatherData getWeather() {
		double[] rawValues = hard.getReadings();;
		
		return new WeatherData(rawValues[0],
					rawValues[1],
					rawValues[2], 
					rawValues[3],
					's',
					rawValues);
	}
	
}
