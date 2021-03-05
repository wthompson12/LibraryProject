package com.cognixia.jump.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
//	create database library_db;
//	create table patron (
//		id int primary key AUTO_INCREMENT,
//	    first_name varchar(50) not null,
//	    description varchar(100)
//	);
	
	private static final String URL = "jdbc:mysql://localhost:3306/library";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection connection = null;
	
	private static void makeConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if (connection == null) {
			makeConnection();
		}
		return connection;
	}

}
