package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Non_Select_UpdateTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			//cretae the Scanner Objcet
			sc=new Scanner(System.in);
			String newName=null,newCity=null;
			float newAvg=0.0f;
			int no=0;
			 if(sc!=null) {
			//give the iNputs
			System.out.println("Enter the Student New Name::");
			newName=sc.next();
			System.out.println("Enetr the Stsudent New Addrs::");
			newCity=sc.next();
			System.out.println("Enter the Student new Avg::");
			newAvg=sc.nextFloat();
			System.out.println("Enetr the Student no::");
			no=sc.nextInt();
			 }//if
			//covert teh Inputs to the Sql Requried connection
			newName="'"+newName+"'";
			newCity="'"+newCity+"'";
		//Load the Jdbc the Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
	    //create the Statement
			if(con!=null)
				st=con.createStatement();
	    //Create the query
			String query="UPDATE STUDENT SET SNAME="+newName+",SADD="+newCity+",AVG="+newAvg+"WHERE SNO="+no;
	   //excute the Query
			int count=0;
	      count=st.executeUpdate(query);
	      if(count==0)
	    	  System.out.println("No records are the count::");
	    	  else
	    		  System.out.println("No of records are the update::"+count);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch2
		finally {
			//close the Objects
			//close the statement object
			try {
				if(st!=null)
					st.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}//catch1
		   catch(Exception e) {
			   e.printStackTrace();
		   }//catch2
		//close the Connection object
			try {
				if(con!=null)
					con.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}//catch2
		   catch(Exception e) {
			   e.printStackTrace();
		   }//catch2
		//close the Scanner Object
			try {
				if(sc!=null)
					sc.close();
			}//try
		   catch(Exception e) {
			   e.printStackTrace();
		   }//catch
			
			
		}//finally
		

	}//main

}//class

			
			
			 
			 
			
			
		
				




