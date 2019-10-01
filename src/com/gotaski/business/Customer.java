package com.gotaski.business;

import java.time.LocalDateTime;

public class Customer {
	private int id;
	private String name;
	private String lastName;
	private String email;
	private String birthday;
	private String CPF;
	private String street;
	private int number;
	private String city;
	private String state;
	private Loan loan;	
	
	public Customer(int id) {
		this.setId(id);
	}
	
	public Customer(String name, String lastName, String email, String birthday, String CPF, String street, int number, String city, String state) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.CPF = CPF;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
	}
	
	public Customer(int id, String name, String lastName, String email, String birthday, String CPF, String street, int number, String city, String state) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.CPF = CPF;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s - %s - %s - %d - %s - %s",
					this.name,
					this.lastName,
					this.email,
					this.birthday,
					this.CPF,
					this.street,
					this.number,
					this.city,
					this.state
				);
	}
	
	public void display() {
		System.out.println("Cliente");
		System.out.println(this.toString());
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	
}
