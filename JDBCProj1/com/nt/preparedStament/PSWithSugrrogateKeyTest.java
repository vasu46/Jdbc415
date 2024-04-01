package com.nt.preparedStament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PSWithSugrrogateKeyTest {
	 private static final String INSERT_STUDENT_QUERY="INSERT INTO STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?)";


	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			sc=new Scanner(System.in);
			int count=0;
			if(sc!=null) {
				System.out.println("ENETR THE NO OF STUDENT VALUES::");
				count=sc.nextInt();	
			}//if
			//Load the driver cakss
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			
			//cretae the prepared obj
			if(con!=null) {
				ps=con.prepareStatement(INSERT_STUDENT_QUERY);
			}//if
			//set input values by taking the end user
			if(ps!=null && sc!=null) {
				for(int i=1;i<=count;i++) {
					System.out.println("Enetr the stsudent NAME::");
				    String name=sc.next();
				    System.out.println("ENTER THE STUDENT ADDRS::");
				    String addrs=sc.next();
				    System.out.println("ENTER THE STUDENT THE AVERAGE::");
				    float avg=sc.nextFloat();
				    
				    //set input values 
				     ps.setString(1,name);
				     ps.setString(2,addrs);
				     ps.setFloat(3,avg);
				     
				    //execute the query
				    int result=ps.executeUpdate();
				      if(result==0) {
				    	  System.out.println(count+" STUDENT DETAILS ARE INSERTED::");
				      }
				      else {
				    	  System.out.println(count+" STUDENT DETAILS ARE NOT INSERTED::");
				    	  
				      }
				    
				
				}//FOR
			}//IF
		}//TRY
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
