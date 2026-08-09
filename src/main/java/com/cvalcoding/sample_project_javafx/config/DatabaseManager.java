package com.cvalcoding.sample_project_javafx.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	static final String DB_URL = "jdbc:mysql://localhost/javafx";
	static final String USER = "javauser";
	static final String PWD = "javauser";
	static private DatabaseManager instance;
	private Connection connection;

	private DatabaseManager() throws SQLException {
		try {
			this.connection = DriverManager.getConnection(DB_URL, USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseManager getInstance() throws SQLException {
		if(instance == null || instance.getConnection().isClosed() || instance.getConnection().isValid(2)) {
			instance = new DatabaseManager();
		}

		return instance;
	}

	public Connection getConnection() {
		return this.connection;
	}
}
