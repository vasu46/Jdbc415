package com.nt.preparedStament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PSInsertTest {
	private static final String  STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter The No of Student values Stored::");
				count=sc.nextInt();
			}
			//prepared Jdbc Driver Class Obje
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			//Establish the Connection for Oracle
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			
			//prepared the Prepared statement
			if(con!=null)
				ps=con.prepareStatement(STUDENT_INSERT_QUERY);
			//set input values from END user
			if(ps!=null &&sc!=null) {
				for(int i=1;i<=count;i++) {
				System.out.println("Enter the Student Number::");
				int sno=sc.nextInt();
				System.out.println("Enter the Student Name::");
				String sname=sc.next();
				System.out.println("Enter the STudent the Address::");
				String addrs=sc.next();
				System.out.println("Enetr the Student the avg::");
				float avg=sc.nextFloat();
			//set input the query values
			ps.setInt(1,sno);
			ps.setString(2,sname);
			ps.setString(3,addrs);
			ps.setFloat(4, avg);
			
			//execute the sql query
			int result=ps.executeUpdate();
		//procee the result
			if(result==0) 
				System.out.println("STUDENT INFORMATION IS NOT INSERTED");
			else
				System.out.println("Student INFORMATION IS INSERTED");	
			}//for
		}//if	
	}
  catch(SQLException se) {
	  if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
		  System.out.println("ERROR IN SQL QUERY,OR COLUMN NAMES,TABLE NAME");
	  se.printStackTrace();
		}
 catch(Exception e) {
	 e.printStackTrace();
    }
 finally {
	 //clsoe the Obj
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
