package tower;

import java.awt.BorderLayout;
import java.awt.Component;
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

// Timer = new Timer(1000, new ActionListener()) - WeatherTower
 // PropertyChangeSupport pc = new PropertyChangeSupport() - WeatherTower
	//pcs.firePropertyChange("update", null, WeatherData.toString());
	
	
	
	Display() throws UnsupportedLookAndFeelException {
		super("Weather Station");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/2, screenSize.height/2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel();
		//WeatherData object = new WeatherData();
		//object.addPropertyChangeListener(this);
		UIManager.setLookAndFeel(new MetalLookAndFeel()); 
	}
	
	void start() throws UnsupportedLookAndFeelException {
		Display frame = new Display();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JLabel time = new JLabel();
		/* sb += "Temperature: " + WeatherData.getTemp();
		sb += " RainFall: " + WeatherData.getRainAmount();
		sb += " Humidity: " + WeatherData.getHumidity();
		sb += " Wind Speed: " + WeatherData.getWindSpeed();
		sb += " Wind Direction: " + WeatherData.getWindSpeed();
		label.setText(sb); */
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
				//label.setText(object.toString());
			}
		});
		offButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				label.setText("");
			}
		});
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
//		if (object.getSensorStatus() == 1) {
//			/* timer.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent evt) {
//					label.setText(object.toString());
//				}
//			}); */
//		}
//		else {
//			label.setText("Sensor is off");
//		}
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		new Display().start();
	}
	
}
