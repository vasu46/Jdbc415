package com.nt.sensitive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableRs {
	private static final String SELECT_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";

	public static void main(String[] args) {
	   try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			  Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			   ResultSet rs=st.executeQuery(SELECT_QUERY);
			   ){
		   if(rs!=null) {
		      System.out.println("records top to bootom::");
			        while(rs.next()){
				    System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			        }
			        System.out.println("==============================");
			        System.out.println("Insert into db table with out insert query");
			        rs.moveToInsertRow();//gives empty ResultSet oBj
			        rs.updateInt(1, 5567);
			        rs.updateString(2,"lav");
			        rs.updateString(3,"rav");
			        rs.updateFloat(4, 89.0f);
			        rs.insertRow();
				 System.out.println("update the object with out update query::");
				    rs.absolute(3);
				    rs.updateFloat(4, 99.99f);
				    rs.updateRow();
				    
				    System.out.println("delete row object with out delete query::");
				    rs.absolute(4);
				    rs.deleteRow();
				    //
			         }//if
				   
			   }//try
		   catch(SQLException se) {
			   se.printStackTrace();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
		   
	   }

}
