package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) {
		Scanner sc=null;
		Statement st=null;
		Connection con=null;
		ResultSet rs=null;
		
		int dno=0;
		try {
		//cretae the Scanner Object
			sc=new Scanner(System.in);
	    //gives inputs
			if(sc!=null) {
				System.out.println("Enter the Deptno::");
				dno=sc.nextInt();
			}
	//Load the Jdbc Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
    //Estabish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");

    //creta the statement Object
			if(con!=null)
				st=con.createStatement();
	//cretae the query
			String query="SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE DEPTNO="+dno;
    //Excecute thequery
			 if(st!=null)
				 rs=st.executeQuery(query);
	//process the resultset Object
			 if(rs!=null) {
				 System.out.println("query::"+query);
			 while(rs.next()) {
				 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));	 
			 }//while
		}//if
	  }//try
	  catch(SQLException se) {
		if(se.getErrorCode()>900 && se.getErrorCode()<999)
			System.out.println("EROOR IN DB COLS,DB TABLE NAMES OR SQL QUERY");
		   se.printStackTrace();
	  }
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close the objects
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
			//close the objects
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
			//close the objects
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
			//close the objects
			try {
				if(sc!=null)
					rs.close();
			   }
			catch(Exception e) {
				e.printStackTrace();
			}		
		}
	}

}
