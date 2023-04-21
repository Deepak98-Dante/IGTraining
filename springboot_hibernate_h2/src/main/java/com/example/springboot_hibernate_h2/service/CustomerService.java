package com.example.springboot_hibernate_h2.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot_hibernate_h2.model.Customer;

import com.example.springboot_hibernate_h2.repository.CustomerRepository;

@Service
public class CustomerService {

@Autowired
private CustomerRepository customerRepository;

public List<Customer> getAllCustomers(){
	
	List<Customer> customers=new ArrayList();
	customerRepository.findAll().forEach(customers::add);
	return customers;
	
}

public Customer getCustomer(long id)
{
   return customerRepository.findById(id).get();
	
}

public void addCustomer(Customer customer)
{
	
	customerRepository.save(customer);
}

public void delete(long id)
{
	customerRepository.deleteById(id);
}

}
