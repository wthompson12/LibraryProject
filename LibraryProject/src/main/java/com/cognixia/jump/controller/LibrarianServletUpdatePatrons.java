package com.cognixia.jump.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.daoClasses.LibrarianDAOClass;
import com.cognixia.jump.daoClasses.PatronDAOClass;
import com.cognixia.jump.model.Patron;

/**
 * Servlet implementation class LibrarianServletUpdatePatrons
 */
public class LibrarianServletUpdatePatrons extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Connection conn = ConnectionManager.getConnection();
	private static final String UNFREEZE_PATRON_ACCOUNT = "UPDATE patron SET account_frozen = ? where patron_id = ?";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibrarianServletUpdatePatrons() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		List<Patron> patrons = new ArrayList<Patron>();
		
		LibrarianDAOClass lc = new LibrarianDAOClass();
		
		patrons = lc.getAllPatrons();
		
		request.setAttribute("patron", patrons);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/librarianUpdate3.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PatronDAOClass pc = new PatronDAOClass();
		
		int id = Integer.parseInt(request.getParameter("patronsid"));
		int account = Integer.parseInt(request.getParameter("account"));
		pc.getPatronById(id);
		
		try (PreparedStatement pstmt = conn.prepareStatement(UNFREEZE_PATRON_ACCOUNT)){
			
			pstmt.setInt(1, account);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/librarianUpdate3.jsp");
		dispatcher.forward(request, response);
		
	}
}