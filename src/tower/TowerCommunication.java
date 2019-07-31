package tower;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.PrintStream;

import javax.swing.Timer;

import sensor.WeatherData;

public class TowerCommunication implements PropertyChangeTower, PropertyChangeListener {
	
	/** Amount of milliseconds between each call to the timer. */
    private static final int TIMER_FREQUENCY = 31; 
	
	private WeatherData myRecentData;
	private Timer myTimer;
	private final TimeControls myTime;
    
	
	private final TowerForecast myForecast;
	
	/**
     * Manager for Property Change Listeners.
     */
    private final PropertyChangeSupport myPcs;
    
    public TowerCommunication() {
    	myPcs = new PropertyChangeSupport(this);
    	myTime = new Time();
    	myTimer = new Timer(TIMER_FREQUENCY, this::handleTimer);
    	myTimer.start();
    	final TowerArchive archive = new TowerArchive();
    	myForecast = new TowerForecast();
    	this.addPropertyChangeListener(archive);
    }
    
    // Added overloaded constructor for testing purposes to pass PrintStream to TowerArchive
    public TowerCommunication(PrintStream output) {
    	myPcs = new PropertyChangeSupport(this);
    	myTime = new Time();
    	myTimer = new Timer(TIMER_FREQUENCY, this::handleTimer);
    	myTimer.start();
    	final TowerArchive archive = new TowerArchive(output);
    	myForecast = new TowerForecast();
    	this.addPropertyChangeListener(archive);
    }
    
    /**
     * Event handler for the timer. 
     * @param theEvent the fired event
     */
    private void handleTimer(final ActionEvent theEvent) { //NOPMD
        myTime.advance(TIMER_FREQUENCY);
    }
    

    @Override
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(theListener);
        
    }

    @Override
    public void addPropertyChangeListener(final String thePropertyName,
                                          final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(thePropertyName, theListener);
    }

    @Override
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.removePropertyChangeListener(theListener);
    }

    @Override
    public void removePropertyChangeListener(final String thePropertyName,
                                             final PropertyChangeListener theListener) {
        myPcs.removePropertyChangeListener(thePropertyName, theListener);
    }


	@Override
	public void propertyChange(PropertyChangeEvent theEvent) {
		if (PROPERTY_WEATHER.equals(theEvent.getPropertyName())) {
			myRecentData = (WeatherData) theEvent.getNewValue();
			myPcs.firePropertyChange(PROPERTY_WEATHER, null, theEvent.getNewValue());
        } else if (PROPERTY_FORECAST.equals(theEvent.getPropertyName())) {
        	myPcs.firePropertyChange(PROPERTY_FORECAST, null, myForecast.getWeatherForecast());
        }
		
	}
    

}
