package com.infosys.learning.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.learning.exception.EmployeeException;
import com.infosys.learning.model.Employee;
import com.infosys.learning.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
		
	@GetMapping("employee/{employeeId}")
	@ResponseBody
	public Employee getEmployee(@PathVariable("employeeId")long employeeId) throws EmployeeException {
		return empService.getEmployee(employeeId);
	}
	
	@GetMapping("employees")
	@ResponseBody
	public List<Employee> getEmployees() {
		return empService.getEmployees();
		/*
		 * Employee employee1 = new Employee(1, "E1"); Employee employee2 = new
		 * Employee(2, "E2"); List<Employee> employees = Arrays.asList(employee1,
		 * employee2); return employees;
		 */
	}
	
	@PostMapping("employees")
	public ResponseEntity createEmployee(@RequestBody Employee employee) {
		empService.createEmployee(employee);
		return ResponseEntity.ok("Created successfully");//status(HttpStatus.OK).build();
	}
	

	@PutMapping("employee/{employeeId}")
	public ResponseEntity updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") long empId) {
		try {
			empService.getEmployee(empId);
		} catch(EmployeeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());			
		}
		empService.updateEmployee(employee); 
		return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");		
	}
	
	@DeleteMapping("employee/{employeeId}")
	public ResponseEntity deleteEmployee(@PathVariable("employeeId") long empId) {
		empService.deleteEmployee(empId);
		return ResponseEntity.ok("Employee deleted successfully.");
	}
}
