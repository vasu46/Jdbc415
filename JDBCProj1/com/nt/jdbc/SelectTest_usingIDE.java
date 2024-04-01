package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest_usingIDE {

	public static void main(String[] args) {
		System.out.println("SelectTest_UsingIDE::Main Test Start");
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//cretae the Scanner object
			sc=new Scanner(System.in);
			String initChars=null;
			if(sc!=null) {
				System.out.println("enter the initChars::");
				initChars=sc.next(); //gives a
			}
			//converts the sql requird 
			initChars="'"+initChars+"%'";
			
			//Load the driver calss 
		     Class.forName("oracle.jdbc.driver.OracleDriver");
		     //get Connection established
		     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
		     //create the Statement 
		     if(con!=null)
		     st=con.createStatement();
		     //cretae the sql query
		     String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE ENAME LIKE"+initChars;
		     //execute the query
		     if(st!=null) 
		    	 rs=st.executeQuery(query);
		     if(rs!=null) {
		    	 System.out.println(query);
		     while(rs.next()!=false) {
		    	 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		     }//while	 
		   }//if
		}//try
		catch(SQLException se) {
	      if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
	    	  System.out.println("Invaild col NAMES,Tables or SQL QUERY ");
	      se.printStackTrace();
		}//catch
		catch(Exception e) {
			e.printStackTrace();
			
		}//if
		finally {
			//close the all objects
			try {
				if(rs!=null)
					rs.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}//catch
			
		}//fianlly

	}//,main

}//calss
