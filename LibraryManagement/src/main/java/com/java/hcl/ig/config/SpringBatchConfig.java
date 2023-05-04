package com.java.hcl.ig.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;


import com.java.hcl.ig.Model.BookInfo;
import com.java.hcl.ig.repository.BookInfoRepository;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	
	@Autowired
	private BookInfoRepository bookInfoRepository;
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBatchConfig.class);
	
	
	@Bean
	public FlatFileItemReader<BookInfo> reader(){
		
		LOGGER.info("SpringBatchConfig:: itemReader !!!! start :");
		
		FlatFileItemReader<BookInfo> itemReader=new FlatFileItemReader<BookInfo>();
		itemReader.setResource(new FileSystemResource("src/main/resources/Books.csv"));
		itemReader.setName("CSV-Reader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		
		LOGGER.info("SpringBatchConfig:: itemReader !!!! end :");
		
		return itemReader;
	}
	
	@Bean
	public LineMapper<BookInfo> lineMapper()
	{
		LOGGER.info("SpringBatchConfig:: lineMapper !!!! start :");
		DefaultLineMapper<BookInfo> defaultLineMapper=new DefaultLineMapper<BookInfo>();
		DelimitedLineTokenizer delimitedLineTokenizer=new DelimitedLineTokenizer();
		
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setStrict(false);
		delimitedLineTokenizer.setNames("bookId","bookName","author","price","bookPages","noOfCopies","bookPublication");
		
		BeanWrapperFieldSetMapper<BookInfo> fieldSetMapper=new BeanWrapperFieldSetMapper<BookInfo>();
		fieldSetMapper.setTargetType(BookInfo.class);
		
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		
		LOGGER.info("SpringBatchConfig:: lineMapper !!!! end :");

		return defaultLineMapper;
		
	}
	
	@Bean
	public RepositoryItemWriter<BookInfo> writer()
	{
		RepositoryItemWriter<BookInfo> itemWriter=new RepositoryItemWriter<BookInfo>();
		itemWriter.setRepository(bookInfoRepository);
		itemWriter.setMethodName("save");
		return itemWriter;
	}
	
	@Bean
	public BookInfoProcessor processor() {
		return new BookInfoProcessor();
	}
	
	@Bean
	public Step step1() {
		
		return new  StepBuilder("ETL-CSV-File-Upload", jobRepository).<BookInfo,BookInfo>chunk(100,transactionManager)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
		
	}
	
	@Bean
	public Job runJob()
	{
		return new JobBuilder("ImportBookInfo",jobRepository)
				.flow(step1()).end().build();
		
	}
}
