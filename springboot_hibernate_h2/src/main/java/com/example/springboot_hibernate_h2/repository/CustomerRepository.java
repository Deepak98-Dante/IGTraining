package com.example.springboot_hibernate_h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_hibernate_h2.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}