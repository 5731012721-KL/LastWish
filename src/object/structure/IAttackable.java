package object.structure;

import frame.GameFrame;

public interface IAttackable {
	public int getDamage();
	public int getFireRate();
	public int getRang();
	public void increaseTime();
	public boolean isAttack();
	public void attack(GameFrame gameFrame);
}
