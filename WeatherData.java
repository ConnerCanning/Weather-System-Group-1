
public class WeatherData {

	public static double temp;
	public static double humid;
	public static double rain;
	public static double windSpeed;
	public static char windDirection;
	public static double[] rawValues;
	
	public WeatherData(double theTemp, double theHumid, double theRain, double theSpeed, char theDirection, double[] theRawValues) {
		temp = theTemp;
		humid = theHumid;
		rain = theRain;
		windSpeed = theSpeed;
		windDirection = theDirection;
		rawValues = theRawValues;
	}
}
	

