package com.hellospringdemo.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import org.postgresql.Driver;
import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {			
		
		try {
			Class.forName("org.postgresql.Driver");

            String jdbcUrl = "jdbc:postgresql://localhost:5432/student?useSSL=false&serverTimezone=UTC";
            String user = "postgres";
            String pass = "bucha1167";

			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!! " + myConn);
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
    
    }
}