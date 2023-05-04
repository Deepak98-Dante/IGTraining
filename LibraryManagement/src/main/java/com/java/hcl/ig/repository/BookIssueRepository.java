package com.java.hcl.ig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.hcl.ig.Model.BookIssue;

public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {
	List<BookIssue> findIssuesByStatus(String status);
}
