package APCSPPerformanceTask;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PerformanceTask implements ActionListener {
	//This area is where all the parts of the screen are first made
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JButton jb = new JButton();
	JButton JB = new JButton();
	JLabel jl = new JLabel();

	public static void main(String[] args) {
		PerformanceTask PT = new PerformanceTask();
		PT.Screen();

	}
//Makes the visual screen and collects all the parts to bring them together 
	public void Screen() {
		jf.add(jp);
		jp.add(jb);
		jp.add(JB);
		jp.add(jl);
		jl.setText("Spanish Translator");
		jb.setText("Hello");
		JB.setText("Good Bye");
		jf.setVisible(true);
		jf.setSize(500, 200);
		JB.addActionListener(this);
		jb.addActionListener(this);
	}
//Monitors if the buttons have been activated
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ee = e.getSource();
		if (ee.equals(jb)) {
			playSound("Hello.wav");
		}
		else if (ee.equals(JB)) {
			playSound("GoodBye.wav");
		}
	}
// This method will call the file and play the audio
	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}
}
