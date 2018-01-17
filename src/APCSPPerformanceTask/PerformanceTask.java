package APCSPPerformanceTask;

import java.applet.AudioClip;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PerformanceTask {
	 
public static void main(String[] args) {
	JFrame jf = new JFrame();
	 JPanel jp = new JPanel();
	 JButton jb = new JButton();
	jf.add(jp);
	jp.add(jb);
	jf.setVisible(true);
	jf.setSize(500, 200);
	jb.addActionListener(this);
	
}

private void playSound(String fileName) {
 AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
 sound.play();
   }

}
