import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatusReporterTest {

	@Test
	void testStatusReporterIsOn() {
		StatusReporter reporter = null; //instantiate new status reporter when it exists
		assertTrue(reporter.getStatus());
	}

}
