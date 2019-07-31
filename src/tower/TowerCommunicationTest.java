package tower;

import static org.junit.Assert.*;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import sensor.WeatherData;

public class TowerCommunicationTest {

	@Test
	public void testTowerCommunicationPropertyWeather() throws FileNotFoundException {
		String outputFileName = "towerCommunicationTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));
		
		TowerCommunication towerComm = new TowerCommunication(output);
		
		double temp = 73.5;
		double rainAmount = 1.2;
		double humidity = 33.2;
		int windSpeed = 12;
		char windDirection = 'N';
		boolean sensorStatus = true;
		
		WeatherData weather = new WeatherData(temp, rainAmount, humidity, 
				windSpeed, windDirection, sensorStatus);
		PropertyChangeEvent event = new PropertyChangeEvent("source", TowerArchiveTest.PROPERTY_WEATHER, null, weather);
		
		towerComm.propertyChange(event); // should trigger write to output
		
		// now check to see if the file was written correctly
		
		try {
			Scanner input = new Scanner(new File(outputFileName));
			assertEquals(weather.toString(), input.nextLine());
			input.close();
		} catch (FileNotFoundException e) {
			fail("Failed to write output file " + outputFileName);
		}
	}
	
	@Test
	public void testTowerCommunicationPropertyForecast() {
		// Feature code not yet implemented
	}
	
	@Test
	public void testTowerCommunicationPropertyStatus()  {
		// Feature code not yet implemented
	}

}
