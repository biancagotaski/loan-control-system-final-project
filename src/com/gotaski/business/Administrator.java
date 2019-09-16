package com.gotaski.business;

public class Administrator extends User {

	public Administrator(int id, String name, String email, String password) {
		super(id, name, email, password);
	}
	
	public Administrator(String name, String email, String senha) {
		super(name, email, senha);
	}
	
}
