package com.nt.rowsets;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class JDBC_OracleCachedRowSetTest {

	public static void main(String[] args) {
	
		try(OracleCachedRowSet jrst=new OracleCachedRowSet()){
			jrst.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			jrst.setUsername("system");
			jrst.setPassword("7825");
			jrst.setCommand("SELECT * FROM STUDENT");
			jrst.execute();
			while(jrst.next()) {
				System.out.println(jrst.getString(1)+" "+jrst.getString(2)+" "+jrst.getString(3)+" "+jrst.getString(4));
			}//while
			 System.out.println("Stop db s/w form services.msc");
			 Thread.sleep(40000);
			 jrst.absolute(3);
			 jrst.updateFloat(4, 99.912F);
			 jrst.updateRow();
			 System.out.println("offline Modifications happend");
			 System.out.println("Start db s/w from services.msc");
			 Thread.sleep(60000);
			 jrst.acceptChanges();
			 while(jrst.next()) {
					System.out.println(jrst.getString(1)+" "+jrst.getString(2)+" "+jrst.getString(3)+" "+jrst.getString(4));
				}//w	 
		}//try
		
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
