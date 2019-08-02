import static org.junit.Assert.*;

import org.junit.Test;

import sensor.SensorCommunication;
import tower.TowerCommunication;

public class SensorCommunicationTest {
	
	
	@Test
	public void testSensorCommunicationStatusOutput() {
		
		SensorCommunication sensor = new SensorCommunication();
		
		assertEquals(true, sensor.getStatus());
		
	}


}
