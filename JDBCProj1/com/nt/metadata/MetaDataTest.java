package com.nt.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaDataTest {

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
				 ){
			   //create the DataBaseMataData obj
			  DatabaseMetaData dbmd=con.getMetaData();
			    if(dbmd!=null) {
			    	System.out.println("db s/w name::"+dbmd.getDatabaseProductName());
			    	System.out.println("db s/wversion::"+dbmd.getDatabaseProductVersion());
			    	System.out.println("db s/w driver name::"+dbmd.getDriverName());
			    	System.out.println("db s/w driver version::"+dbmd.getDriverVersion());
			    	System.out.println("ALL SQL KEYWORDS::"+dbmd.getSQLKeywords());
			    	System.out.println("All numberic functions::"+dbmd.getNumericFunctions());
			    	System.out.println("ALL SYSTEM FUNCTIONS::"+dbmd.getSystemFunctions());
			    	System.out.println("all string functions::"+dbmd.getStringFunctions());
			    	System.out.println("max chars in table name::"+dbmd.getMaxTableNameLength());
			    	System.out.println("max tables in a selec query::"+dbmd.getMaxTablesInSelect());
			    	System.out.println("max row size::"+dbmd.getMaxRowSize());
			    	System.out.println("Suuprots PL/SQL PROCEDURES?::"+dbmd.supportsStoredProcedures());
			    	
			    }
			   
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
				

	}

}
