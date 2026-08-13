package com.cvalcoding.sample_project_javafx.controller;

import com.cvalcoding.sample_project_javafx.model.entity.Employee;
import com.cvalcoding.sample_project_javafx.service.EmployeeService;

import java.util.HashMap;
import java.util.List;

public class EmployeeController extends Controller<Employee> {

	private final EmployeeService employeeService;

	public EmployeeController() {
		this.employeeService = new EmployeeService();
	}

	@Override
	public List<Employee> index() {
		return this.employeeService.all();
	}

	@Override
	public Employee show(long id) {
		return this.employeeService.getById(id);
	}

	@Override
	public void create(HashMap<String, String> dataMap) {
		this.employeeService.save(dataMap);
	}

	@Override
	public void edit(HashMap<String, String> dataMap) {
		this.employeeService.update(dataMap);
	}

	@Override
	public void destroy(Employee employee) {
		this.employeeService.remove(employee);
	}
}
