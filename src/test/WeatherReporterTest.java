package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

import gui.Display;
import gui.DisplayCommunications;
import interfaces.WeatherReporter;
import sensor.SensorCommunication;
import sensor.WeatherData;
import tower.TowerCommunication;

public class WeatherReporterTest {

	@Test
	public void test() throws FileNotFoundException {

		String outputFileName = "sensorCommunicationTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));

		Display d = new Display();
		DisplayCommunications dc = new DisplayCommunications(d);
		TowerCommunication towerComm = new TowerCommunication(output, dc);
		WeatherReporter weatherReporter = new SensorCommunication(towerComm, dc);

		WeatherData wd = weatherReporter.getWeather();

		try {
			Scanner input = new Scanner(new File(outputFileName));
			assertEquals(Arrays.toString(wd.rawValues).replace("[", "").replace("]", ""), input.nextLine());
			input.close();
		} catch (FileNotFoundException e) {
			fail("Failed to write output file " + outputFileName);
		}
	}

}