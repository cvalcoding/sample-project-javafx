package com.cvalcoding.sample_project_javafx;

import com.cvalcoding.sample_project_javafx.config.LogManager;
import com.cvalcoding.sample_project_javafx.model.dao.EmployeeDAOImpl;
import com.cvalcoding.sample_project_javafx.ui.Launcher;
import javafx.application.Application;

import java.sql.SQLException;

public class App {


	public static void main(String[] args) throws SQLException {
		LogManager.info("first test for info");
		Application.launch(Launcher.class, args);

	}
}