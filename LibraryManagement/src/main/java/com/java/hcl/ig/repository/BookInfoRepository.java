package com.java.hcl.ig.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.hcl.ig.Model.BookInfo;

public interface BookInfoRepository extends JpaRepository<BookInfo, Long> {
	
	BookInfo findByBookId(Long bookId);
	BookInfo findBybookPublication(String bookPublication);
	BookInfo findByAuthor(String author);
	BookInfo findBybookName(String Name);
}
