package com.nt.preparedStament;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Workin_With_DateValues_BunchOfRecordsInserting_PS {
	private static final String INSERT_DATE_QUERY="INSERT INTO PERSON_INFO_DATES VALUES(PID_SEQ.NEXTVAL,?,?,?,?)";
public static void main(String[] args) {
		 Scanner sc=null;
		 Connection con=null;
		 PreparedStatement ps=null;
	try {
		//cretae Scanner Obj
	     sc=new Scanner(System.in);
	     String name=null,sdoj=null,sdom=null, sdob=null;
	     int count=0;
	     if(sc!=null) {
	    	 System.out.println("enetr the No person::");
	    	 count=sc.nextInt(); 
	     }//if
	         
	          
	          //load the JDBC DRIVER CALSS
	          Class.forName("oracle.jdbc.driver.OracleDriver");
	         
	          //Establish the Connection 
	          con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
	          
	          //cretae the Prepared statement obj
	          if(con!=null)
	        	  ps=con.prepareStatement(INSERT_DATE_QUERY);
	           if(ps!=null && sc!=null) {
	               for(int i=0;i<=count;i++) {
	        	  System.out.println("person name::");
	        	  name=sc.next();
	        	  System.out.println(" PERSON DOB(dd-MM-yyyy)::");
	        	  sdob=sc.next();
	        	  System.out.println("person DOJ(yyyy-MM-dd)::");
	        	  sdoj=sc.next();
	        	  System.out.println("person DOM(MMM-dd-yyyy)");
	        	  sdom=sc.next(); 
	        	  
	        	  //convaerting the date values AS JAVA.SQL.DATE CALSL OBJ
	        	  //FOR DOB(DD-MM-YYYY)
	        	  //Coverting String date value to java.util.Date class obj
	        	  SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
	        	  java.util.Date udob=sdf1.parse(sdob);
	        	  //converting java.util.date to java.sql.date class obj
	        	  long ms=udob.getTime();
	        	  java.sql.Date sqdob=new java.sql.Date(ms);
	        	  
	        	  //coverting sdoj (yyyy-mm-dd) String date value to direct to java.sql.Date
	        	  java.sql.Date sqdoj=java.sql.Date.valueOf(sdoj);
	        	  
	        	  //converting sdom to java.sql.date
	        	  SimpleDateFormat sdf2=new SimpleDateFormat("MMM-dd-yyyy");
	        	  java.util.Date udom=sdf2.parse(sdom);
	        	  //convertin the java.util.date to java.sql.date class obj
	        	  ms=udom.getTime();
	        	  java.sql.Date sqdom=new java.sql.Date(ms);
	         
	          
	          //set the values
	        
	        	 ps.setString(1,name);
	        	 ps.setDate(2,sqdob);	
	        	 ps.setDate(3,sqdoj);
	        	 ps.setDate(4,sqdom);
	         
	          
	        //execute the query
	          int count1=0;
	          if(ps!=null) 
	        	  count=ps.executeUpdate();
	          //process the results
	        	if(count==0)
	        		System.out.println("records are the Insterted::");
	        	else
	        		System.out.println("records inserted");
	               }//if
	           }//for
	          
	    }//try
	catch(SQLException se) {
		se.printStackTrace();
		System.out.println("proble in record insertion");
		 
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
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			  }//catch
			
		}//finally
	 }//main
	
	
}//class


