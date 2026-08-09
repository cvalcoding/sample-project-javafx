package com.cvalcoding.sample_project_javafx;

import com.cvalcoding.sample_project_javafx.model.dao.EmployeeDAOImpl;
import com.cvalcoding.sample_project_javafx.ui.Launcher;
import javafx.application.Application;

import java.sql.SQLException;

public class App {
	static final String QUERY = "SELECT * FROM employees";

	public static void main(String[] args) throws SQLException {
		
		Application.launch(Launcher.class, args);
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

		/* Insert */
//		Employee employee = new Employee();
//		employee.setEmployeeNumber(1200);
//		employee.setLastName("dupond");
//		employee.setFirstName("paul");
//		employee.setExtension("x302");
//		employee.setEmail("paul.dupond@dev.com");
//		employee.setOfficeCode("2");
//		employee.setReportsTo(1102);
//		employee.setJobTitle("Sales Rep");
//
//		employeeDAO.add(employee);


//		List<Employee> employeeList = employeeDAO.getAll();
//
//		Employee employee = employeeList.stream().filter(emp -> emp.getEmployeeNumber() == 1200).findAny().orElse(null);
//		Employee employee = employeeDAO.getAll().stream().filter(emp -> "1200".equals(emp.getEmployeeNumber())).findAny().orElse(null);

//		for (Employee employee : employeeDAO.getAll()) {
//			System.out.println(employee.getEmployeeNumber());
//		}



		/* Get */
//		Employee employee = employeeDAO.get(1200);

		/* Update */
//		employee.setFirstName("toto");
//		employee.setLastName("titita");
//		employeeDAO.update(employee);

//		System.out.println(employee.getLastName());
//		System.out.println(employee.getFirstName());

		/* Remove */
//		employeeDAO.remove(employee);


	}
}