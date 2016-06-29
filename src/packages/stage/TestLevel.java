package packages.stage;

import packages.comp.Asteroid_Small;
import packages.comp.Ship_Player;
import packages.main.Main;

public class TestLevel extends GameStage{

	public TestLevel(){
		super("testlevel");
		
		System.out.println("Entering TestLevel...");
		
		this.players.add(new Ship_Player(Main.width / 2, Main.height / 2));
		this.asteroids.add(new Asteroid_Small(Main.width * 3/4, Main.height * 3/4, 25, 25, -.04, .02));
		this.asteroids.add(new Asteroid_Small(Main.width * 1/4, Main.height * 1/4, 25, 25, .02, .04));
		this.asteroids.add(new Asteroid_Small(Main.width * 3/4, Main.height * 2/4, 25, 25, .02, .03));
	}

	@Override
	public void act() {
		super.act();
	}

	@Override
	public void LMBDown(int x, int y) {
		// TODO Auto-generated method stub
		super.LMBDown(x, y);
	}

	@Override
	public void LMBUp(int x, int y) {
		// TODO Auto-generated method stub
		super.LMBUp(x, y);
	}

	@Override
	public void RMBDown(int x, int y) {
		// TODO Auto-generated method stub
		super.RMBDown(x, y);
	}

	@Override
	public void RMBUp(int x, int y) {
		// TODO Auto-generated method stub
		super.RMBUp(x, y);
	}

	@Override
	public void mouseAt(int x, int y) {
		// TODO Auto-generated method stub
		super.mouseAt(x, y);
	}

	@Override
	public void scrollWheelAt(int x) {
		// TODO Auto-generated method stub
		super.scrollWheelAt(x);
	}

	@Override
	public void keyUp(int k) {
		// TODO Auto-generated method stub
		super.keyUp(k);
		
		for (int i = 0; i < players.size(); i++){
			if (players.get(i) instanceof Ship_Player){
				((Ship_Player)(players.get(i))).keyUp(k);
			}
		}
	}

	@Override
	public void keyDown(int i) {
		// TODO Auto-generated method stub
		super.keyDown(i);
	}
	
}
