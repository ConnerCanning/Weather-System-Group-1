package test;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.Display;
import gui.DisplayCommunications;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import sensor.WeatherData;
import tower.TowerArchive;
import tower.TowerCommunication;

public class TowerCommunicationTest {

	/**
	 * This test determines if the weatherdata object that is passed as an argument
	 * to the towercommunication class correctly displays the output.
	 * 
	 * @throws FileNotFoundException if file is not found.
	 */
	@Test
	public void testTowerCommunicationPrintsWeatherToOutput() throws FileNotFoundException {
		String outputFileName = "towerCommunicationTest.txt";
		PrintStream output = new PrintStream(new File(outputFileName));

		Display d = new Display();
		DisplayCommunications dc = new DisplayCommunications(d);

		TowerCommunication towerComm = new TowerCommunication(output, dc);

		double temp = 75.5;
		double rainAmount = 1.2;
		double humidity = 53.2;
		double windSpeed = 15;
		char windDirection = 's';
		double[] raw = { temp, humidity, rainAmount, windSpeed, windDirection };

		WeatherData weather = new WeatherData(temp, humidity, rainAmount, windSpeed, windDirection, raw);

		towerComm.giveWeather(weather);
		try {
			Scanner input = new Scanner(new File(outputFileName));
			assertEquals(Arrays.toString(raw).replace("[", "").replace("]", ""), input.nextLine());
			input.close();
		} catch (FileNotFoundException e) {
			fail("Failed to write output file " + outputFileName);
		}
	}
}
