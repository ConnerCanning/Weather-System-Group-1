package src;

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
	
	public TowerArchive(PrintStream thePrintStream) {
		output = thePrintStream;
	}
	
	public TowerArchive() {
		this(System.out);
	}
	
	
	public void giveWeather(WeatherData data) {
		output.println(data);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
