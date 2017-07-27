import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
GamePanel(){
	t = new Timer(1000/60, this);
	titleFont = new Font("Times New Roman",Font.BOLD,48);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState == MENU_STATE){
			updatems();
		}else if(currentState == GAME_STATE){
			updategs();
		}else if(currentState == END_STATE){
			updatees();
		}


	}
	void updatems(){
		
	}
	void updategs(){
		
	}
	void updatees(){
		
	}
	void drawms(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0,  1000, 1000);
		g.setFont(titleFont);
		g.drawString("League", 250, 100);
		g.drawString("Invaders", 250, 110);
	}
	void drawgs(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 1000);
	}
	void drawes(Graphics g){
	g.setColor(Color.RED);
	g.fillRect(0, 0, 1000, 1000);
	}
	void startGame(){
		t.start();
	}
public void paintComponent(Graphics g){
	if(currentState == MENU_STATE){
		drawms(g);
	}else if(currentState == GAME_STATE){
		drawgs(g);
	}else if(currentState == END_STATE){
		drawes(g);
	}


	}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("");
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("pizza");
	if(e.getKeyCode()==KeyEvent.VK_ENTER){
		currentState++;
	}
	if(currentState > END_STATE){
		currentState = MENU_STATE;
	}

}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

}
