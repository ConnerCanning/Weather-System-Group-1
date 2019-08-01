import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import sensor.WeatherData;
import tower.TowerArchive;
import tower.WeatherConsumer;


//This test will run if Justin changes his method to public and implements the WeatherConsumer interface.


class WeatherConsumerTest {
	
	public static final String PROPERTY_WEATHER = "incoming weather data";

	@Test
	void testWeatherConsumerPrintsWeatherToOutput() throws FileNotFoundException {

		String outputFileName = "weatherConsumerTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));
		WeatherConsumer consumer = new TowerArchive(output);
	
		double temp = 73.5;
		double rainAmount = 1.2;
		double humidity = 33.2;
		double windSpeed = 12;
		char windDirection = 's';
		double[] raw = {temp, humidity, rainAmount, windSpeed, windDirection};
		
		WeatherData weather = new WeatherData(temp, rainAmount, humidity, 
				windSpeed, windDirection, raw);
		PropertyChangeEvent event = new PropertyChangeEvent("source", PROPERTY_WEATHER, null, weather);
		
		((TowerArchive) consumer).propertyChange(event);
			
		try {
			Scanner input = new Scanner(new File(outputFileName));
			assertEquals(Arrays.toString(raw).replace("[", "").replace("]", ""), input.nextLine());
			
			input.close();
		} catch (FileNotFoundException e) {
			fail("Failed to write output file " + outputFileName);
		}

	}

}
