package com.gotaski.business;

public class Printer extends Product {
	private int id;
	private boolean isLaser;
	private int maxLeaf;
	private boolean hasWifi;
	
	public Printer(boolean isLaser, int maxLeaf, boolean hasWifi) {
		this.isLaser = isLaser;
		this.maxLeaf = maxLeaf;
		this.hasWifi = hasWifi;
	}
	
	public Printer(int id, boolean isLaser, int maxLeaf, boolean hasWifi) {
		this.id = id;
		this.isLaser = isLaser;
		this.maxLeaf = maxLeaf;
		this.hasWifi = hasWifi;
	}
	
	//ALSO CREATE THE OVERRIDE OF STRING METHOD
	
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isLaser() {
		return isLaser;
	}
	public void setLaser(boolean isLaser) {
		this.isLaser = isLaser;
	}
	public int getMaxLeaf() {
		return maxLeaf;
	}
	public void setMaxLeaf(int maxLeaf) {
		this.maxLeaf = maxLeaf;
	}
	public boolean isHasWifi() {
		return hasWifi;
	}
	public void setHasWifi(boolean hasWifi) {
		this.hasWifi = hasWifi;
	}
}
