package com.java.hcl.ig.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.hcl.ig.Model.BookIssue;

@Service
public interface BookIssueService {

	BookIssue createBookIssue(Long userId, Long bookId, Long libId, BookIssue bookIssue);

	List<BookIssue> getAllIssues();

	List<BookIssue> getIssueByStatus(String status);
}
