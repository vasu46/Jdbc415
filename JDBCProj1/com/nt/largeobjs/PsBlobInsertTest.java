package com.nt.largeobjs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsBlobInsertTest {
	 private static final String BLOB_INSER_QUERY="INSERT INTO ARTIST_INFO VALUES(AID_SQL.NEXTVAL,?,?,?)";

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			String name=null,addrs=null,photoLocation=null;
			if(sc!=null) {
				System.out.println("Enter the Name of Heroine::");
				name=sc.next();
				System.out.println("Enter the addrs of the heroine::");
				addrs=sc.next();
				System.out.println("enetr the Location of PHOTO");
				photoLocation=sc.next();
			}
			try(InputStream is=new FileInputStream(photoLocation)){
				 try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
					 PreparedStatement ps=con.prepareStatement(BLOB_INSER_QUERY); ){
					 if(ps!=null) {
				         //set input values
						 ps.setString(1,name);
					     ps.setString(2, addrs);
					     ps.setBlob(3,is);
				 }
					 //process the resu;t
					 int count=0;
					 if(ps!=null) {
						 count=ps.executeUpdate();
					 }
					 if(count==0)
						 System.out.println("record is not instered");
					 else
						 System.out.println("record is insterd");
				  
					 
				 }//try3
				
				

				
			}//try2
			
		}//try3
		
catch(SQLException se) {
	se.printStackTrace();
}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main

}//calss
