package com.cvalcoding.sample_project_javafx.model.dao;

import com.cvalcoding.sample_project_javafx.config.DatabaseManager;
import com.cvalcoding.sample_project_javafx.config.Log;
import com.cvalcoding.sample_project_javafx.model.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends Dao<Employee> {

	static final String TABLE = "employees";

	/**
	 * Get All object
	 *
	 * @return List
	 */
	@Override
	public List<Employee> getAll() {
		String query = String.format("SELECT * FROM %s", TABLE);
		List<Employee> employeeList = new ArrayList<>();
		try (Connection connection = DatabaseManager.getInstance().getConnection();
		     PreparedStatement stmt = connection.prepareStatement(query)) {
			try (ResultSet rs = stmt.executeQuery(query)) {
				while (rs.next()) {
					Employee employee = createEmployee(rs);
					employeeList.add(employee);
				}
			}
		} catch (SQLException e) {
			Log.error(e.getMessage());
		}
		return employeeList;
	}

	/**
	 * Get single object
	 *
	 * @param id get element by id
	 * @return Employee
	 */
	@Override
	public Employee get(long id) {
		String query = String.format("SELECT * FROM %s WHERE employeeNumber = %s", TABLE, id);
		Employee employee = null;

		try (Connection connection = DatabaseManager.getInstance().getConnection();
		     PreparedStatement stmt = connection.prepareStatement(query)) {
			try (ResultSet rs = stmt.executeQuery(query)) {
				while (rs.next()) {
					employee = createEmployee(rs);
				}
			}
		} catch (SQLException e) {
			Log.error(e.getMessage());
		}

		return employee;
	}

	/**
	 * Add employee object
	 *
	 * @param employee params employee object
	 */
	@Override
	public void add(Employee employee) {
		String query = String.format("INSERT INTO %s VALUES (?, ?, ?, ?, ?, ?, ?, ?)", TABLE);
		try (Connection connection = DatabaseManager.getInstance().getConnection()
		) {
			connection.setAutoCommit(false);
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				ps.setLong(1, employee.getEmployeeNumber());
				ps.setString(2, employee.getLastName());
				ps.setString(3, employee.getFirstName());
				ps.setString(4, employee.getExtension());
				ps.setString(5, employee.getEmail());
				ps.setString(6, employee.getOfficeCode());
				ps.setInt(7, employee.getReportsTo());
				ps.setString(8, employee.getJobTitle());
				ps.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				Log.error(e.getMessage());
				connection.rollback();
			}
		} catch (SQLException e) {
			Log.error(e.getMessage());
		}
	}

	/**
	 * Update employee object
	 *
	 * @param employee params employee object
	 */
	@Override
	public void update(Employee employee) {
		String query = String.format("UPDATE %s SET lastName=?, firstName=?, extension=?, email=?, officeCode=?, reportsTo=?, jobTitle=? WHERE employeeNumber=?", TABLE);
		try (Connection connection = DatabaseManager.getInstance().getConnection()
		) {
			connection.setAutoCommit(false);
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				ps.setString(1, employee.getLastName());
				ps.setString(2, employee.getFirstName());
				ps.setString(3, employee.getExtension());
				ps.setString(4, employee.getEmail());
				ps.setString(5, employee.getOfficeCode());
				ps.setInt(6, employee.getReportsTo());
				ps.setString(7, employee.getJobTitle());
				ps.setLong(8, employee.getEmployeeNumber());

				ps.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				Log.error(e.getMessage());
				connection.rollback();
			}
		} catch (SQLException e) {
			Log.error(e.getMessage());

		}
	}

	/**
	 * Remove employee object
	 *
	 * @param employee params employee object
	 */
	@Override
	public void remove(Employee employee) {
		String query = String.format("DELETE FROM %s WHERE employeeNumber = %s", TABLE, employee.getEmployeeNumber());
		try (Connection connection = DatabaseManager.getInstance().getConnection()) {
			connection.setAutoCommit(false);
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				ps.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				Log.error(e.getMessage());
				connection.rollback();
			}
		} catch (SQLException e) {
			Log.error(e.getMessage());
		}
	}

	/**
	 *
	 * @param rs params result
	 * @return employee object
	 * @throws SQLException exception for mysql
	 */
	private Employee createEmployee(ResultSet rs) throws SQLException {
		return new Employee(
				rs.getLong("employeeNumber"),
				rs.getString("lastName"),
				rs.getString("firstName"),
				rs.getString("extension"),
				rs.getString("email"),
				rs.getString("officeCode"),
				rs.getInt("reportsTo"),
				rs.getString("jobTitle"));
	}
}
