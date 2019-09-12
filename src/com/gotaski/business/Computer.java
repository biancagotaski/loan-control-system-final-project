package com.gotaski.business;

public class Computer extends Product {
	private String operationalSystem;
	private int cores;
	private boolean hasAccessories; //it means if the loan will be with mouse, keyboard and speaker/
	
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
