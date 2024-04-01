package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Non_Select_InsertTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			//cretae the Scanner Objcet
			sc=new Scanner(System.in);
			int no=0;
			String name=null,addrs=null;
			float avg=0.0f;
			
			 if(sc!=null) {
			//give the iNputs
			System.out.println("Enter the student NUmber::");
			no=sc.nextInt();
			System.out.println("Enetr the student Name::");
		    name=sc.next().toUpperCase();
			System.out.println("Enter the Student address::");
			addrs=sc.next().toUpperCase();
			System.out.println("enetr the average::");
			avg=sc.nextFloat();
			
			 }//if
			//covert teh Inputs to the Sql Requried connection
			name="'"+name+"'";
			addrs="'"+addrs+"'";
			
		//Load the Jdbc the Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
	    //create the Statement
			if(con!=null)
				st=con.createStatement();
	    //Create the query
			String query="INSERT INTO STUDENT VALUES("+no+","+name+","+addrs+","+avg+")";
	   //excute the Query
			int count=0;
	      count=st.executeUpdate(query);
	      if(count==0)
	    	  System.out.println("No records are the count::");
	    	  else
	    		  System.out.println("No of records are the update::"+count);
		}//try
		catch(SQLException se) {
			if(se.getErrorCode()==1) 
				System.out.println("Duplicates can not inserted into primary key column");
			if(se.getErrorCode()==1400)
				System.out.println("NULLS ARE THE NOT INSERTED");
			if(se.getErrorCode()>=900 && se.getErrorCode()<999) 
				System.out.println("ERROR OCcrured in db table column,tabe name,sql ");
		}
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

			
			
			 
			 
			
			
		
				




