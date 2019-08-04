package tower;

import java.io.PrintStream;

import gui.DisplayCommunications;
import sensor.WeatherData;

public class TowerCommunication {

	private final DisplayCommunications myDisplay;

	private final TowerForecast myForecast;

	private final TowerArchive myArchive;

	public TowerCommunication(DisplayCommunications dc) {
		myArchive = new TowerArchive();
		myDisplay = dc;
		myForecast = new TowerForecast();
	}

	public TowerCommunication(PrintStream output, DisplayCommunications dc) {

		myArchive = new TowerArchive(output);
		myDisplay = dc;
		myForecast = new TowerForecast();
	}

	public void giveWeather(WeatherData data) {
		myArchive.giveWeather(data);
		myDisplay.giveForecast(myForecast.getWeatherForecast());
	}

}
