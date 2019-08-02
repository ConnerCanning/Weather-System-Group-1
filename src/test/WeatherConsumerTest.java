package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import interfaces.WeatherConsumer;
import sensor.WeatherData;
import tower.TowerArchive;


public class WeatherConsumerTest {

	/**
	 * This test determines if the WeatherConsumer method call
	 * and the weatherdata object that is passed as an argument to the
	 * towerArchive class correctly displays the output.
	 * 
	 * @throws FileNotFoundException if file is not found.
	 */
	@Test
	void testWeatherConsumerPrintsWeatherToOutput() throws FileNotFoundException {
		String outputFileName = "towerArchiveTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));

		WeatherConsumer weatherConsumer = new TowerArchive(output);

		double temp = 73.5;
		double rainAmount = 1.2;
		double humidity = 32.2;
		double windSpeed = 12.0;
		char windDirection = 's';
		double[] raw = { temp, rainAmount, humidity, windSpeed, windDirection };

		WeatherData weather = new WeatherData(temp, humidity, rainAmount, windSpeed, windDirection, raw);

		weatherConsumer.giveWeather(weather); 

		try {
			Scanner input = new Scanner(new File(outputFileName));
			assertEquals(Arrays.toString(raw).replace("[", "").replace("]", ""), input.nextLine());
			input.close();
		} catch (FileNotFoundException e) {
			fail("Failed to write output file " + outputFileName);
		}
	}

}
