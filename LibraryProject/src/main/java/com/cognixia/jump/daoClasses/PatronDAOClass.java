package com.cognixia.jump.daoClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.PatronDAO;
import com.cognixia.jump.model.Patron;

public class PatronDAOClass implements PatronDAO {
	
	private static final Connection conn = ConnectionManager.getConnection();
	private static final String ADD_PATRON = "INSERT INTO patron(first_name, last_name, username, password) values (?, ?, ?, ?)";
	private static final String SELECT_PATRON_BY_ID = "SELECT * FROM patron WHERE patron_id = ?";
	private static final String UPDATE_NAME = "UPDATE patron SET first_name = ?, last_name = ? where username = ?";
	private static final String UPDATE_USERNAME = "UPDATE patron SET username = ? where patron_id = ?";
	private static final String UPDATE_PASSWORD = "UPDATE patron SET password = ? where patron_id = ?";
	
	

	@Override
	public boolean updateName(String firstName, String lastName, String username) {
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(UPDATE_NAME);
			pstmt.setString(1, firstName); 
			pstmt.setString(2, lastName);
			pstmt.setString(3, username);
			
			if (pstmt.executeUpdate()>0) {
				return true;
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public boolean updateUsername(String username, int id) {
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(UPDATE_USERNAME);
			pstmt.setString(1, username); 
			pstmt.setInt(2, id);
			
			if (pstmt.executeUpdate()>0) {
				return true;
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public boolean updatePassword(String username, int id) {
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(UPDATE_PASSWORD);
			pstmt.setString(1, username); 
			pstmt.setInt(2, id);
			
			if (pstmt.executeUpdate()>0) {
				return true;
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public boolean addPatron(Patron p) {
		
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_PATRON);){
			
			pstmt.setString(1, p.getFirstName());
			pstmt.setString(2, p.getLastName());
			pstmt.setString(3, p.getUsername());
			pstmt.setString(4, p.getPassword());
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Patron getPatronById(int id) {
		Patron patron = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_PATRON_BY_ID)){
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			patron = new Patron( 	rs.getInt("patron_id"),
									rs.getString("first_name"), 
									rs.getString("last_name"), 
									rs.getString("username"),
									rs.getString("password"),
									rs.getBoolean("account_frozen"));
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return patron;
	}

	
}
