package com.example.SpringBatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBatch.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
