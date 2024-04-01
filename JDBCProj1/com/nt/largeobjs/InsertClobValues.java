package com.nt.largeobjs;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertClobValues {
	private static final String INSERT_CLOB_VALUES="INSERT INTO JOBSEEKER_INFO VALUES(JSID_SEQ.NEXTVAL,?,?,?)";

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			sc=new Scanner(System.in);
			String name=null,addrs=null,resume=null;
			if(sc!=null) {
				System.out.println("ENter the jobSeeker name::");
				name=sc.next();
				System.out.println("Enter the JobSeeker addrs::");
				addrs=sc.next();
				System.out.println("Enter the JobSeeker resume::");
				resume=sc.next();
			  } //if
			   //conver to text documnet in clob object
			    Reader reader=new FileReader(resume);
			  
			 //cretae driver class object
			    Class.forName("oracle.jdbc.driver.OracleDriver");
			 //create the Connection 
			    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			 //preoared sttement obj
			    if(con!=null)
			    	ps=con.prepareStatement(INSERT_CLOB_VALUES);
			    //set input values
			      if(ps!=null && sc!=null) {
			    	  ps.setString(1,name);
			    	  ps.setString(2,addrs);
			    	  ps.setCharacterStream(3,reader);	  
			         }
			      //execute the process
			        int count=0;
			         if(ps!=null) {
			        	 count=ps.executeUpdate();
			         }
			         if(count==0) {
			        	 System.out.println("record is not inserted");
			         }
			         else
			        	 System.out.println("record is inserted");
			        	 
			    
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
	  catch(Exception e) {
		  e.printStackTrace();
	  }
		finally {
			
	    	
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
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
		}

	}

}
