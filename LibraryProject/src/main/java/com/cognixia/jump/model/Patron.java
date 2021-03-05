package com.cognixia.jump.model;

public class Patron {
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean accountFrozen;
	
	
	public Patron(int id, String firstName, String lastName, String username, String password, boolean accountFrozen) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.accountFrozen = accountFrozen;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAccountFrozen() {
		return accountFrozen;
	}


	public void setAccountFrozen(boolean accountFrozen) {
		this.accountFrozen = accountFrozen;
	}


	public int getId() {
		return id;
	}
	
	

}
