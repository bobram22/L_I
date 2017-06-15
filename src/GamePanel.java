import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	Timer t;
GamePanel(){
	t = new Timer(1000/60, this);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	void startGame(){
		t.start();
	}
public void paintComponent(Graphics g){
	g.fillRect(10, 10, 100, 100);

	}

}
