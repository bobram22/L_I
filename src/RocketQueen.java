import java.awt.Color;
import java.awt.Graphics;

public class RocketQueen extends GameObject {
	int speed;
	int ospeed;
	void update(){
		x-=speed;
		y-=ospeed;
	}
		void draw(Graphics g){
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	
	RocketQueen(int x, int y, int w, int h){
		this.height= h;
		this.width=w;
		this.x=x;
		this.y=y;
		speed=0;
		ospeed=0;
	}
}

