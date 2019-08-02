package tower;

import static org.junit.Assert.*;

import org.junit.Test;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import sensor.WeatherData;

public class TowerCommunicationTest {
	
	//Need to figure out why this code broke.  Look at this later. **DOES NOT WORK**
	
	
	@Test
	public void testTowerCommunicationPropertyWeather() throws FileNotFoundException {
		String outputFileName = "towerCommunicationTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));

		TowerCommunication towerComm = new TowerCommunication(output);

		double temp = 73.5;
		double rainAmount = 1.2;
		double humidity = 33.2;
		double windSpeed = 12;
		char windDirection = 's';
		double[] raw = { temp, humidity, rainAmount, windSpeed, windDirection };

		WeatherData weather = new WeatherData(temp, humidity, rainAmount, windSpeed, windDirection, raw);
		PropertyChangeEvent event = new PropertyChangeEvent("source", TowerArchiveTest.PROPERTY_WEATHER, null, weather);

		towerComm.propertyChange(event); // should trigger write to output

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
