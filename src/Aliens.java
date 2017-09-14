import java.awt.Color;
import java.awt.Graphics;

public class Aliens extends GameObject {
	
	int speed = 30;
	void update(){
		super.update();
		y+=speed;}
	void draw(Graphics g){
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);

	}
	
	Aliens(int x, int y, int w, int h){
		super(x, y, w, h);
		this.height= h;
		this.width=w;
		this.x=x;
		this.y=y;
	}
}
