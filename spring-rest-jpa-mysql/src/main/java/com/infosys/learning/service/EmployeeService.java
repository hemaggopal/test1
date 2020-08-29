package com.infosys.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.learning.exception.EmployeeException;
import com.infosys.learning.model.Employee;
import com.infosys.learning.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	public List<Employee> getEmployees() {
		return empRepository.findAll();
	}
	
	public Employee getEmployee(long employeeId) throws EmployeeException {
		Optional<Employee> employee = empRepository.findById(employeeId);
		if(!employee.isPresent())
			throw new EmployeeException("Employee not found");
		return employee.get();			
	}
	
	public void createEmployee(Employee employee) {
		empRepository.save(employee);		
	}
	
	public void updateEmployee(Employee employee) {
		empRepository.save(employee);		
	}
	
	public void deleteEmployee(long employeeId) {
		empRepository.deleteById(employeeId);		
	}
}
