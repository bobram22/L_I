import java.awt.Color;
import java.awt.Graphics;

public class Projectiles extends GameObject{
	int speed = 10;
	void update(){
		y-=speed;
		if(y==0){
			isAlive=false;
		}
	}
		void draw(Graphics g){
			g.setColor(Color.red);
			g.fillRect(x, y, width, height);
		}
Projectiles(int x,int y,int w,int h){
	this.height= h;
	this.width=w;
	this.x=x;
	this.y=y;
}
}
