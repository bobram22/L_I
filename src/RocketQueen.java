import java.awt.Color;
import java.awt.Graphics;

public class RocketQueen extends GameObject {
	int speed;
	int ospeed;
	void update(){
		super.update();
		x-=speed;
		y-=ospeed;
	}
		void draw(Graphics g){
			g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

		}
	
	RocketQueen(int x, int y, int w, int h){
		super(x,y,w,h);
		this.height= h;
		this.width=w;
		this.x=x;
		this.y=y;
		speed=0;
		ospeed=0;
	}
}

