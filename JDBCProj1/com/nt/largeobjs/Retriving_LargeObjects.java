package com.nt.largeobjs;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



import oracle.jdbc.oracore.Util;

public class Retriving_LargeObjects {
	private static final String RETRIVING_LARGE_OBJECT="SELECT AID,NAME,ADDRS,PHOTO FROM ARTIST_INFO WHERE AID=?";

	public static void main(String[] args) {
		//read inputs
	   try(Scanner sc=new Scanner(System.in)){
		  
			   int aid=0;
			   if(sc!=null) {
		   System.out.println("enetr the artistid::");
		   aid=sc.nextInt();
		   }
		   //create Connection PreparedStatement objects
		   try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
				   PreparedStatement ps=con.prepareStatement(RETRIVING_LARGE_OBJECT);
				      ){
			       //set intput params
			         if(ps!=null)
			          ps.setInt(1,aid);
			   //cexecute the query
			         try(ResultSet rs=ps.executeQuery()){
			        	 //PROCESS THE RESULT
			        	if(rs!=null){
			        		if(rs.next()) {
			        			aid=rs.getInt(1);
			        			String name=rs.getString(2);
			        			String addrs=rs.getString(3);
			        			System.out.println(aid+" "+name+" "+addrs);
			        			try(InputStream is=rs.getBinaryStream(4);
			        					//create OUTput stream pointing to destination file
			        					OutputStream os=new FileOutputStream("retrive_image.JFIF");
			        					){
			        				//CRETAE BLOB COL VALUE TO DESTINATION FILE
			        			
			        				System.out.println("Blob value is retrived and stored in the file");
			        			}//try
			        			
			        		}//if
			        		else
			        			System.out.println("Record not Found");
			        	}//if
			         }//try
			        
		   }//try3
	   }//try2
	catch(SQLException se) {
		se.printStackTrace();
	}//catch
	   catch(Exception e) {
		   e.printStackTrace();
	   }//catch
		
	}//main

}//class
