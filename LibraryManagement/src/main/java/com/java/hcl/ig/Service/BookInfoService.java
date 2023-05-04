package com.java.hcl.ig.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.hcl.ig.Model.BookInfo;

@Service
public interface BookInfoService {

	public BookInfo createBook(BookInfo bookInfo);
	public BookInfo updateBook(BookInfo bookInfo);
	public BookInfo findBookbyId(Long BookId);
	public BookInfo findBookbyPublication(String BookPublication);
	public BookInfo findBookbyName(String BookName);
	public BookInfo findBookbyAuthor(String Author);
	public List<BookInfo> getAllBooks();
	public void deleteBookbyId(Long BookId);
}
