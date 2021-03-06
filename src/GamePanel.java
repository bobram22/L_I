import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	private int score;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;

GamePanel(){
	t = new Timer(1000/60, this);
	titleFont = new Font("Times New Roman",Font.BOLD,48);
	ship = new RocketQueen(250,700,50,50);
	om = new ObjectManager();
	om.addObject(ship);
	try {
		alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
		rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
		bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

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
		om.manageEnemies();
		om.checkCollision();
		if(ship.isAlive == false){
			currentState=END_STATE;
			 score =	om.getScore();
			om.reset();
			ship = new RocketQueen(250,700,50,50);
			om.addObject(ship);
			om.setScore(0);
		}
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
		g.drawImage(GamePanel.spaceImg, 0, 0, 1000, 1000, null);
		om.draw(g);
	}
	void drawes(Graphics g){
	g.setColor(Color.RED);
	g.fillRect(0, 0, 1000, 1000);
	g.setColor(Color.BLACK);
	g.setFont(titleFont);
	g.drawString("Game", 190, 100);
	g.drawString("Over :'(", 190, 135);
	g.drawString("Score: " + score, 190, 185);
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
else if (e.getKeyCode()==KeyEvent.VK_SPACE){
	om.addObject(new Projectiles(ship.x+ship.width/2, ship.y, 10, 10));
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
