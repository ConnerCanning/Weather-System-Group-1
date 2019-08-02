package test;

import static org.junit.Assert.*;
//import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.Test;
import sensor.WeatherData;
import tower.TowerArchive;

public class TowerArchiveTest {

	
	/**
	 * This test determines if the weatherdata object 
	 * that is passed as an argument to the
	 * towerarchive class correctly displays the output.
	 * 
	 * @throws FileNotFoundException if file is not found.
	 */
	@Test
	public void testTowerArchivePrintsWeatherToOutput() throws FileNotFoundException {
		String outputFileName = "towerArchiveTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));

		TowerArchive tower = new TowerArchive(output);

		double temp = 73.5;
		double rainAmount = 1.2;
		double humidity = 32.2;
		double windSpeed = 12.0;
		char windDirection = 's';
		double[] raw = { temp, rainAmount, humidity, windSpeed, windDirection };

		WeatherData weather = new WeatherData(temp, humidity, rainAmount, windSpeed, windDirection, raw);

		tower.giveWeather(weather); // should trigger write to output

		try {
			Scanner input = new Scanner(new File(outputFileName));
			assertEquals(Arrays.toString(raw).replace("[", "").replace("]", ""), input.nextLine());
			input.close();
		} catch (FileNotFoundException e) {
			fail("Failed to write output file " + outputFileName);
		}
	}

}
