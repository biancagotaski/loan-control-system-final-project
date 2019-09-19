package com.gotaski.business;

public class Projector extends Product{
	private int id;
	private String resolution;
	private boolean hasLCD;
	private boolean hasLaser;
	
	public Projector(String resolution, boolean hasLCD, boolean hasLaser) {
		this.resolution = resolution;
		this.hasLCD = hasLCD;
		this.hasLaser = hasLaser;
	}
	
	public Projector(int id, String resolution, boolean hasLCD, boolean hasLaser) {
		this.id = id;
		this.resolution = resolution;
		this.hasLCD = hasLCD;
		this.hasLaser = hasLaser;
	}
	
	@Override
	public String toString() {
		//STILL DONT KNOW THE WAY THAT THIS SHOULD BE
		return super.toString();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public boolean isHasLCD() {
		return hasLCD;
	}
	public void setHasLCD(boolean hasLCD) {
		this.hasLCD = hasLCD;
	}
	public boolean isHasLaser() {
		return hasLaser;
	}
	public void setHasLaser(boolean hasLaser) {
		this.hasLaser = hasLaser;
	}
}
