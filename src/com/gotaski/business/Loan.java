package com.gotaski.business;

import java.time.LocalDateTime;

public class Loan {
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Customer customer;
	private Product product;
	private String CPFCustomer;
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getCPFCustomer() {
		return CPFCustomer;
	}
	
	public void setCPFCustomer(String cPFCustomer) {
		CPFCustomer = cPFCustomer;
	}
}
