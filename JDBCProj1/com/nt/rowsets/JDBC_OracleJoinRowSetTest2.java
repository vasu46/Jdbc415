package com.nt.rowsets;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

public class JDBC_OracleJoinRowSetTest2 {

	public static void main(String[] args) {
	
		try(OracleCachedRowSet crs1=new OracleCachedRowSet();
				OracleCachedRowSet crs2=new OracleCachedRowSet();
				OracleJoinRowSet jrs=new OracleJoinRowSet()){
				
			crs1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs1.setUsername("system");
			crs1.setPassword("7825");
			crs1.setMatchColumn(5);	
			crs1.setCommand("SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP");
			crs1.execute();
			
			crs2.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs2.setUsername("system");
			crs2.setPassword("7825");
			crs2.setMatchColumn(1);	
			crs2.setCommand("SELECT DEPTNO,DNAME,LOC FROM DEPT");
			crs2.execute();
			//add commeds into join Rowset
			  jrs.addRowSet(crs2);
			  jrs.addRowSet(crs1);
			   while(jrs.next()) {
				   System.out.println(jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getString(4)+" "+jrs.getString(5)+" "+jrs.getString(6)+" "+jrs.getString(7));
			   }
			  
			
			
			
		}//try
		
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
