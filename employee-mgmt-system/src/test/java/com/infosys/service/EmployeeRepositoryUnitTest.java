package com.infosys.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.model.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeRepositoryUnitTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private IEmployeeService service;
	
	@Test
    public void testGetEmployees() throws Exception {
		Mockito.when(service.getEmployees(Optional.empty(), Optional.empty())).thenReturn(Stream.of(new Employee(), new Employee()).collect(Collectors.toList()));
		MvcResult mvcResult = mockmvc.perform(MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON)).andReturn();
		//System.out.println(mvcResult.getResponse().getContentAsString());
		ObjectMapper mapper = new ObjectMapper();
		List<Employee> employees = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Employee>>() {}) ;
		System.out.println(employees);
		Assert.assertEquals(2, employees.size());
	}
        
}
