package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Non_Select_UpdateTest2 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			//cretae the Scanner Objcet
			sc=new Scanner(System.in);
			String desg1=null,desg2=null,desg3=null;
			float hike_Persentage=0.0f;
			 if(sc!=null) {
			//give the iNputs
			System.out.println("Enter the emp desg1::");
			desg1=sc.next().toUpperCase();
			System.out.println("Enetr the emp desg2::");
		    desg2=sc.next().toUpperCase();
			System.out.println("Enter the emp desg3::");
			desg3=sc.next().toUpperCase();
			System.out.println("enetr the hike_persetage::");
			 hike_Persentage=sc.nextFloat();
			
			 }//if
			//covert teh Inputs to the Sql Requried connection
			desg1="'"+desg1+"'";
			desg2="'"+desg2+"'";
			desg3="'"+desg3+"'";
		//Load the Jdbc the Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
	    //create the Statement
			if(con!=null)
				st=con.createStatement();
	    //Create the query
			String query="UPDATE EMP SET sal=sal+(sal*"+ hike_Persentage/100+")WHERE JOB IN("+desg1+","+desg2+","+desg3+")";
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

			
			
			 
			 
			
			
		
				




