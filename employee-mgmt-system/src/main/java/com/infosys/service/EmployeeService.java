package com.infosys.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.infosys.exception.EmployeeException;
import com.infosys.model.Department;
import com.infosys.model.Employee;
import com.infosys.repository.DepartmentRepository;
import com.infosys.repository.EmployeeRepository;
import com.infosys.util.EmployeeUtil;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Value("${employee.not.found}")
	private String employeeNotFoundErrMsg;
	
	@Value("${dept.not.found}")
	private String deptNotFoundErrMsg;

	@Override
	public List<Employee> getEmployees(Optional<String> sortField, Optional<String> sortDirection) {		
		return employeeRepository.findAll(
				Sort.by(sortDirection.orElseGet(()->"ASC").equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, 
						sortField.orElseGet(()->"employeeId")));
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Department department = getDepartment(employee.getDepartment().getDepartmentId());
		employee.setDepartment(department);
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employeeToBeUpdated, long empId) throws EmployeeException {
		Employee employee = null;
		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		if (!optionalEmployee.isPresent()) {
			throw new EmployeeException(EmployeeUtil.formatMsg(employeeNotFoundErrMsg, empId));
		} else
			employee = optionalEmployee.get();

		employee.setEmployeeName(employeeToBeUpdated.getEmployeeName());
		employee.setManagerId(employeeToBeUpdated.getManagerId());
		if (employeeToBeUpdated.getDepartment() != null
				&& employeeToBeUpdated.getDepartment().getDepartmentId() != employee.getDepartment().getDepartmentId())
			employee.setDepartment(getDepartment(employeeToBeUpdated.getDepartment().getDepartmentId()));
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(long empId) {
		try {
			employeeRepository.deleteById(empId);
		} catch(EmptyResultDataAccessException ex) {
			throw new EmployeeException(EmployeeUtil.formatMsg(employeeNotFoundErrMsg, empId));
		}
	}

	@Override
	public List<Employee> getEmployeesByManager(long managerId) {
		return employeeRepository.findByManager(managerId);
		// return null;
	}

	private Department getDepartment(long deptId) {
		try {
			Optional<Department> optionalDepartment = departmentRepository.findById(deptId);
			return optionalDepartment.get();
		} catch(NoSuchElementException ex) {
			throw new EmployeeException(EmployeeUtil.formatMsg(deptNotFoundErrMsg, deptId));
		}
	}

	@Override
	public Employee getEmployeeById(long empId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		if(optionalEmployee.isPresent())
			return optionalEmployee.get();
		else
			throw new EmployeeException(EmployeeUtil.formatMsg(employeeNotFoundErrMsg, empId));
	}
}