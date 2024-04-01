package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest3 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
		//Load the jdbc driver calss
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
		//create the statement
		 if(con!=null)
			 st=con.createStatement();
		 //create the sql query
		 String query="SELECT COUNT(*) FROM STUDENT";
		 //PROCESS THE SUERY
		 if(st!=null)
			 rs=st.executeQuery(query);
		//process the result set object
		   if(rs!=null) 
			   rs.next();
		   int count=rs.getInt(1);
		   System.out.println(count);
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		   

	}

}
