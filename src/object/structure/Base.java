package object.structure;

import render.rendable.Rendable;
import render.rendable.StaticImageRendable;

public abstract class Base implements IUpgradable, IObjectWithSingleRendable, ILive, IPhysical {
	
	protected StaticImageRendable image;
	
	protected int woodRequire;
	protected int farmRequire;
	protected int ironRequire;
	protected int farmPer;
	
	protected int currentLevel;
	protected int maxLevel;
	
	protected int fullHp, currentHp;
	
	private int physicalRadius;
	private boolean isDestroy; 
	
	public Base(int radius) {
		physicalRadius = radius;
		woodRequire = farmRequire = ironRequire = 0;
		currentLevel = maxLevel = 1;
		
		fullHp = currentHp = 0;
		isDestroy = false;
	}
	
	@Override
	public Rendable getSingleRendable() {
		return image;
	}
	
	@Override
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	@Override
	public int getWoodRequire() {
		return woodRequire;
	}
	@Override
	public int getIronRequire() {
		return ironRequire;
	}
	@Override
	public int getFarmRequire() {
		return farmRequire;
	}
	
	@Override
	public boolean isMaxLevel() {
		return currentLevel == maxLevel;
	}
	
	@Override
	public int getFullHp() {
		return fullHp;
	}
	
	@Override
	public int getCurrentHp() {
		return currentHp;
	}
	
	@Override
	public void decreaseHp(int hp) {
		currentHp -= hp;
		currentHp = Math.max(Math.min(currentHp, fullHp),0);
	}
	
	@Override
	public boolean isDie() {
		return currentHp <= fullHp;
	}
	
	@Override
	public int getPhysicalRadius() {
		return physicalRadius;
	}
	
	@Override
	public void setPhysicalRadius(int radius) {
		this.physicalRadius = radius;
	}
	
	@Override
	public int getPosX() {
		return image.getPosX();
	}
	
	@Override
	public int getPosY() {
		return image.getPosY();
	}
	
	@Override
	public void destroy() {
		isDestroy = true;
	}
	
	@Override
	public boolean isDestroy() {
		return isDestroy;
	}
	
	@Override
	public boolean isHitTest(IPhysical obj) {
		int delX = getPosX() - obj.getPosX();
		int delY = getPosY() - obj.getPosY();
		int radius = getPhysicalRadius() + obj.getPhysicalRadius();
		return delX * delX + delY * delY <= radius * radius;
	}
}
