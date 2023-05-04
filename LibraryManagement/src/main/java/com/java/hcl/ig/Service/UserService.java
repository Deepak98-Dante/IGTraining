package com.java.hcl.ig.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.hcl.ig.Model.LibUser;

@Service
public interface UserService {
	
	public LibUser addUser(LibUser user);
	
	public List<LibUser> getAllUser();
	
	public LibUser getUserById(Long userId);
	
	public LibUser updateUser(LibUser user);
	
	public void deleteUser(Long userId);

}
