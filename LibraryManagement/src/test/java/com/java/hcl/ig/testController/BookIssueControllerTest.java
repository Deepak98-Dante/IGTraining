package com.java.hcl.ig.testController;

import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
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

import com.java.hcl.ig.Controller.BookIssueController;
import com.java.hcl.ig.Model.BookInfo;
import com.java.hcl.ig.Model.BookIssue;
import com.java.hcl.ig.Model.LibUser;
import com.java.hcl.ig.ServiceImpl.BookIssueServiceImpl;
import com.java.hcl.ig.repository.BookInfoRepository;
import com.java.hcl.ig.repository.UserRepository;

@ComponentScan(basePackages = "com.java.hcl.ig.testController")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = { BookIssueControllerTest.class })
@TestMethodOrder(OrderAnnotation.class)
public class BookIssueControllerTest {
	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	BookIssueController bookIssueController;

	@Mock
	BookIssueServiceImpl bookIssueService;

	@Mock
	UserRepository userRepository;

	@Mock
	BookInfoRepository bookInfoRepository;

	BookIssue bookIssued;

	BookInfo bookInfo;

	List<BookIssue> booksIssues;

	LibUser user;

	@BeforeEach
	public void initData() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookIssueController).build();
	}

	@Test
	public void testGetAllIssues() throws Exception {
		booksIssues = new ArrayList<BookIssue>();
		booksIssues.add(BookIssue.builder().build());

		when(bookIssueService.getAllIssues()).thenReturn(booksIssues);

		List<BookIssue> res = bookIssueController.getAllBookIssues();
		assertEquals(1, res.size());
	}

	

	@Test
	public void testCreateBookIsuue() throws Exception {

		bookIssued = BookIssue.builder().bookIssuedDate(new Date()).status("Approved").build();
		Long libId = 1L;
		Long userId = 1L;
		Long bookId = 1L;

		when(bookIssueService.createBookIssue(libId, userId, bookId, bookIssued)).thenReturn(bookIssued);

		ResponseEntity<BookIssue> res = bookIssueController.createBookIssue(userId, libId, bookId, bookIssued);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(bookIssued, res.getBody());

	}
}
