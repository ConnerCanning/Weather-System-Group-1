package test;

import static org.junit.Assert.*;

import org.junit.Test;

import sensor.SensorHardware;

public class SensorHardwareTest {

	@Test
	public void testSensorHardwareArrayLength() {
		
		SensorHardware hard = new SensorHardware();
		
		assertEquals(5, hard.getReadings().length);

	}

}
