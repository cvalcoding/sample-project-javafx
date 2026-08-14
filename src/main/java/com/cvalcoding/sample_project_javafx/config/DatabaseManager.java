package com.cvalcoding.sample_project_javafx.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {

	static final String DB_URL = "jdbc:mysql://localhost/javafx";
	static final String USER = "javauser";
	static final String PWD = "javauser";
	static private DatabaseManager instance;
	private Connection connection;

	private DatabaseManager() throws SQLException {
		try (InputStream input = DatabaseManager.class.getClassLoader().getResourceAsStream("config.properties")) {
			Properties prop = new Properties();
			prop.load(input);

			String url = String.format("jdbc:%s://%s/%s", prop.getProperty("db.jdbc"), prop.getProperty("db.url"),
					prop.getProperty("db.name"));

			try {
				this.connection = DriverManager.getConnection(url, prop.getProperty("db.user"),
						prop.getProperty("db.pwd"));
			} catch (SQLException e) {
				Log.error(e.getMessage());
			}

		} catch (IOException e) {
			Log.error(e.getMessage());
			throw new RuntimeException(e);
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
