package com.nt.jdbc;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login_App {

	public static void main(String[] args) {
		Scanner scn=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
	
		try{
			//create the Object of Scanner Class
			scn=new Scanner(System.in);
			//Console cons=System.console();
			String userName=null;
			String password=null;
			//processthe Inputs
			if(scn!=null) {
				System.out.println("Enter the login  UserName::");
				userName=scn.nextLine();
				//userName=cons.readLine();
				System.out.println("Enter the login  password::");
		       password=scn.nextLine();	
				//password=new String(cons.readPassword());
			    }
			//process the Inputs as SQL Query 
			userName="'"+userName+"'";
			password="'"+password+"'";
			
		    //lOAd the Driver calss
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			//create the Statement
			if(con!=null)
				st=con.createStatement();
			//create the the sql Query
			String query="SELECT COUNT(*) FROM IRTC_TAB WHERE UNAME="+userName+" AND PWD="+password;
			//Execute the result set
			if(st!=null)
				rs=st.executeQuery(query);
			//process the Result se object
			    if(rs!=null) {
			    	rs.next();
			    	int count=rs.getInt(1);
			    	if(count==0)
			    		System.out.println("INVAILD CREDENTIALS");
			    	else
			    		System.out.println("VALID CREDENTIALS");
			    }//if			
		}//try
		catch(SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
				System.out.println("error in db column name,db table name or sql query");
			se.printStackTrace();
		  }
		catch(Exception e) {
			e.printStackTrace();
		}
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
				if(scn!=null)
					scn.close();
			}//try
		   catch(Exception e) {
			   e.printStackTrace();
		   }//catch
		}//finally
	}

}
