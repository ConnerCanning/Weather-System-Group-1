package gui;

import java.awt.BorderLayout;
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

public class Display extends JFrame implements PropertyChangeListener {
 /**
	 * 
	 */
	private static final long serialVersionUID = 34683579683748L;
	
	
	public static WeatherData object = new WeatherData(WeatherData.temp, WeatherData.rainAmount, WeatherData.humidity, WeatherData.windSpeed, WeatherData.windDirection, WeatherData.sensorStatus);
	public static JLabel label;
	public static JLabel time;
	
	Display()  {
		super("Weather Station");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/2, screenSize.height/2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		object.pcs.addPropertyChangeListener(this);
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
		time = new JLabel();
		JButton onButton = new JButton("On");
		JButton offButton = new JButton("Off");
		ButtonGroup bg = new ButtonGroup();
		bg.add(onButton);
		bg.add(offButton);
		panel.add(onButton);
		panel.add(offButton);
		panel.add(label);
		panel.add(time);
		add(panel, BorderLayout.CENTER);
		add(onButton, BorderLayout.SOUTH);
		add(offButton, BorderLayout.SOUTH);
		frame.add(panel);
		onButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				label.setText(object.toString());
				WeatherData.sensorStatus = true;
			}
		});
		offButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				label.setText("");
				WeatherData.sensorStatus = false;
			}
		});
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (WeatherData.getSensorStatus() == true) {
			/* timer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					label.setText(WeatherData.toString());
				}
			}); */
			WeatherData.timer.start();
		}
		else {
			WeatherData.timer.stop();
			label.setText("Sensor is off");
		}
	} 
	
}

	
}
