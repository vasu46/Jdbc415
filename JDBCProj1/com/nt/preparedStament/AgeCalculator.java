package com.nt.preparedStament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgeCalculator {
	private static final String AGE_CLACULATOR="SELECT ROUND((SYSDATE-DOB)/365.25,2) FROM PERSON_INFO_DATES WHERE PID=?";

	public static void main(String[] args) {
		Scanner sc=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		try {
			sc=new Scanner(System.in);
			int pid=0;
			 if(sc!=null) {
			System.out.println("Enter The person Id::");
			pid=sc.nextInt();
			 }
			 //load the driver calss
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the Connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			 
			 //cretae perpared statement 
			 if(con!=null) 
				 ps=con.prepareStatement(AGE_CLACULATOR);
			 
			 //set input values
			 if(ps!=null && sc!=null)
				 ps.setInt(1, pid);
			 //execute the uery
			 if(ps!=null) {
				 rs=ps.executeQuery();
			 }
			 //process the result
			    if(rs!=null) {
			    	if(rs.next()!=false) {
			    		float age=rs.getFloat(1);
			    		System.out.println("anjana AGE ::"+age);
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
			 //close the Objects
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
			  
		}
	  
	}

}
