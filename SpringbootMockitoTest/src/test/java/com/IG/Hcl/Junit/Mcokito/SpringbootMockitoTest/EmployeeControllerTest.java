package com.IG.Hcl.Junit.Mcokito.SpringbootMockitoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.hamcrest.Matchers.*;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class EmployeeControllerTest {
	
	private MockMvc mockMvc;

	@InjectMocks
	EmployeeController emp;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	
	Employee employee1=new Employee(21L, "Deepak", "R&D");
	Employee employee2=new Employee(23L, "Deepak", "R&D");
	Employee employee3=new Employee(24L, "Deepak", "R&D");
	
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(emp).build();
	}
	
	//Get All Employee
	@Test
	public void testAllEmployee() throws Exception {
		List<Employee> data=new ArrayList<>();
		data.add(employee1);
		data.add(employee2);
		data.add(employee3);
		when(employeeRepository.findAll()).thenReturn(data);
		assertThat(data.size()).isEqualTo(3);
		assertThat(data.size()).isGreaterThan(1);
		verify(employeeRepository,times(1)).findAll();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/Employee").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		//.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
		//.andExpect(jsonPath("$[2].getid()", is(24L)));
		
	}
	
	//Save Employee
	@Test
	public void testAddEmployee() {

		Employee employee=new Employee(21L, "Deepak", "R&D");
	System.out.println(	when(employeeRepository.save(employee)).thenReturn(employee));
		emp.addEmployee(employee);
		assertNotNull(employee);
		verify(employeeRepository, times(1)).save(employee);
	}
	
	
}

