package com.gotaski.business;

import java.util.Set;

public class Projector extends Product{
	private String resolution;
	private boolean hasLCD;
	private boolean hasLaser;
	
	public Projector(int id) {
		super(id);
	}	
	
	public Projector(String name, float value, int serialNumber, String brand, String resolution, boolean hasLCD, boolean hasLaser) {
		this(name, value, serialNumber, brand);
		this.setResolution(resolution);
		this.setHasLCD(hasLCD);
		this.setHasLaser(hasLaser);
	}
	
	public Projector(String name, float value, int serialNumber, String brand) {
		super(name, value, serialNumber, brand);
	}
	
	public Projector(int id, String name, float value, int serialNumber, String brand, String resolution, boolean hasLCD, boolean hasLaser) {
		this(name, value, serialNumber,  brand, resolution, hasLCD, hasLaser);
		this.setId(id);
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s",
				super.toString(),
				this.resolution,
				this.hasLCD,
				this.hasLaser
			);
	}
	
	public void display() {
		super.display();
		
		System.out.println("Projector");
		System.out.println(this.toString());
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
