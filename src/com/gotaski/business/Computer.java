package com.gotaski.business;

public class Computer extends Product {
	
	private String operationalSystem;
	private int cores;
	private boolean hasAccessories; //it means if the loan will be with mouse, keyboard and speaker/
	
	public Computer(int id) {
		super(id);
	}
	
	public Computer(String name, float value, int serialNumber, String brand) {
		super(name, value, serialNumber, brand);
	}
	
	public Computer(String name, float value, int serialNumber, String brand, String operationalSystem, int cores, boolean hasAccessories) {
		this(name, value, serialNumber, brand);
		this.setOperationalSystem(operationalSystem);
		this.setCores(cores);
		this.setHasAccessories(hasAccessories);
	}

	public Computer(int id, String name, float value, int serialNumber, String brand, String operationalSystem, int cores, boolean hasAccessories) {
		this(name, value, serialNumber, brand, operationalSystem, cores, hasAccessories);
		this.setId(id);
	}
	
	public String toString() {
		return String.format("%s - %s - %s - %s",
					super.toString(),
					this.operationalSystem,
					this.cores,
					this.hasAccessories
				);
	}
	
	public void display() {
		super.display();
		
		System.out.println("Computer");
		System.out.println(this.toString());
	}
	
	public String getOperationalSystem() {
		return operationalSystem;
	}
	public void setOperationalSystem(String operationalSystem) {
		this.operationalSystem = operationalSystem;
	}
	public int getCores() {
		return cores;
	}
	public void setCores(int cores) {
		this.cores = cores;
	}
	public boolean isHasAccessories() {
		return hasAccessories;
	}
	public void setHasAccessories(boolean hasAccessories) {
		this.hasAccessories = hasAccessories;
	}
}
