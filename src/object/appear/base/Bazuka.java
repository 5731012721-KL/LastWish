package object.appear.base;

import object.appear.bullet.BazukaBullet;
import object.structure.BaseAttack;
import object.structure.Bullet;
import frame.GameFrame;

public class Bazuka extends BaseAttack {

	public Bazuka(float ratio) {
		super("base_bazuka", ratio);
		
		this.fullHp = 65;
		this.fireRate = 3;
		this.woodRequire = 1400;
		this.ironRequire = 1400;
		this.range = 100;
		this.damage= 40;
		this.farmPer = 5;
		this.maxLevel = 5;
		
		this.currentHp = this.fullHp;
	}

	@Override
	public void statIncrease() {
		this.fullHp += 45;
		this.currentHp += 55;
		this.damage +=20;
		this.woodRequire += 400;
		this.ironRequire += 500;
		this.range += 2;
	}
	
	@Override
	protected Bullet generateBullet(float angle) {
		return new BazukaBullet(this, damage, getPosX(), getPosY(), angle);
	}
}
