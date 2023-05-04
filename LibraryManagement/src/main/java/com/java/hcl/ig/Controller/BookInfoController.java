package com.java.hcl.ig.Controller;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.hcl.ig.Exception.ResourceNotFoundException;
import com.java.hcl.ig.Model.BookInfo;
import com.java.hcl.ig.Model.LibUser;
import com.java.hcl.ig.Service.BookInfoService;
import com.java.hcl.ig.repository.UserRepository;

@RestController
@RequestMapping(value="/lms/bookInfo")
public class BookInfoController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookInfoService bookInfoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookInfoController.class);
	
	//Create Book 
	@PostMapping("/create/{libid}")
	public ResponseEntity<BookInfo> createBook(@PathVariable Long libid,@RequestBody BookInfo bookInfo){
		
		LOGGER.info("BookInfoController:: createBook!!!!input :" + libid);
		
		LibUser lib=userRepository.findById(libid).get();
		if(lib == null)
		{
			throw new NoSuchElementException("Librarian id"+libid+"not Found");
			
		}
		else
		{
			bookInfo.setCreatedBy(lib);
			bookInfo.setCreatedOn(new Date());
			
			LOGGER.info("BookInfoController:: createBook!!!output :" + bookInfo);
			
			return new ResponseEntity<BookInfo>(bookInfoService.createBook(bookInfo),HttpStatus.CREATED);
		}
		
	}
	
	//Search Book by ID
	@GetMapping("/search/bookid")
	public ResponseEntity<BookInfo> searchByBookId(@RequestParam("id") Long bookId) //throws Exception
	{
		BookInfo book=bookInfoService.findBookbyId(bookId);
		if(book==null)
		{
			//Resource Not Found
			LOGGER.error("BookInfoController:: searchByBookId!!!! ResourceNotFoundException:");
			throw new ResourceNotFoundException("Book not Found with Id:"+bookId);
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			LOGGER.info("BookInfoController:: searchByBookId!!!!output :" + book);
			return new ResponseEntity<BookInfo>(book,HttpStatus.FOUND);
		}
	}
	
	//Search by Name
	@GetMapping("/search/bookname")
	public ResponseEntity<BookInfo> searchByBookName(@RequestParam String bookName)
	{
		LOGGER.info("BookInfoController:: searchByBookId!!!!input :" + bookName);
		BookInfo book=bookInfoService.findBookbyName(bookName);
		
		LOGGER.info("BookInfoController:: searchByBookId!!!!output :" + book);
		return new ResponseEntity<BookInfo>(book,HttpStatus.FOUND);
	}
	
	//Search By Book Publication
	@GetMapping("/search/bookPublication")
	public ResponseEntity<BookInfo> searchByBookPublication(@RequestParam String bookPublication)
	{
		LOGGER.info("BookInfoController:: searchByBookPublication!!!!input :" + bookPublication);
		BookInfo book = bookInfoService.findBookbyPublication(bookPublication);
		if(book==null)
		{
			LOGGER.error("BookInfoController:: searchByBookPublication!!!! ResourceNotFoundException:");
			throw new ResourceNotFoundException("Book not found With bookPublication:" + bookPublication );
		}
		else
		{
			LOGGER.info("BookInfoController:: searchByBookPublication!!!!output :" + book);
			return new ResponseEntity<>(book, HttpStatus.FOUND);
		}
	}
	
	// SearchBook ByAuthor
		@GetMapping("/search/author")
		public ResponseEntity<BookInfo> searchByAuthor(@RequestParam String author) {

			LOGGER.info("BookInfoController:: searchByAuthor!!!!input :" + author);
			BookInfo book = bookInfoService.findBookbyAuthor(author);

			if (book == null) {

				LOGGER.error("BookInfoController:: searchByAuthor!!!! ResourceNotFoundException:");
				throw new ResourceNotFoundException("book not found With author :" + author);
			} else {

				LOGGER.info("BookInfoController:: searchByAuthor!!!!output :" + book);
				return new ResponseEntity<>(book, HttpStatus.FOUND);
			}
		}
		
		// Update Book Info
		@PutMapping("/update/{libid}")
		public ResponseEntity<BookInfo> updateBookInfo(@PathVariable long libid,BookInfo book)
		{
			LOGGER.info("BookInfoController:: updateBook!!!!input :" + libid);

			LibUser lib = userRepository.findById(libid).get();
			if (lib == null) {
				throw new NoSuchElementException("User not found With Id:" + libid);
			} else {
				book.setModifiedBy(lib);
				book.setModifiedOn(new Date());
				BookInfo bookInfo = bookInfoService.updateBook(book);

				LOGGER.info("BookInfoController:: updateBook!!!!output :" + book);
				return new ResponseEntity<>(book, HttpStatus.OK);
			}

		}
		
		// Get All Books
		@GetMapping("/search/all")
		public List<BookInfo> getAllBookInfo(){
			LOGGER.info("BookInfoController:: searchAllBooks!!!!");
			List<BookInfo> books=bookInfoService.getAllBooks();
			LOGGER.info("BookInfoController:: searchAllBooks!!!!output : ");
			return books;
		} 

		//Delete Book
		@DeleteMapping("/delete/{bookid}")
		public ResponseEntity<String> DeleteBookInfo(@PathVariable Long bookid)
		{
			LOGGER.info("BookInfoController:: DeleteBookInfo!!!! Input : "+bookid);
			bookInfoService.deleteBookbyId(bookid);
			return new ResponseEntity<String>("Deletion of Book Info Sucessful",HttpStatus.OK);
		}
}
