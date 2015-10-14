package com.spring.jdbc;

import java.beans.Statement;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StandaloneJDBC {
	public final static String DATABASE_USER = "dbuser";
	public final static String DATABASE_PASSWORD = "dbpassword";
	public final static String DATABASE_URL = "jdbc:postgresql://192.168.1.53:5432/bellinfodevdb";
	public final static String DATABASE_DRIVER_CLASS = "org.postgresql.Driver";
	
	public static void main(String... args){
		 Connection connection = null;
		 
		 try{
			 Class.forName(DATABASE_DRIVER_CLASS); //static code is run
			 connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
			 java.sql.Statement statement = connection.createStatement();
			 String Query = "SELECT * FROM NEWS";
			 ResultSet result = statement.executeQuery(Query);
			 
			 while(result.next()){
				 
				 System.out.println("***********************************");
				 System.out.println("STICKER SYMBOL"+result.getString(1));
				 System.out.println("HEAD LINE" +result.getString(2));
				 System.out.println("MAIN STORY" +result.getString(3));
				 System.out.println("***********************************");
			 }
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }finally{
			 try{
				 connection.close();
			 }catch(SQLException e){
				 e.printStackTrace();
			 }
		 }
	}
}
