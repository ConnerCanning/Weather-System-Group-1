import static org.junit.Assert.*;

import org.junit.Test;

public class StatusReporterTest {

	@Test
	void test() {

		SensorCommunication sensor;
		StatusReporter statusReporter = sensor; // instantiate new status reporter when it exists
		assertTrue(statusReporter.getStatus());
	}

}
