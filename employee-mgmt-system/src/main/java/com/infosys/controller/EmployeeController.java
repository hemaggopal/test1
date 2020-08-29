package com.infosys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.model.Employee;
import com.infosys.service.IEmployeeService;
import com.infosys.util.EmployeeUtil;

@RestController
@RequestMapping("/")
public class EmployeeController {
	@Autowired
	IEmployeeService employeeService;
	
	@Value("${employee.deleted.successfully}")
	private String employeeDeletedSuccMsg;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(@RequestParam("sortField") Optional<String> sortField, @RequestParam("sortDirection") Optional<String> sortDirection) {
		//System.out.println("sortField: " + sortField + ", " + sortDirection);
		return employeeService.getEmployees(sortField, sortDirection);
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeById(@PathVariable("empId")long empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping("/employee/{empId}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("empId") long empId) {
		return employeeService.updateEmployee(employee, empId);
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empId") long empId) {
		employeeService.deleteEmployee(empId);
		return ResponseEntity.ok(EmployeeUtil.formatMsg(employeeDeletedSuccMsg, empId));
	}
	
	@GetMapping("/manager/{managerId}")
	public List<Employee> getEmployeesByManager(@PathVariable("managerId") long managerId) {
		return employeeService.getEmployeesByManager(managerId);
	}
}