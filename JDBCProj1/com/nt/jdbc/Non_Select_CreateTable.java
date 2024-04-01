package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Non_Select_CreateTable {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
	//Loads the JDBC Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
   //establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
     //cretae the Statement the Object
			if(con!=null)
				st=con.createStatement();
			//create the query
			String query="CREATE TABLE STUD(SNO INT PRIMARY KEY,STUD_NAME VARCHAR2(20),STUD_ADDRS VARCHAR2(10))";
    //Excecute the Query
			 int count=0;
			 count=st.executeUpdate(query);
			if(count==0)
				System.out.println("TABLE IS CRETAEED TABLE NAME::");
			else
				System.out.println("Table is not cretaed");
		}//try
		catch(SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999) {
				System.out.println("Mistake in the DB Table column,db table name and sql query");
			     }//if
		 se.printStackTrace();
		}//catch
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
