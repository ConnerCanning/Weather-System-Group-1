package test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

import sensor.SensorCommunication;
import sensor.WeatherData;
import tower.TowerCommunication;

public class SensorCommunicationTest {
	
	@Test
	public void testSensorCommunicationStatusOutput() {
		
		TowerCommunication tc = new TowerCommunication( new DisplayCommunications( new Display()));
		
		SensorCommunication sensor = new SensorCommunication(tc);
		
		assertEquals(true, sensor.getStatus());
		
	}
	
	@Test
	public void testTowerCommunicationPropertyWeather() throws FileNotFoundException {
		String outputFileName = "sensorCommunicationTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));

		TowerCommunication towerComm = new TowerCommunication(output);
		SensorCommunication sensor = new SensorCommunication(towerComm);

		WeatherData wd = sensor.getWeather();
		
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
