package com.gotaski.business;

public class Computer extends Product {
	
	private int id;
	private String operationalSystem;
	private int cores;
	private boolean hasAccessories; //it means if the loan will be with mouse, keyboard and speaker/
	
	public Computer(String operationalSystem, int cores, boolean hasAccessories) {
		this.operationalSystem = operationalSystem;
		this.cores = cores;
		this.hasAccessories = hasAccessories;
	}
	
	public Computer(int id, String operationalSystem, int cores, boolean hasAccessories) {
		this.id = id;
		this.operationalSystem = operationalSystem;
		this.cores = cores;
		this.hasAccessories = hasAccessories;
	}
	
	//ALSO CREATE THE OVERRIDE OF STRING METHOD
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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
