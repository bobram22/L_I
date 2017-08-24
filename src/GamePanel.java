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
	RocketQueen ship;
	ObjectManager om;
GamePanel(){
	t = new Timer(1000/60, this);
	titleFont = new Font("Times New Roman",Font.BOLD,48);
	ship = new RocketQueen(250,700,50,50);
	om = new ObjectManager();
	om.addObject(ship);
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
		om.update();
	}
	void updatees(){
		
	}
	void drawms(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0,  1000, 1000);
		g.setColor(Color.yellow);
		g.setFont(titleFont);
		g.drawString("League", 190, 100);
		g.drawString("Invaders", 190, 135);
	}
	void drawgs(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 1000);
		om.draw(g);
	}
	void drawes(Graphics g){
	g.setColor(Color.RED);
	g.fillRect(0, 0, 1000, 1000);
	g.setColor(Color.BLACK);
	g.setFont(titleFont);
	g.drawString("Game", 190, 100);
	g.drawString("Over :'(", 190, 135);
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
if(e.getKeyCode()==KeyEvent.VK_LEFT){
	ship.speed=5;
}
else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
	ship.speed=-5;
}
else if(e.getKeyCode()==KeyEvent.VK_UP){
	ship.ospeed=5;
}
else if(e.getKeyCode()==KeyEvent.VK_DOWN){
	ship.ospeed=-5;
}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_LEFT){
		ship.speed=0;
	}
	else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
		ship.speed=0;
	}
	else if(e.getKeyCode()==KeyEvent.VK_UP){
		ship.ospeed=0;
	}
	else if(e.getKeyCode()==KeyEvent.VK_DOWN){
		ship.ospeed=0;
	}
}

}
