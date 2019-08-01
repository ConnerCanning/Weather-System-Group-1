package tower;

import static org.junit.Assert.*;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

import sensor.WeatherData;

public class TowerArchiveTest {
	
	public static final String PROPERTY_WEATHER = "incoming weather data";

	@Test
	public void testTowerArchivePrintsWeatherToOutput() throws FileNotFoundException {
		String outputFileName = "towerArchiveTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));
		
		TowerArchive tower = new TowerArchive(output);
		

		double temp = 73.5;
		double rainAmount = 1.2;
		double humidity = 33.2;
		double windSpeed = 12.0;
		char windDirection = 's';
		double[] raw = {temp, rainAmount, humidity, windSpeed, windDirection} ; 
		
		
		
		WeatherData weather = new WeatherData(temp, humidity, rainAmount,
				windSpeed, windDirection, raw);
		PropertyChangeEvent event = new PropertyChangeEvent("source", PROPERTY_WEATHER, null, weather);
		
		tower.propertyChange(event); // should trigger write to output
		
		// now check to see if the file was written correctly
		
		try {
			Scanner input = new Scanner(new File(outputFileName));
			assertEquals(Arrays.toString(raw).replace("[", "").replace("]", ""), input.nextLine());
			
			input.close();
		} catch (FileNotFoundException e) {
			fail("Failed to write output file " + outputFileName);
		}
	}

}
