package sensor;


public class WeatherData {

	public static StringBuilder sb = new StringBuilder();
	public static String delimiter = "\n";
	
	public double temp;
	public double humid;
	public double rain;
	public double windSpeed;
	public char windDirection;
	public double[] rawValues;
	public boolean sensorStatus;
	
	public WeatherData(double theTemp, double theHumid, double theRain, double theSpeed, char theDirection, double[] theRawValues) {
		temp = theTemp;
		humid = theHumid;
		rain = theRain;
		windSpeed = theSpeed;
		windDirection = theDirection;
		rawValues = theRawValues;
		sensorStatus = true;
	}
	
	public String toString() {
        sb.append("Temperature: " + temp + " F");
        sb.append(delimiter);
        sb.append("Rain Fall: " + rain + " inches");
        sb.append(delimiter);
        sb.append("Humidity: " + humid + " %");
        sb.append(delimiter);
        sb.append("Wind speed: " + windSpeed + " mph");
        sb.append(delimiter);
        sb.append("Wind direction: " + windDirection);
        return sb.toString();
    }

}
	

