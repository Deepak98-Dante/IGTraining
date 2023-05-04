package com.java.hcl.ig.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.hcl.ig.Model.BookIssue;
import com.java.hcl.ig.Service.BookIssueService;

@RestController
@RequestMapping(value="/lms/BookIssue")
public class BookIssueController {

	@Autowired
	private BookIssueService bookIssueService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookIssueController.class);
	
	//Create Book Issue
	@PostMapping("/create/{libuserId}/{libId}/{bookId}")
	public ResponseEntity<BookIssue> createBookIssue(@PathVariable Long libuserId,@PathVariable Long libId,
			@PathVariable Long bookId,@RequestBody BookIssue bookIssue){
		
		LOGGER.info("BookIssueController:: createBookIsuue!!!!input :" + bookIssue);
		BookIssue bookIssued = bookIssueService.createBookIssue(libuserId, libId, bookId, bookIssue);

		LOGGER.info("UserController:: addUser!!!output :" + bookIssued);

		return new ResponseEntity<>(bookIssued, HttpStatus.CREATED);
	}

	// GEt All BookIssues
	
	@GetMapping("/getAllBookIssues")
	public List<BookIssue> getAllBookIssues()
	{
		LOGGER.info("BookIssueController:: getAllBookIssues!!!!");
		return bookIssueService.getAllIssues();
	}
	
	//Get Book Issue by Transaction Status
	
	@GetMapping("/get/status")
	public ResponseEntity<List<BookIssue>> getIssueByStatus(@RequestParam String status) {
		LOGGER.info("UserController:: updateUser!!!!input :" + status);
		List<BookIssue> bookIssues = bookIssueService.getIssueByStatus(status);

		LOGGER.info("UserController:: updateUser!!!output :" + bookIssues);
		return new ResponseEntity<>(bookIssues, HttpStatus.OK);
	}
}
