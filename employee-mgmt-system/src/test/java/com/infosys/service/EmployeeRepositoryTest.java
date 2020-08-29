package com.infosys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.model.Employee;
import com.infosys.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
    public void testFindAllWithIds() {
        Sort ascendingName = Sort.by(Direction.ASC, "name");
        List<Employee> employees = new ArrayList();
        Mockito.when(employeeRepository.findAll(ascendingName)).thenReturn(employees);
        System.out.println(employees.toString());
        employeeService.getEmployees(Optional.empty(), Optional.empty());
        //assertThat(continents.toString(), equalTo("[Africa, Antarctica, Asia, Europe, North America, Oceania, South America]"));
    }
}
