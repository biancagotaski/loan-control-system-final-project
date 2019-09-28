package com.gotaski.business;

import java.util.HashSet;
import java.util.Set;

public class Loan {
	
	private int id;
	private String startDate;
	private String endDate;
	private Customer customer;
	private boolean closed;
	private Set<Product> products;
	private String CPFCustomer;
	
	public Loan() {
		products = new HashSet<Product>();
	}
	
	public Loan(int id) {
		this();
		this.setId(id);
	}
	
	public Loan(String startDate, String endDate, String CPFCustomer) {
		this();
		this.startDate = startDate;
		this.endDate = endDate;
		this.CPFCustomer = CPFCustomer;
	}
	
	public Loan(String startDate, String endDate, String CPFCustomer, Customer customer) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.CPFCustomer = CPFCustomer;
		this.setCustomer(customer); 
	}
	
	public Loan(int id, String startDate, String endDate, String CPFCustomer, Customer customer) {
		this(startDate, endDate, CPFCustomer, customer);
		this.setId(id);
	}
	
	public Loan(int id, String startDate, String endDate, String CPFCustomer, Customer customer, Set<Product> products) {
		this(id, startDate, endDate, CPFCustomer, customer);
		this.setProducts(products);
		this.setId(id);
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s",
					this.startDate,
					this.endDate,
					this.CPFCustomer,
					this.getCustomer() != null ? this.getCustomer().getName() : "Não há cliente cadastrado com esse empréstimo"
				);
	}

	public void display() {
		System.out.println("Empréstimo");
		
		System.out.println(this.toString());
		this.customer.display();
		
		for(Product p : this.products) {
			p.display();
		}
	}
	
	private String getClosedLoan() {
		return this.closed ? "closed" : "open";
	}
	
	public void addProduct(Product product) {
		this.getProducts().add(product);
	}
	
	public void associate(Customer customer) {
		this.customer = customer;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public String getCPFCustomer() {
		return CPFCustomer;
	}
	
	public void setCPFCustomer(String cPFCustomer) {
		CPFCustomer = cPFCustomer;
	}
}
