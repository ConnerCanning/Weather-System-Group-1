package test;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.Display;
import gui.DisplayCommunications;
import sensor.SensorCommunication;
import tower.TowerCommunication;
import interfaces.StatusReporter;

public class StatusReporterTest {

	@Test
	public void testSensorCommunicationStatusOutput() {

		Display d = new Display();

		DisplayCommunications dc = new DisplayCommunications(d);

		TowerCommunication tc = new TowerCommunication(dc);

		StatusReporter statusReporter = new SensorCommunication(tc, dc);
		assertTrue(statusReporter.getStatus());
	}

}
