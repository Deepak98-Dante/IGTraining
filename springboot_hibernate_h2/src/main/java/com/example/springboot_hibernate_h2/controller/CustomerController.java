package com.example.springboot_hibernate_h2.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_hibernate_h2.model.Customer;
import com.example.springboot_hibernate_h2.service.CustomerService;

@RestController

public class CustomerController {

@Autowired
private CustomerService customerService;

@GetMapping("/customers")
public List<Customer> getAllCustomers(){
	return customerService.getAllCustomers();
	
}

@GetMapping("/customers/{id}")
public Customer getCustomer(@PathVariable("id") long id){
	return customerService.getCustomer(id);
	
}

@PostMapping("/add-customer")
public void addCustomer(@RequestBody Customer customer)
{
	customerService.addCustomer(customer);
}

@DeleteMapping("/customers/{id}")
public void deleteCustomer(@PathVariable("id")long id)
{
	customerService.delete(id);
}

}
