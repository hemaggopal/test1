package com.infosys.service;

import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.exception.EmployeeException;
import com.infosys.model.Employee;
import com.infosys.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceUnitTest {

	@Mock
	EmployeeRepository mockEmplRepository;

	@InjectMocks
	EmployeeService employeeService;

	/*@Test
	public void testFindAll() {

		List<Employee> employees = new ArrayList<>();
		Mockito.when(mockEmplRepository.findAll(org.mockito.ArgumentMatchers.isA(Sort.class), "")).thenReturn(employees);
		employeeService.getEmployees(Optional.empty(), Optional.empty());

	}*/

	@Test
	public void testDeleteValidEmployee() {
		long empId = 1;
		System.out.println(mockEmplRepository.toString());
		doNothing().when(mockEmplRepository).deleteById(empId);
		employeeService.deleteEmployee(empId);
	}

	@Test(expected = EmployeeException.class)
	public void testDeleteInvalidEmployee() {
		long invalidEmpId = -1;
		Mockito.doThrow(EmployeeException.class).when(mockEmplRepository).deleteById(invalidEmpId);
		employeeService.deleteEmployee(invalidEmpId);
	}

}
