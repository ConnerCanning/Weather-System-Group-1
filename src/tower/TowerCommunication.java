package tower;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TowerCommunication implements PropertyChangeTower, PropertyChangeListener {
	
	private final TowerForecast myForecast;
	
	/**
     * Manager for Property Change Listeners.
     */
    private final PropertyChangeSupport myPcs;
    
    public TowerCommunication() {
    	myPcs = new PropertyChangeSupport(this);
    	final TowerArchive archive = new TowerArchive();
    	myForecast = new TowerForecast();
    	this.addPropertyChangeListener(archive);
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
			myPcs.firePropertyChange(PROPERTY_WEATHER, null, theEvent.getNewValue());
        } else if (PROPERTY_FORECAST.equals(theEvent.getPropertyName())) {
        	myPcs.firePropertyChange(PROPERTY_FORECAST, null, myForecast.getWeatherForecast());
        }
		
	}
    

}
