import javax.swing.JFrame;

public class LeagueInvader {
	GamePanel gp;
	JFrame f;
	int width=500;
	int height=800;
	public static void main(String[] args) {
	LeagueInvader li = new LeagueInvader();

}
	LeagueInvader(){
		f = new JFrame();
		gp = new GamePanel();
		setup();
	}
	void setup(){
		f.setVisible(true);
		f.setSize(width, height);
		f.add(gp);
		gp.startGame();
		f.addKeyListener(gp);
	}
}
