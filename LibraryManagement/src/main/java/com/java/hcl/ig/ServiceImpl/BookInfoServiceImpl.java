package com.java.hcl.ig.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hcl.ig.Model.BookInfo;
import com.java.hcl.ig.Service.BookInfoService;
import com.java.hcl.ig.repository.BookInfoRepository;

@Service
public class BookInfoServiceImpl implements BookInfoService{

	@Autowired
	private BookInfoRepository bookRepository;
	
	@Override
	public BookInfo createBook(BookInfo bookInfo) {
		
		return bookRepository.save(bookInfo);
	}

	@Override
	public BookInfo updateBook(BookInfo bookInfo) {
		
		return bookRepository.save(bookInfo);
	}

	@Override
	public BookInfo findBookbyId(Long BookId) {
		
		return bookRepository.findByBookId(BookId);
	}

	@Override
	public BookInfo findBookbyPublication(String BookPublication) {
		
		return bookRepository.findBybookPublication(BookPublication);
	}

	@Override
	public BookInfo findBookbyName(String BookName) {
	
		return bookRepository.findBybookName(BookName);
	}
	

	@Override
	public BookInfo findBookbyAuthor(String Author) {
		
		return bookRepository.findByAuthor(Author);
	}

	@Override
	public List<BookInfo> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public void deleteBookbyId(Long BookId) {
		
		bookRepository.deleteById(BookId);
		
	}

}
