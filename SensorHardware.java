import java.util.Random;

public class SensorHardware {

	Random rand;
	private double[] last = {70.0, 0.0, 0.0, 3.0, 3.0};
	// starting with 70 degrees, no humidity, no rain, 3 mph winds going south
	
	public SensorHardware() {
		rand = new Random();
	}
	
	public double[] getReadings() {
		double[] toReturn = new double[5];		
		
		for (int i = 0; i < last.length; i++) {
			double temp = last[i];
			if (i == 1)
				temp /= 5;	// adjust humidity to scale
			
			int r = rand.nextInt(10);	// randomly select weather pattern
			if (r < 2) 		// 20% chance to go down
				temp--;		
			if (r > 7)		// 20% chance to go up
				temp++;					
			
			if (temp < 0)	// no negative values allowed
				temp = 0;
			
			if (i == 1)
				temp *= 5;	// humidity will go 5% at a time
			
			toReturn[i] = temp;	// save new value
		}
		last = toReturn;	// this new weather is now our previous reference
		return toReturn;	// return the weather we just generated
	}
}
