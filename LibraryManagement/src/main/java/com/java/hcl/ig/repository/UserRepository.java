package com.java.hcl.ig.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.hcl.ig.Model.LibUser;

public interface UserRepository extends JpaRepository<LibUser, Long>{
	
	//Optional<User> findUserByEmailId(String userEmailId);
}
