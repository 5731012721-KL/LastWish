package object.appear.base;

import object.structure.BaseAttack;
import frame.GameFrame;

public class Tank extends BaseAttack {

	public Tank(float ratio) {
		super("base_tank", ratio);
		
		this.fullHp = 80;
		this.fireRate = 2;
		this.woodRequire = 1500;
		this.ironRequire = 1200;
		this.rang =80;
		this.damage= 8;
		this.farmPer = 4;
		this.maxLevel = 5;
		
		this.currentHp = this.fullHp;
	}
	
	public static boolean canBuild(int farm, int wood, int iron) {
		return 
			farm >= 4 &&
			wood >= 1100 &&
			iron >=830;
	}

	@Override
	public void upgrade(int level) {
		level++;
		if(level <= maxLevel) {
			this.fullHp += 40;
			this.currentHp +=40;
			this.damage +=3;
			this.woodRequire += 500;
			this.ironRequire += 450;
			this.rang += 2;
		} else {
			level = maxLevel;
		}
		this.currentLevel = level;
	}
	
	@Override
	public void attack(GameFrame gameFrame) {
		//System.out.println("shooter1 attack");
	}
	
}