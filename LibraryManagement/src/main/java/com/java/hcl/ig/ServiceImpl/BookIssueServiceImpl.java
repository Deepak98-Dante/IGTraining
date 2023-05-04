package com.java.hcl.ig.ServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hcl.ig.Model.BookInfo;
import com.java.hcl.ig.Model.BookIssue;
import com.java.hcl.ig.Model.LibUser;
import com.java.hcl.ig.Service.BookIssueService;
import com.java.hcl.ig.repository.BookInfoRepository;
import com.java.hcl.ig.repository.BookIssueRepository;
import com.java.hcl.ig.repository.UserRepository;

@Service
public class BookIssueServiceImpl implements BookIssueService{

	@Autowired
	BookIssueRepository bookIssueRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookInfoRepository bookInfoRepository;

	@Override
	public BookIssue createBookIssue(Long issuedTo, Long bookId, Long issuedBy, BookIssue bookIssue) {
		
		LibUser IssuedTo=userRepository.findById(issuedTo).get();
		LibUser IssuedBy=userRepository.findById(issuedBy).get();
		BookInfo book=bookInfoRepository.findByBookId(bookId);
		
		bookIssue.setIssuedBy(IssuedBy);
		bookIssue.setIssuedTo(IssuedTo);
		bookIssue.setBookId(book);
		bookIssue.setBookIssuedDate(new Date());
		bookIssue.setStatus("requested");
		bookIssue.setBookPages(bookIssue.getBookPages());
		bookIssue.setCreatedOn(bookIssue.getCreatedOn());
		bookIssue.setModifiedOn(bookIssue.getModifiedOn());
		bookIssue.setCreatedBy(bookIssue.getCreatedBy());
		bookIssue.setModifiedBy(bookIssue.getModifiedBy());
		return bookIssueRepository.save(bookIssue); 
	}

	@Override
	public List<BookIssue> getAllIssues() {
		
		return bookIssueRepository.findAll();
	}

	@Override
	public List<BookIssue> getIssueByStatus(String status) {
	
		return bookIssueRepository.findIssuesByStatus(status);
	}
	
}
