package tower;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import sensor.WeatherData;

/**
 * Represents Tower Archive.  
 * @author Justin
 *
 */
public class TowerArchive implements PropertyChangeListener{
	private PrintStream output;
	
	String PROPERTY_WEATHER = "incoming weather data";
	
	public TowerArchive(PrintStream thePrintStream) {
		output = thePrintStream;
	}
	
	public TowerArchive() {
		String outputFileName = "towerCommunicationTest.txt";
		PrintStream theOutput;
		try {
			theOutput = new PrintStream(new File(outputFileName));
			output = theOutput;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void giveWeather(WeatherData data) {
		output.print(data.rawValues[0]);
		for (int i = 1; i < data.rawValues.length; i++) {
			output.print(", " + data.rawValues[i]);
			
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent theEvent) {
		if (PROPERTY_WEATHER.equals(theEvent.getPropertyName())) {
            giveWeather((WeatherData) theEvent.getNewValue());
            
        }
		
	}
}
