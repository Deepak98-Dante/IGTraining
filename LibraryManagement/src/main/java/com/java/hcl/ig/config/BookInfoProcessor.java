package com.java.hcl.ig.config;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.java.hcl.ig.Model.BookInfo;
import com.java.hcl.ig.Model.LibUser;

public class BookInfoProcessor implements ItemProcessor<BookInfo, BookInfo>{

	private static final Logger LOGGER = LoggerFactory.getLogger(BookInfoProcessor.class);
	
	@Override
	public BookInfo process(BookInfo item) throws Exception {
		
		LOGGER.info("BookInfoProcessor:: Book Info Processing starts......::input" + item);
		item.setCreatedBy(LibUser.builder().userId(1L).build());
		item.setActiveFlag(1);
		item.setCreatedOn(new Date());
		return item;
	}
	
	

}
