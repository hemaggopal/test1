package com.infosys.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.model.Employee;
//https://www.youtube.com/watch?v=ackhP0ubtd4
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRepositoryIntegrationTest {
	
	@Autowired
	MockMvc mockmvc;

	@Test
	public void testGetAllEmployees() throws Exception {
		MvcResult result = mockmvc.perform(MockMvcRequestBuilders.get("/employees")).andReturn();
		ObjectMapper mapper = new ObjectMapper();
		List<Employee> employees = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Employee>>() {});
		System.out.println(employees.toString());
	}

}
