package com.nt.interactingtodbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResource {
	private static final String SELECT_STUDENT_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";

	public static void main(String[] args)  {
		System.out.println("Try with Resource started::");
		//Class.forName("orcale.jdbc.driver.OracleDriver");
		try( 
				//establish the connection
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
				//Cretae Statement Obje
				Statement st=con.createStatement();
				//Excecute the SELECT QUERY
				ResultSet rs=st.executeQuery(SELECT_STUDENT_QUERY); ){
			   
			//process the result object
			   if(rs!=null) {
				boolean flag=false;
				   while(rs.next()) {
					  flag=true;
					 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				   }//while
				   if(flag==false)
					   System.out.println("NO RECORDS FOUND");
			   }//if
							   
          }//try
		catch(SQLException se) {
			se.printStackTrace();
		}
	}//main    
}//class
