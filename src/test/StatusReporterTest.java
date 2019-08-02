package test;
import static org.junit.Assert.*;

import org.junit.Test;

import sensor.SensorCommunication;
import tower.TowerCommunication;
import interfaces.StatusReporter;

public class StatusReporterTest {

	@Test
	void testSensorCommunicationStatusOutput() {

		StatusReporter statusReporter = new SensorCommunication(new TowerCommunication());
		assertTrue(statusReporter.getStatus());
	}

}
