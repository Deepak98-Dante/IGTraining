package com.java.hcl.ig.testController;

import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.java.hcl.ig.Controller.UserController;
import com.java.hcl.ig.Model.LibUser;
import com.java.hcl.ig.ServiceImpl.UserServiceImpl;

@ComponentScan(basePackages = "com.java.hcl.ig.testController")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = { UserControllerTest.class })
@TestMethodOrder(OrderAnnotation.class)
public class UserControllerTest {
	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	UserController userController;

	@Mock
	UserServiceImpl userService;

	LibUser user;

	List<LibUser> users;

	@BeforeEach
	public void initData() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	// add User
	@SuppressWarnings("static-access")
	@DisplayName("test_AddUser")
	@Test
	@Order(1)
	public void testAddUser() throws Exception {

		LibUser user = LibUser.builder().userId(1L).userEmailId("Ram@gmail.com").userName("Ram").build();

		when(userService.addUser(user)).thenReturn(user);

		ResponseEntity<LibUser> res = userController.addUser(user);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(user, res.getBody());

	}

	// update User
	@DisplayName("test_UpdateUser")
	@Test
	@Order(2)
	public void testUpdateUser() throws Exception {

		user = new LibUser().builder().userId(1L).userEmailId("Deepak@gmail.com").userName("Deepak").build();
		
		userService.addUser(user);
		LibUser updateuser = new LibUser().builder().userId(1L).userEmailId("Deepak@gmail.com").userName("Krishnan").build();
		when(userService.updateUser(updateuser)).thenReturn(updateuser);

		ResponseEntity<String> res = userController.updateUser(user);

		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals("Updating User Data Success", res.getBody());

	}

	// Search user By userId
	@DisplayName("test_GetByUserId")
	@Test
	@Order(3)
	public void testGetByUserId() throws Exception {
		user = new LibUser().builder().userId(1L).userEmailId("Rahul@gmail.com").userName("Rahul").build();
		Long userId = 1L;

		when(userService.getUserById(userId)).thenReturn(user);

		ResponseEntity<LibUser> res = userController.getUserById(userId);
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(userId, res.getBody().getUserId());

	}

	// get all users
	@DisplayName("test_GetAllUsers")
	@Test
	@Order(4)
	public void testGetAllUsers() throws Exception {

		users = new ArrayList<LibUser>();
		users.add(LibUser.builder().userName("Ramesh").userAge(25L).userEmailId("ramesh@gmail.com").userGender("Male")
				.userMobileNo("9999999999").userAddress("Mumbai").userType("STU").userStatus("Active").build());

		when(userService.getAllUser()).thenReturn(users);
		List<LibUser> res = userController.getAllUser();
		//assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(1, res.size());

	}
}
