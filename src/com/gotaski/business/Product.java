package com.gotaski.business;

import java.util.Set;

public abstract class Product {
	
	private int id;
	private String name;
	private float value;
	private int serialNumber;
	private String brand;
	private Set<Loan> loans;
	

	
	public Product(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Product(String name, float value, int serialNumber, String brand) {
		this.name = name;
		this.value = value;
		this.serialNumber = serialNumber;
		this.brand = brand;
	}
	
	public Product(int id, String name, float value, int serialNumber, String brand) {
		this(name, value, serialNumber, brand);
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %2.f - %d - %s",
					this.id,
					this.name,
					this.value,
					this.serialNumber,
					this.brand
				);
	}
	
	
	public void display() {
		System.out.printf("Produto: ");
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Set<Loan> getLoans() {
		return loans;
	}
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}
	
	
}
