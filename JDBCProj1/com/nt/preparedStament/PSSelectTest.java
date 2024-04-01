package com.nt.preparedStament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PSSelectTest {
	private static final String STUDENT_SELECT_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SADD IN(?,? )";

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			sc=new Scanner(System.in);
			String addrs=null;
			String addrs1=null;
			if(sc!=null) {
				System.out.println("ENETR THE STUDENT ADDRS1::");
				addrs=sc.nextLine();
				System.out.println("ENTER THE STUDENT ADDRS2::");
				addrs1=sc.nextLine();
			}//if
			//load the Driver the Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//getConnection obj
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			
			//create the prepared Statement obj
			if(con!=null)
				ps=con.prepareStatement(STUDENT_SELECT_QUERY);
			
			//set input the values
			  if(ps!=null && sc!=null) {
			    ps.setString(1, addrs);
			    ps.setString(2, addrs1);
			    
			  //execuet thr query
			    rs=ps.executeQuery();
			    if(rs!=null) {
			    	while(rs.next()!=false) {
			    	    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			    	}
			    }
				
			}
			
		}
		catch(SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
				System.out.println("Error in column name,table name and sql qury not proparly");
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 finally {
			 //clsoe the Obj
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

	  }//finally
		
		
	

	}

}
