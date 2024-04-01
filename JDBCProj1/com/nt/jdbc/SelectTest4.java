package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest4 {

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
		 String query="SELECT EMPNO,ENAME,JOB,SAL,COMM,DEPTNO FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP)";
		 //PROCESS THE SUERY
		 if(st!=null)
			 rs=st.executeQuery(query);
		//process the result set object
		   if(rs!=null) {
			   System.out.println(query);
		        boolean flag=false;
		        while(rs.next()) {
		        	flag=true;
		        	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
		        }//while
		        if(flag=false)
		        	System.out.println("no records found");
		   }	   
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
