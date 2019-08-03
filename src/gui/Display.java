package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

import sensor.WeatherData;

public class Display extends JFrame {
	 /**
		 * 
		 */
		private static final long serialVersionUID = 34683579683748L;
		
		public DisplayCommunications displayComm = new DisplayCommunications(this);
		public JLabel temp;
		public JLabel humidity;
		public JLabel rainfall;
		public JLabel windSpeed;
		public JLabel windDirection;
		public  JLabel forecast;
		public JLabel status;
		
		public Display()  {
			super("Weather Station");
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setSize(screenSize.width/4, screenSize.height/4);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			try {
				start();
				UIManager.setLookAndFeel(new MetalLookAndFeel());
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			} 
		}
		
		void start() throws UnsupportedLookAndFeelException {
			JPanel panel = new JPanel();
			temp = new JLabel();
			humidity = new JLabel();
			rainfall = new JLabel();
			windSpeed = new JLabel();
			windDirection = new JLabel();
			forecast = new JLabel();
			status = new JLabel();
			JButton onButton = new JButton("On");
			JButton offButton = new JButton("Off");
			ButtonGroup bg = new ButtonGroup();
			bg.add(onButton);
			bg.add(offButton);
			panel.setVisible(true);
			panel.add(onButton);
			panel.add(offButton);
			panel.add(temp);
			panel.add(humidity);
			panel.add(rainfall);
			panel.add(windSpeed);
			panel.add(windDirection);
			panel.add(status);
			panel.add(forecast);
			add(panel, BorderLayout.CENTER);
			//add(onButton);
			//add(offButton);
			onButton.setBounds(50, 150, 50, 50);
			onButton.setVisible(true);
			onButton.setBackground(Color.GREEN);
			offButton.setBounds(100, 150, 50, 50);
			offButton.setBackground(Color.RED);
			offButton.setVisible(true);
			temp.setBounds(75, 200, 100, 50);
			humidity.setBounds(75, 250, 100, 50);
			rainfall.setBounds(75, 300, 100, 50);
			windSpeed.setBounds(75, 350, 100, 50);
			windDirection.setBounds(75, 400, 100, 50);
			onButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					displayComm.onOffSensor(true);
				}
			});
			offButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					displayComm.onOffSensor(false);
				}
			});
		}
		
		public void giveWeather(WeatherData object) {
			this.temp.setText("Temperature: " + object.temp + " degrees F \n");
			this.humidity.setText("Humidity: " + (int) object.humid + "%");
			this.rainfall.setText("Rainfall: " + object.rain + " inches");
			this.windSpeed.setText("Wind Speed: " + object.windSpeed + " mph");
			this.windDirection.setText("Wind Direction: " + object.windDirection);
			this.status.setText("Sensor status is: " + object.sensorStatus);
		}
		
		public void giveForecast(String s) {
			forecast.setText("Forecast is: " + s);
		}
	}
