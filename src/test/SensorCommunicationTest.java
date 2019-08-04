package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

import gui.Display;
import gui.DisplayCommunications;
import sensor.SensorCommunication;
import sensor.WeatherData;
import tower.TowerCommunication;

public class SensorCommunicationTest {

	@Test
	public void testSensorCommunicationStatusOutput() {

		Display d = new Display();

		DisplayCommunications dc = new DisplayCommunications(d);

		TowerCommunication tc = new TowerCommunication(dc);

		SensorCommunication sensor = new SensorCommunication(tc, dc);

		assertEquals(true, sensor.getStatus());

	}

	@Test
	public void testTowerCommunicationPropertyWeather() throws FileNotFoundException {
		String outputFileName = "sensorCommunicationTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));

		Display d = new Display();
		DisplayCommunications dc = new DisplayCommunications(d);
		TowerCommunication towerComm = new TowerCommunication(output, dc);
		SensorCommunication sensor = new SensorCommunication(towerComm, dc);

		WeatherData wd = sensor.getWeather();

		try {
			Scanner input = new Scanner(new File(outputFileName));
			assertEquals(Arrays.toString(wd.rawValues).replace("[", "").replace("]", ""), input.nextLine());
			input.close();
		} catch (FileNotFoundException e) {
			fail("Failed to write output file " + outputFileName);
		}
	}

}
