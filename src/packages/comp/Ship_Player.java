package packages.comp;

import java.awt.event.KeyEvent;

import packages.main.Main;
import packages.stage.GameStage;

public class Ship_Player extends Ship_Default
{
	// all cooldowns are in microseconds
	private int cooldown_Q, cooldown_W, cooldown_E, cooldown_R;
	protected int cooldown_standard_attack;
	protected long time_last_attack;
	private long time_last_Q, time_last_W, time_last_E, time_last_R;
	
	public Ship_Player(double x, double y){
		super(x, y);
		this.cooldown_Q = 10000;
		this.cooldown_W = 20000;
		this.cooldown_E = 15000;
		this.cooldown_R = 50000;
		this.cooldown_standard_attack = 500;
		this.time_last_attack = 0;
		this.time_last_Q = 0;
		this.time_last_W = 0;
		this.time_last_E = 0;
		this.time_last_R = 0;
	}
	
	public void act(GameStage stage)
	{
		// temporary value for angle maths
		double val;
		// TODO
		// should probably be simplified
		if (Main.mouseX > posX){
			val = Math.atan((Main.mouseY - posY) / (Main.mouseX - posX));
			if (Math.abs(val - angle) > .01){
				spinVel = (float) (val - angle) / 50;
			} else {
				spinVel = 0;
			}
		} else {
			val = Math.atan((Main.mouseY - posY) / (Main.mouseX - posX));
			if (Math.abs(val - angle + Math.PI) > .01){
				spinVel = (float) (val - angle + Math.PI) / 50;
			} else {
				spinVel = 0;
			}
		}
		
		if (stage.isLMB){
			// attack
			// only happens when cooldown is ready
			if (cooldown_standard_attack <= System.currentTimeMillis() - time_last_attack){
				time_last_attack = System.currentTimeMillis();
				stage.addLaser(new Laser_Default(posX, posY, Math.cos(angle) * 2, Math.sin(angle) * 2));
			}
		}
		// movement
		if (stage.isRMB){
			accelX = Math.cos(angle) / 300;
			accelY = Math.sin(angle) / 300;
		}
		// if nothing is pressed stop accelerating
		if (!stage.isRMB){
			accelX = 0;
			accelY = 0;
		}
		
		super.act(stage);
	}
	
	public void keyUp(int k){
		if (k == KeyEvent.VK_Q){
			if (System.currentTimeMillis() - time_last_Q >= cooldown_Q){
				System.out.println("Q - ing");
				time_last_Q = System.currentTimeMillis();
			}
		}
	}
	
}
