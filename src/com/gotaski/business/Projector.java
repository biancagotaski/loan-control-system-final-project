package com.gotaski.business;

public class Projector extends Product{
	private String resolution;
	private boolean hasLCD;
	private boolean hasLaser;
	
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
