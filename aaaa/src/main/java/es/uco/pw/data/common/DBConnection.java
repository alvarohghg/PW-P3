package es.uco.pw.data.common;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A class to manage the MySQL connection (general methods and configuration).
 * @author Alvaro Berjillos
 * @author Francisco Javier Diaz
 * @author Alvaro Sanchez
 * */
public class DBConnection {
	protected Connection connection = null;

	// Important: This configuration is hard-coded here for illustrative purposes only
	
	protected String url = "jdbc:mysql://oraclepr.uco.es:3306/i92dicaf";

	protected String user = "i92dicaf";
 
	protected String password = "pw2021";

	public Connection getConnection(){

		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(url, user, password);
			//System.out.println("Database connection successfully opened!");
		} 
		catch (SQLException e) {
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}
		return this.connection;
	}

	// We can include here other methods to encapsulate CRUD commands...

	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				//System.out.println("Database connection successfully closed!");
			}
		} catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}
	
	/*
	public String propiedades(int r) {
		
		Properties prop = new Properties();
		String filename = "config.properties";
		String f=null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			prop.load(reader);
			if(r==1) {
				f = prop.getProperty("url");
			}
			else if(r==2) {
				f = prop.getProperty("user");
			}
			else {
				f = prop.getProperty("password");
			}
			//System.out.println(f);			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}*/
	
}
