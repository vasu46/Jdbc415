package com.nt.rowsets;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import oracle.jdbc.rowset.OracleWebRowSet;

public class JDBC_OracleWebRowSetTest {

	public static void main(String[] args) {
	
		try(OracleWebRowSet jrst=new OracleWebRowSet()){
			jrst.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			jrst.setUsername("system");
			jrst.setPassword("7825");
			jrst.setCommand("SELECT * FROM STUDENT");
			jrst.execute();
			while(jrst.next()) {
				System.out.println(jrst.getString(1)+" "+jrst.getString(2)+" "+jrst.getString(3)+" "+jrst.getString(4));
			}//while
			System.out.println("==================================");
			OutputStream os=new FileOutputStream("student.xml");
			jrst.writeXml(os);
			System.out.println("===================================");
			jrst.writeXml(System.out);
		}//try
		
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
