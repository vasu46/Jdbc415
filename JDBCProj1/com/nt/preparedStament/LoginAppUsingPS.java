package com.nt.preparedStament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginAppUsingPS {
	private static final String LOGIN_USER_QUERY="SELECT COUNT(*) FROM IRTC_TAB WHERE UNAME=? AND PWD=?";

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
	    PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			sc=new Scanner(System.in);
			String user=null;
			String password=null;
			if(sc!=null) {
				System.out.println("Enetr the Loging USER NAME::");
				user=sc.next();
				System.out.println("Enter the Loging the Password::");
				password=sc.next();
			}//if
			//load the jdbc the Driver calss
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			
			//prepared the PreparedStatement object
		if(con!=null) {
			ps=con.prepareStatement(LOGIN_USER_QUERY);
			}
		//set the values of the query
		 if(ps!=null) {
			 ps.setString(1,user);
			 ps.setString(2, password);
			 
			 //execute teh query
			 rs=ps.executeQuery();
			 if(rs!=null) {
				 rs.next();
		   int count=rs.getInt(1);
		        if(count==0)
		        	System.out.println("INVAILD CREDENTILS::");
		        else {
		        	System.out.println("valid Credentials::");
		        }
		    } 
		    
		 
		 }
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 finally {
			 //clsoe the Obj
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
			    if(ps!=null)
			    	ps.close();
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
				 if(sc!=null)
					 sc.close();
			 }
				 catch(Exception e) {
					 e.printStackTrace();
				 }

	  }//finally
		

	}

}
