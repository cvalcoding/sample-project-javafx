package com.cvalcoding.sample_project_javafx.service;

import com.cvalcoding.sample_project_javafx.config.Log;
import com.cvalcoding.sample_project_javafx.model.dao.EmployeeDAOImpl;
import com.cvalcoding.sample_project_javafx.model.entity.Employee;

import java.util.HashMap;
import java.util.List;

public class EmployeeService {

	private final EmployeeDAOImpl employeeDAO;

	/**
	 * Constructor
	 */
	public EmployeeService() {
		this.employeeDAO = new EmployeeDAOImpl();
	}

	/**
	 * Get all object
	 *
	 * @return list employee object
	 */
	public List<Employee> all() {
		return this.employeeDAO.getAll();
	}

	/**
	 * get object by id
	 *
	 * @param id params long type
	 * @return employee object
	 */
	public Employee getById(long id) {
		Employee employee = this.employeeDAO.getById(id);
		if(employee == null) {
			Log.error("User not found");
			return null;
		}
		return employee;
	}

	/**
	 *
	 * @param data map for data
	 */
	public void save(HashMap<String, String> data) {
		this.employeeDAO.create(createEmployee(data));
	}

	/**
	 *
	 * @param data map for data
	 */
	public void update(HashMap<String, String> data) {
		this.employeeDAO.update(createEmployee(data));
	}

	/**
	 *
	 * @param employee object for employee
	 */
	public void remove(Employee employee) {
		this.employeeDAO.delete(employee);
	}

	/**
	 *
	 * @param stringMap map obejct
	 * @return employee object
	 */
	private Employee createEmployee(HashMap<String, String> stringMap) {
		Employee employee = new Employee();
		employee.setEmployeeNumber(Long.parseLong(stringMap.get("employeeNumber")));
		employee.setLastName(stringMap.get("lastName"));
		employee.setFirstName(stringMap.get("firstName"));
		employee.setExtension(stringMap.get("extension"));
		employee.setEmail(stringMap.get("email"));
		employee.setOfficeCode(stringMap.get("officeCode"));
		employee.setReportsTo(Integer.parseInt(stringMap.get("reportsTo")));
		employee.setJobTitle(stringMap.get("jobTitle"));
		return employee;
	}
}
