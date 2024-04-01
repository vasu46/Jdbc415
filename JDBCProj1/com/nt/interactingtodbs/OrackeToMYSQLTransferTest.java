package com.nt.interactingtodbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrackeToMYSQLTransferTest {
	private static final String ORACLE_SELECT_QUERY= "SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	private static final String MYSQL_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";

	public static void main(String[] args) {
	   Connection oraCon=null,mySqlCon=null;
	   Statement st=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   try {
		   //Create the Driver calss Object
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   //Establish the Connection
		     oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
		     mySqlCon=DriverManager.getConnection("jdbc:mysql:///ntaj415db","root","root");
		  
		  //create statement Object
		     if(oraCon!=null)
		    	 st=oraCon.createStatement();
		 //create Statement object
		     if(mySqlCon!=null)
		    	 ps=mySqlCon.prepareStatement(MYSQL_INSERT_QUERY);
		 //execute the select Object
		     if(st!=null)
		      rs=st.executeQuery(ORACLE_SELECT_QUERY);
		 //exceute the Result object
		     if(rs!=null && ps!=null) {
		    	 while(rs.next()) {
		    		 int sno=rs.getInt(1);
		    		 String name=rs.getString(2);
		    		 String addrs=rs.getString(3);
		    		 float avg=rs.getFloat(4);
		    		//set the values to prepares sTATEMETN
		    		 ps.setInt(1, sno);
		    		 ps.setString(2, name);
		    		 ps.setString(3, addrs);
		    		 ps.setFloat(4, avg);
		    	//execute the PreparedStatement 
		    		 ps.executeUpdate();
		    	 }
		    	 System.out.println("Recors are inserted to Oracle to Mysql");
		    		 
		    	 }
		     }//try
	   catch(SQLException se) {
		   se.printStackTrace();
		      }
	   catch(Exception e) {
		   e.printStackTrace();
	      }
	    finally {
	    	try {
	    		if(rs!=null)
	    			rs.close();
	    	  }//try
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
	    		if(oraCon!=null)
	    			oraCon.close();
	    	  }
	    	catch(SQLException se) {
	    		se.printStackTrace();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	try {
	    		if(mySqlCon!=null)
	    			mySqlCon.close();
	    	}
	    	catch(SQLException se) {
	    		se.printStackTrace();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	}

}
