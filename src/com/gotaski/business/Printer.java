package com.gotaski.business;

public class Printer extends Product {
	private boolean isLaser;
	private int maxLeaf;
	private boolean hasWifi;
	
	public Printer(int id) {
		super(id);
	}
	
	public Printer(int id, String name, float value, int serialNumber, String brand, boolean isLaser, int maxLeaf, boolean hasWifi) {
		this(name, value, serialNumber, brand, isLaser, maxLeaf, hasWifi);
		this.setId(id);
	}
	
	public Printer(String name, float value, int serialNumber, String brand, boolean isLaser, int maxLeaf, boolean hasWifi) {
		this(name, value, serialNumber, brand);
		this.setLaser(isLaser);
		this.setMaxLeaf(maxLeaf);
		this.setHasWifi(hasWifi);
	}
	
	public Printer(String name, float value, int serialNumber, String brand) {
		super(name, value, serialNumber, brand);
	}
	
	
	public String toString() {
		return String.format("%s - %s - %d - %s",
				super.toString(),
				this.isLaser,
				this.maxLeaf,
				this.hasWifi
				);
	}
	
	public void display() {
		super.display();
		
		System.out.println("Printer");
		System.out.println(this.toString());
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
