package com.cognixia.jump.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;

/**
 * Servlet implementation class LibrarianServlet
 */
public class LibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Connection conn = ConnectionManager.getConnection();
	private static final String SELECT_USERNAME_PASSWORD = "SELECT * FROM librarian ";
	
	public static String username;
	public static String firstname;
	public static String lastname;
	public static String password;
	public static int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibrarianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("useremail");
		String password1 = request.getParameter("userpassword");
		
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_USERNAME_PASSWORD);){
				ResultSet rs = pstmt.executeQuery();
				
				boolean successful = false;
				
				while(rs.next()) {
				 if (email.equals(rs.getString("username")) && password1.equals(rs.getString("password"))){
					 
					 
					 	successful = true;
					 	
					 	username = rs.getString("username");
					 	password = rs.getString("password");
					 	id = rs.getInt("librarian_id");
					 	
					 	RequestDispatcher dispatcher = request.getRequestDispatcher("/librarian.jsp");
						dispatcher.forward(request, response);
							 
				 }
				}
				
			if(successful == false) {
				;
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
				dispatcher.forward(request, response);
				
			}
				
				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		 
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
