package com.example.junit.SpringBootJUnitTest.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.junit.SpringBootJUnitTest.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

	

}
