package com.nt.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Workin_dateValues_Using_CJ {

	public static void main(String[] args) throws ParseException {
		String s1="10-02-1980";
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date ud1=sdf.parse(s1);
		System.out.println("STRING DATE::"+s1);
		System.out.println("java.util.date::"+ud1);
		long ms=ud1.getTime();
		java.sql.Date SD1=new java.sql.Date(ms);
		System.out.println("java.util.date::"+ms);
		System.out.println("java,sql.time::"+SD1);
		
		String s2="1997-08-17";
		java.sql.Date sd2=java.sql.Date.valueOf(s2);
		System.out.println("sring date 2::"+s2);
		System.out.println("java.sql.date::"+sd2);
		
		
		
		
		
	}

}
