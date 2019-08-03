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
	public  JLabel label;
	public  JLabel forecast;
	
	public Display()  {
		super("Weather Station");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/2, screenSize.height/2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} 
	}
	
	void start() throws UnsupportedLookAndFeelException {
		Display frame = new Display();
		JPanel panel = new JPanel();
		label = new JLabel();
		forecast = new JLabel();
		JButton onButton = new JButton("On");
		JButton offButton = new JButton("Off");
		ButtonGroup bg = new ButtonGroup();
		bg.add(onButton);
		bg.add(offButton);
		panel.setVisible(true);
		panel.add(onButton);
		panel.add(offButton);
		panel.add(label);
		panel.add(forecast);
		add(panel, BorderLayout.CENTER);
		add(onButton);
		add(offButton);
		onButton.setBounds(50, 150, 50, 50);
		onButton.setVisible(true);
		onButton.setBackground(Color.GREEN);
		offButton.setBounds(100, 150, 50, 50);
		offButton.setBackground(Color.RED);
		offButton.setVisible(true);
		frame.add(panel);
		onButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				displayComm.onOffSensor(true);
				//WeatherData.sensorStatus = true;
			}
		});
		offButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				displayComm.onOffSensor(false);
				//WeatherData.sensorStatus = false;
			}
		});
	}
	
	public void giveWeather(WeatherData object) {
		displayComm.giveWeather(object);
	}
	
	public void giveForecast(String s) {
		forecast.setText(s);
	}

	/* @Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (WeatherData.getSensorStatus() == true) {
			/* timer.addActionListener(new ActionListener() {
				@Override			public void actionPerformed(ActionEvent evt) {
					label.setText(WeatherData.toString());
				}
			}); 
			WeatherData.timer.start();
		}
		else {
			WeatherData.timer.stop();
			label.setText("Sensor is off");
		}
	} */
	
}
