package tower;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.PrintStream;

import gui.Display;
import sensor.WeatherData;

public class TowerCommunication {
	
    
	private final DisplayCommunication myDisplay;
    
	
	private final TowerForecast myForecast;
	
	private final TowerArchive myArchive;
	
	/**
     * Manager for Property Change Listeners.
     */
    private final PropertyChangeSupport myPcs;
    
    public TowerCommunication() {
    	myPcs = new PropertyChangeSupport(this);
    	
    	myArchive = new TowerArchive();
    	myDisplay = new DisplayCommunication();
    	myForecast = new TowerForecast();
    }
    
    // Added overloaded constructor for testing purposes to pass PrintStream to TowerArchive
    public TowerCommunication(PrintStream output) {
    	myPcs = new PropertyChangeSupport(this);
    	myArchive = new TowerArchive(output);
    	myDisplay = new DisplayCommunication();
    	myForecast = new TowerForecast();
    }
    
    
    public void giveWeather(WeatherData data) {
    	myArchive.giveWeather(data);
    	myDisplay.giveForecast(myForecast.getWeatherForecast());
    }

    

}
