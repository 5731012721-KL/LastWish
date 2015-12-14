package object.appear.base;

import object.appear.bullet.BoldBullet;
import object.structure.BaseShooter;
import object.structure.Bullet;
import render.RendableHolder;
import frame.GameFrame;

public class Shooter4 extends BaseShooter {
	
	public Shooter4(float ratio) {
		super("base_shooter4", ratio);
		
		this.fullHp = 170;
		this.fireRate = 5;
		this.woodRequire = 1400;
		this.ironRequire = 1600;
		this.rang = Integer.MAX_VALUE;
		this.farmPer = 10;
		this.damage = 30;
		this.maxLevel = 10;
		
		this.currentHp = this.fullHp;
	}
	
	public static boolean canBuild(int farm, int wood, int iron) {
		return 
			farm >=10 &&
			wood >= 1000 &&
			iron >= 1400;
	}

	@Override
	public void upgrade(int level) {
		level++;
		if(level <= maxLevel) {
			this.fullHp += 60;
			this.currentHp += 60;
			this.woodRequire += 500;
			this.ironRequire += 400;
			this.damage +=20;
		} else {
			level = maxLevel;
		}
		this.currentLevel = level;
	}

	@Override
	public void attack(GameFrame gameFrame) {
		Bullet b = new BoldBullet(this, getDamage(), getPosX(), getPosY(), getSingleRendable().getAngle());
		RendableHolder.add(b);
		gameFrame.getBulletList().add(b);
	}
	
	@Override
	protected Bullet generateBullet(float angle) {
		return new BoldBullet(this, damage, getPosX(), getPosY(), angle);
	}
	
}
