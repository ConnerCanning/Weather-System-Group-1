package tower;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TowerForecastTest {

	@Test
	public void testGetWeatherForecastReturnsAllowableForecast() {
		List<String> availableForecasts = 
				Stream.of("Clear", "Mostly Clear", "Partly Cloudy", "Mostly Cloudy", "Cloudy").
				collect(Collectors.toList());
		
		TowerForecast towerForecast = new TowerForecast();
		
		String actualForecast = towerForecast.getWeatherForecast();
		
		assertTrue(availableForecasts.contains(actualForecast));
		
	}

}
