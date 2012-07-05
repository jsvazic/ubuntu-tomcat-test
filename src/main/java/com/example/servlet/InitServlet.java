package com.example.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitServlet implements ServletContextListener {

	public void contextInitialized(ServletContextEvent ctx) {
		// Startup and initialize the HSQL DB
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException ex) {
			System.err.println("Failed to load the HSQLDB JDBC driver!");
			ex.printStackTrace();
			return;
		}

		Connection c = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		try {
			c = DriverManager.getConnection("jdbc:hsqldb:file:/tmp/testdb", "SA", "");
			stmt = c.createStatement();
			stmt.execute("DROP TABLE IF EXISTS messages");
			stmt.execute("CREATE TABLE messages (id INTEGER PRIMARY KEY, msg VARCHAR(50))");
			
			ps = c.prepareStatement("INSERT INTO messages (id, msg) VALUES (?, ?)");
			ps.setInt(1, 1);
			ps.setString(2, "Hello, world!");
			ps.executeUpdate();

			ps.setInt(1, 2);
			ps.setString(2, "It's Alive!!!");
			ps.executeUpdate();

		} catch (Exception ex) {
			System.err.println("Failed to populate the database!");
			ex.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void contextDestroyed(ServletContextEvent ctx) {
	}
}
