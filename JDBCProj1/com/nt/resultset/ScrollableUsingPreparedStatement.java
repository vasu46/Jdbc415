package com.nt.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScrollableUsingPreparedStatement {
	private static final String SELECT_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";

	public static void main(String[] args) {
	   try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			  PreparedStatement ps=con.prepareStatement(SELECT_QUERY,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			   ResultSet rs=ps.executeQuery();
			   ){
		   if(rs!=null) {
			   
		      System.out.println("records top to bootom::");
			   while(rs.next()){
				    System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			   }
			      System.out.println("============================================");
			      
				  System.out.println("records from bottom to top");
				    rs.afterLast();
				      while(rs.previous()) {
				    System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				      }
				      System.out.println("============================================");
				      
				      
				      System.out.println("First record ot the table::");
				      rs.first();
				      System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					  System.out.println("============================================");
					  
					  System.out.println("Ladst record of the Table::");
					  rs.last();
					  System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					  System.out.println("============================================");
					  
					   System.out.println("Third REcord of the Tbale::");
					  rs.absolute(3);
					  System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					  System.out.println("============================================");
					  
					  System.out.println("6th record of the table");
					  rs.absolute(6);
					  System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					  System.out.println("============================================");
					  
					  System.out.println("where cursor is the present then count that to forward 3 records 3::");
					  rs.relative(3);
					  System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					  System.out.println("============================================");
					  
					  System.out.println("WHere cursor is thre that to back 6 recordds");
					  rs.relative(-6);
					  System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					  System.out.println("============================================");
					  
					  
					 System.out.println("givers first is or nor true or false::");
					 boolean bo1= rs.isAfterLast();
					 System.out.println(bo1);
					  System.out.println("============================================");
					
					  System.out.println("GET FIRST RECORD::");
					   rs.first();
					   System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"..."+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
						  System.out.println("============================================");
						  System.out.println("gives cursor position in first record or not if::");
						 boolean bo2=rs.isFirst();
						 System.out.println(bo2);
					 
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
