The git and eclipse integration at some point messed up, so the project may seem broken if you pull it.
The directory pathing is messed up, so eclipse will not be able to find the main Runner class if you try to run it as-is from a pull.

The fix for this is:
1. Download the project as a .zip
2. Unzip it somewhere
3. Go to Eclipse and create a new Java project
4. Before hitting "finish" after providing project name, deselect the box labeled "Use default location"
5. Click browse
6. Navigate to the .src directory of the project wherever you unzipped it
7. Click "finish"

Now the project should be runnable!

Run the program by "running" the Runner class in the default package. 
This Runner instantiates the class objects and acts as a timer in the real world which gets the sensor to provide weather information each second. The SensorHardware creates pseudorandom weather readings, and provides them to WeatherDataAnalysis which encapsualtes this data into WeatherData objects. WeatherData objects are bassed by SensorCommunication to both TowerCommunication and DisplayCommunication. TowerCommunication takes in the object and sends it to TowerArchive for archiving, and TowerForecast in order to get a weather forcast from this information which it can send to the display. DisplayCommunication recieves a WeatherData object and a String with predicted forecast from the SensorCommunication and TowerCommunication, respectively. DisplayCommunication checks that the user would like to display the readings, and if they would it sends this information to Display. Display then updates the diplay panel with this most recent weather information. 

All of this is written in the documentation via diagrams and use case descriptions in the main directory of this project. 
