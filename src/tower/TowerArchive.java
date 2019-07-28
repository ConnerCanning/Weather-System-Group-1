package tower;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintStream;

/**
 * Represents Tower Archive.  
 * @author Justin
 *
 */
public class TowerArchive implements PropertyChangeListener {
	private PrintStream output;
	
	String PROPERTY_WEATHER = "incoming weather data";
	
	public TowerArchive(PrintStream thePrintStream) {
		output = thePrintStream;
	}
	
	public TowerArchive() {
		this(System.out);
	}
	
	
	private void giveWeather(WeatherData data) {
		output.println(data);
	}

	@Override
	public void propertyChange(PropertyChangeEvent theEvent) {
		if (PROPERTY_WEATHER.equals(theEvent.getPropertyName())) {
            giveWeather((WeatherData) theEvent.getNewValue());
            
        }
		
	}
}
