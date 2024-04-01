package com.nt.preparedStament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Workin_With_DateValues_Retriving_PS {
	private static final String SELECT_DATE_QUERY="SELECT * FROM PERSON_INFO_DATES";
public static void main(String[] args) {
		 Scanner sc=null;
		 Connection con=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 
	try {
		//jdbc driver class 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
		//prepatrd statement
		if(con!=null)
			 ps=con.prepareStatement(SELECT_DATE_QUERY);
		   //exeute the query
	if(ps!=null)
		 rs=ps.executeQuery();
		/*
		 * if(rs!=null){ while(rs.next()!=false) {
		 * System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)
		 * +"  "+rs.getString(4)+"  "+rs.getString(5)); }//while
		 * 
		 * }//if
		 */	
	   if(rs!=null) {
		   while(rs.next()!=false) {
			   int pid=rs.getInt(1);
			   String name=rs.getString(2);
			   java.sql.Date sqdob=rs.getDate(3);
			   java.sql.Date sqdoj=rs.getDate(4);
			   java.sql.Date sqdom=rs.getDate(5);
			   
			   //converting the java.sql.date to Simple date format
			   SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			   String s1=sdf.format(sqdob);
			   String s2=sdf.format(sqdoj);
			   String s3=sdf.format(sqdom);
			   System.out.println(pid+"  "+name+"  "+s1+"  "+s2+"  "+s3);
			   
		   }//while
	   }//if
	}//try
	    
	catch(SQLException se) {
		se.printStackTrace();
		System.out.println("proble in record insertion");
		 
	}
	catch(Exception e) {
		e.printStackTrace();
	   }
	 finally {
		
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
			  }//catch
			
		}//finally
	 }//main
	
	
}//class


