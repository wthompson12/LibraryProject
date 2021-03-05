package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Librarian;
import com.cognixia.jump.model.Patron;

public interface LibrarianDAO {

	boolean updateUsername(String username, int id);
	boolean updatePassword(String username, int id);
	
	boolean updateAccount(Patron p);
	
	
	
	List<Patron> getAllPatrons();
	
	Librarian getLibrarianByID();
	
}
