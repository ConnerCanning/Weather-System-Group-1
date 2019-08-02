package test;

import static org.junit.Assert.*;

import org.junit.Test;

import sensor.SensorDataAnalysis;
import sensor.WeatherData;

public class SensorDataAnalysisTest {

	@Test
	public void test() {
		SensorDataAnalysis sensor = new SensorDataAnalysis();
		assertTrue(sensor.getWeather() instanceof WeatherData);
	}

}
