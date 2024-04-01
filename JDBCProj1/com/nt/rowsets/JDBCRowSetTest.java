package com.nt.rowsets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JDBCRowSetTest {

	public static void main(String[] args) {
		  Properties pros=null;
		try(InputStream is=new FileInputStream("com/nt/rowsets/Info.properties")){
			pros=new Properties();
			pros.load(is);	
		}//try
		catch(FileNotFoundException fne) {
			fne.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		try(OracleJDBCRowSet jrst=new OracleJDBCRowSet()){
			jrst.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			jrst.setUsername("system");
			jrst.setPassword("7825");
			jrst.setCommand("SELECT * FROM STUDENT");
			jrst.execute();
			while(jrst.next()) {
				System.out.println(jrst.getString(1)+" "+jrst.getString(2)+" "+jrst.getString(3)+" "+jrst.getString(4));
			}//while
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
