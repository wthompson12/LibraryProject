package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Patron;

public interface PatronDAO {
	
	boolean updateName(String firstName, String lastName, String username);
	boolean updateUsername(String username, int id);
	boolean updatePassword(String username, int id);
	boolean addPatron(Patron p);
	
	Patron getPatronById(int id);

}
