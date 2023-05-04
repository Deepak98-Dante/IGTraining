package com.java.hcl.ig.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.hcl.ig.Model.LibUser;
import com.java.hcl.ig.Service.UserService;


@RestController
@RequestMapping(value="/lms/libuser")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<LibUser> addUser(@RequestBody LibUser user)
	{
		LibUser userdata=userService.addUser(user);
		
		return new ResponseEntity<LibUser>(userdata,HttpStatus.CREATED);
	}

	@GetMapping("/allusers")
	public List<LibUser> getAllUser()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<LibUser> getUserById(@PathVariable Long id)
	{
		LibUser user=userService.getUserById(id);
		return new ResponseEntity<LibUser>(user,HttpStatus.FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(LibUser user)
	{
		LibUser existinguser=userService.getUserById(user.getUserId());
		
		if(existinguser != null)
		{
			userService.updateUser(user);
			return new ResponseEntity<>("Updating User Data Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Updating User Data Failed",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable Long userId)
	{
		userService.deleteUser(userId);
	}
	
}
