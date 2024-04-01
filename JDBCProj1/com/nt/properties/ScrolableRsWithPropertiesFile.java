package com.nt.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.xdevapi.Result;

public class ScrolableRsWithPropertiesFile {
	private static final String SELECT_QUERY_EMP="SELECT EMPNO,ENAME,JOB,HIREDATE,SAL,COMM,DEPTNO FROM EMP";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Properties props=null;
	try(InputStream is=new FileInputStream("com/nt/properties/Info.properties")){
		  props=new Properties();
		  props.load(is);
	    }
	catch(FileNotFoundException fne) {
		fne.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	try(Connection con=DriverManager.getConnection(props.getProperty("jdbc.url")
			          ,props.getProperty("jdbc.username"),
			           props.getProperty("jdbc.password"));
		  Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(SELECT_QUERY_EMP);
			){
		if(rs!=null) {
			System.out.println("RS records top to bottom ");
		  while(rs.next()) {
			  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getFloat(5)+" "+rs.getFloat(6)+rs.getInt(7));
			  System.out.println("===================================================");
		  }
		  System.out.println("records from buttom to top");
		  rs.afterLast();
		  while(rs.previous()) {
			  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getFloat(5)+" "+rs.getFloat(6)+rs.getInt(7));
			  System.out.println("===================================================");	  
		  }
		  System.out.println("firest record");
		  rs.first();
		  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getFloat(5)+" "+rs.getFloat(6)+rs.getInt(7));
		  System.out.println("===================================================");
		  rs.last();
		  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getFloat(5)+" "+rs.getFloat(6)+rs.getInt(7));
		  System.out.println("===================================================");
		  rs.absolute(3);
		  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getFloat(5)+" "+rs.getFloat(6)+rs.getInt(7));
		  System.out.println("===================================================");
		  rs.absolute(-6);
		  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getFloat(5)+" "+rs.getFloat(6)+rs.getInt(7));
		  System.out.println("===================================================");
		  rs.relative(3);
		  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getFloat(5)+" "+rs.getFloat(6)+rs.getInt(7));
		  System.out.println("===================================================");
		  rs.relative(-3);
		  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getFloat(5)+" "+rs.getFloat(6)+rs.getInt(7));
		  System.out.println("===================================================");
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
