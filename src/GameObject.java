import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive= true;
	Rectangle collisionBox;
	GameObject(int x, int y, int w, int h){
		this.height= h;
		this.width=w;
		this.x=x;
		this.y=y;
		collisionBox = new Rectangle(x,y,w,h);
		
	}
	void update(){
		collisionBox.setBounds(x, y, width, height);
}
	void draw(Graphics g){
		
	}
	
}
