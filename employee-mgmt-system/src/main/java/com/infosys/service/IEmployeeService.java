package com.infosys.service;

import java.util.List;
import java.util.Optional;

import com.infosys.exception.EmployeeException;
import com.infosys.model.Employee;

public interface IEmployeeService {

	public List<Employee> getEmployees(Optional<String> sortField, Optional<String> sortDirection);
	public Employee getEmployeeById(long empId);
	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(Employee employeeToBeUpdated, long empId) throws EmployeeException;
	public void deleteEmployee(long empId);
	public List<Employee> getEmployeesByManager(long managerId);
}
