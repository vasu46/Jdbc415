package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnTest_MySQL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj415db","root","root");
		if(con==null) {
			System.out.println("connection is not established");
			
		}
		else {
			System.out.println("connection is established");
		}
	}
	

}
