package com.nt.preparedStament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PSInsertTest2 {
	private static final String CUSTOMER_DETAILS_INSERTED_QUERY="INSERT INTO CUSTOMER VALUES(?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			sc=new Scanner(System.in);
			int count=0;
			if(sc!=null) {
			  System.out.println("enetr the No of CUSTOMER DETAILS::");
			  count=sc.nextInt();
		    }
		//get Driver Class th ObjectC
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the Conncetion
		   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
		 //prepared the PreparedStatement Object
		   if(con!=null)
			   ps=con.prepareStatement(CUSTOMER_DETAILS_INSERTED_QUERY);
		   //getting the cust detauls in end usewr
		   if(ps!=null && sc!=null) {
			   for(int i=1;i<=count;i++) {
				   System.out.println("ENTER THE CUSTOMER NUMBER::");
				   int cno=sc.nextInt();
				   System.out.println("Enter the Customer NAME::");
				   String cname=sc.next();
				   System.out.println("Enterthe Student addrs::");
				   String addrs=sc.next();
				   System.out.println("Enter the Customer the Bill::");
				   float bill=sc.nextFloat();
				//set the input query values in sql QUery
				   ps.setInt(1, cno);
				   ps.setString(2,cname);
				   ps.setString(3,addrs);
				   ps.setFloat(4,bill);
				   
				  //execute the prepared Statement obj
				   int result=ps.executeUpdate();
				   if(result==0) {
					   System.out.println("CUSTOMER DETAILS ARE NOT INSERTED::");
				   }
				   else {
					   System.out.println("CUSTOMER DETAILS ARE INSERTED::");
				   }//else
				   
			   }//for
		   }//if   
		
		}//try
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

	  }//finally

   }//main
}//class
