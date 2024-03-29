package com.gotaski.business;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public User(int id, String name, String email, String password) {
		this(name, email, password);
		this.id = id;
	}

	public String getType() {
		return (this instanceof Administrator) ? "Administrator" : "User";
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s", 
				this.getId(),
				this.getName(),
				this.getEmail(), 
				this.getType()
			);
	}
	
	public int getId() {
		return id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
