package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest_MySQL {

	public static void main(String[] args) throws Exception{
		//Load the JDBC DRIVER CLASS
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj415db","root","root");
		//Create Statement obj
		Statement st=con.createStatement();
		//execute the query
		ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");
		//PROCESS THE RESULT
		while(rs.next()!=false) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		rs.close();
		st.close();
		con.close();

	}

}
