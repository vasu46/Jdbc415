package com.nt.batch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class TransferMoneyTxMgmtTest {
	 Properties props=null;

	public static void main(String[] args) {
		long srcAcno=0;
		long destAcno=0;
		double amount=0.0;
		 Properties props=null;
		
		try(Scanner sc=new Scanner(System.in)){
			if(sc!=null) {
				System.out.println("enetr the source account number::");
				srcAcno=sc.nextLong();
				System.out.println("enetr the destination accoutn number::");
				destAcno=sc.nextLong();
				System.out.println("Enter amount to transfer::");
				amount=sc.nextDouble();
			}//if
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		try(InputStream is=new FileInputStream("com/nt/batch/Info.properties")){
				props=new Properties();
				props.load(is);
		}
		catch(FileNotFoundException fne) {
			fne.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection(props.getProperty("jdbc.url"),
				                                        props.getProperty("jdbc.username"),
				                                        props.getProperty("jdbc.password"));
				Statement st=con.createStatement();
				){
			if(con!=null)
				con.setAutoCommit(false);
		
		if(st!=null) {
			//add queries to to the batch
			st.addBatch("UPDATE JDBC_ACCOUNT SET BALANCE=BALANCE-"+amount+" where ACNO="+srcAcno);
		    st.addBatch("UPDATE JDBC_ACCOUNT SET BALANCE=BALANCE+"+amount+" where ACNO="+destAcno);
			//execute the batch
		    int result[]=st.executeBatch();
		    
		    //process the result from TxMgmt
		    boolean flag=true;
		    for(int i=0;i<result.length;i++) {
		    	if(result[i]==0) {
		    		flag=false;
		    		break;
		    	}
		    	
		    }
		
		if(flag==true) {
			con.commit();
			System.out.println("TX COMMITED,MONEY Transferd");
		  }
		else {
			con.rollback();
			System.out.println("tx rollabk money not Transffered");
		   }
		}//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				

	}//main

}//class
