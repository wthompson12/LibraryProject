package com.cognixia.jump.daoClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.LibrarianDAO;
import com.cognixia.jump.model.Librarian;
import com.cognixia.jump.model.Patron;

public class LibrarianDAOClass implements LibrarianDAO{
	
	private static final Connection conn = ConnectionManager.getConnection();
	private static final String UPDATE_USERNAME = "UPDATE librarian SET username = ? where librarian_id = ?";
	private static final String UPDATE_PASSWORD = "UPDATE librarian SET password = ? where librarian_id = ?";
	private static final String SELECT_ALL_PATRONS = "SELECT * FROM patron";
	

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
	public boolean updateAccount(Patron p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Patron> getAllPatrons() {
		
			List<Patron> patrons = new ArrayList<>();
			
			try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PATRONS);
					ResultSet rs = pstmt.executeQuery()){
				while(rs.next()){
					patrons.add(new Patron(rs.getInt("patron_id"), 
							rs.getString("first_name"), 
							rs.getString("last_name"),
							rs.getString("username"),
							rs.getString("password"),
							rs.getBoolean("account_frozen")));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return patrons;
	}

	@Override
	public Librarian getLibrarianByID() {
		// TODO Auto-generated method stub
		return null;
	}

}
