package com.nt.callablestatemet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;



public class CSProcedureTest {
    private static final String query="{CALL FIRST_PRO(?,?,?)}";
	public static void main(String[] args) {
	   int first=0,second=0;
   try(Scanner sc=new Scanner(System.in)){
	   if(sc!=null) {
		   System.out.println("Enter the first number::");
		     first=sc.nextInt();
		   System.out.println("Enter the Scevond Number::");
		   second=sc.nextInt();
	   }//if
	  //establidh the Connection
	   try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			     CallableStatement cs=con.prepareCall(query);){
			    	 if(cs!=null)
			    		 cs.registerOutParameter(3, Types.INTEGER);
			    	 //set Input 
			    	 if(cs!=null) {
			    	  cs.setInt(1,first);
			    	  cs.setInt(2, second);
			     }
	     cs.execute();
	      int result=0;
	      if(cs!=null)
	    	  result=cs.getInt(3);
	      System.out.println(result);
			   
      }
   }
   catch(Exception e) {
	   e.printStackTrace();
      }
  }

}
