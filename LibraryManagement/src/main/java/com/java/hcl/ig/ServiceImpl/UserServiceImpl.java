package com.java.hcl.ig.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hcl.ig.Model.LibUser;
import com.java.hcl.ig.Service.UserService;
import com.java.hcl.ig.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public LibUser addUser(LibUser user)
	{
		
		return userRepository.save(user);
	}

	@Override
	public List<LibUser> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public LibUser getUserById(Long userId) {
		
		return userRepository.findById(userId).get();
	}

	@Override
	public LibUser updateUser(LibUser user) {

	
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
	
		
		userRepository.deleteById(userId);
	}

}
