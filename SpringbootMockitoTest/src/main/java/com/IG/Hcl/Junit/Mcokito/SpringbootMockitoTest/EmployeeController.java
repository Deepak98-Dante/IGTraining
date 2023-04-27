package com.IG.Hcl.Junit.Mcokito.SpringbootMockitoTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}
	
	@GetMapping(value="{id}")
	public Employee getEmployeebyId(@PathVariable(value="id") Long id)
	{
		return employeeRepository.findById(id).get();
	}
	
	@PostMapping
	public void addEmployee(Employee emp)
	{
		employeeRepository.save(emp);
	}
}
