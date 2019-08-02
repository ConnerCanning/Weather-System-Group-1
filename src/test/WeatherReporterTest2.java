package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

import interfaces.WeatherReporter;
import sensor.SensorCommunication;
import sensor.WeatherData;
import tower.TowerCommunication;

class WeatherReporterTest2 {

	@Test
	void test() throws FileNotFoundException {
		
		String outputFileName = "sensorCommunicationTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));

		TowerCommunication towerComm = new TowerCommunication(output);
		WeatherReporter weatherReporter = new SensorCommunication(towerComm);

		WeatherData wd = weatherReporter.getWeather();
		
		// now check to see if the file was written correctly

		try {
			Scanner input = new Scanner(new File(outputFileName));
			assertEquals(Arrays.toString(wd.rawValues).replace("[", "").replace("]", ""), input.nextLine());
			input.close();
		} catch (FileNotFoundException e) {
			fail("Failed to write output file " + outputFileName);
		}
	}

}
