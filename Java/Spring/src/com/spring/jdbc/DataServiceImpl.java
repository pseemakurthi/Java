package com.spring.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataServiceImpl  implements DataService{
    private String DATABASE_USER;
    private String DATABASE_PASSWORD;
    private String DATABASE_URL;
    private String DATABASE_DRIVER;
    
    
	@Override
	public void printNews() {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			Class.forName(DATABASE_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
			java.sql.Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery("SELECT * from News");
			
			while(result.next()){
				System.out.println("headline" + result.getString(2));
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	public void setDATABASE_USER(String dATABASE_USER) {
		DATABASE_USER = dATABASE_USER;
	}


	public void setDATABASE_PASSWORD(String dATABASE_PASSWORD) {
		DATABASE_PASSWORD = dATABASE_PASSWORD;
	}


	public void setDATABASE_URL(String dATABASE_URL) {
		DATABASE_URL = dATABASE_URL;
	}


	public void setDATABASE_DRIVER(String dATABASE_DRIVER) {
		DATABASE_DRIVER = dATABASE_DRIVER;
	}

}
