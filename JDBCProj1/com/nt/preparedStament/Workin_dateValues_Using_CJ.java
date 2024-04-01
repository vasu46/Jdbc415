package com.nt.preparedStament;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Workin_dateValues_Using_CJ {

	public static void main(String[] args) throws ParseException {
		String s1="10-02-1980";
		//converting the String values to SimpleDateFormat
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		//Simple date to java.util.Date
		java.util.Date ud1=sdf.parse(s1);
		System.out.println("STRING DATE::"+s1);
		System.out.println("java.util.date::"+ud1);
		System.out.println("==============================");
		//Converting java.util.Date to java.sql.Date
		long ms=ud1.getTime(); //coverting java.util.date to milliseconds 
		//coverson of millisections to java.sql.date
		java.sql.Date SD1=new java.sql.Date(ms);
		System.out.println("java.util.date::"+ms);
		System.out.println("java,sql.time::"+SD1);
		System.out.println("======================================");
		
		//converting the directly String value to Java.sql.Date("yyyy-mm-dd");
		String s2="1997-08-17";
		java.sql.Date sd2=java.sql.Date.valueOf(s2);
		System.out.println("sring date 2::"+s2);
		System.out.println("java.sql.date::"+sd2);
		System.out.println("=========================================");
		//retriveing the java.sql.date value to java.util.date
		   java.util.Date ud2=SD1;
             System.out.println("JAVA.UTIL.DATE::"+ud2);
             System.out.println("-============================================");
            //another way
             java.util.Date ud3= new java.util.Date(SD1.getTime());
             System.out.println("java.util.date::"+ud3);
             System.out.println("-============================================");
         //RETRIVING JAVA.UTIL.DATE TO SIMPLE DATE 
             SimpleDateFormat sdf3=new SimpleDateFormat("dd-MM-yyyy");
             String s3=sdf3.format(ud3);
             System.out.println("simpleDateFormat::"+s3);
             System.out.println("-============================================");
             String s4=sdf3.format(SD1);
             System.out.println("simpleDateFormat::"+s4);
             System.out.println("-============================================");
             
		
		
		
		
	}

}
