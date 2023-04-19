package com.example.SpringBatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
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

import com.example.SpringBatch.entity.Customer;
import com.example.SpringBatch.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Configuration
//@EnableBatchProcessing
public class SpringBatchConfig {
	
	/*
	 * @Autowired private StepBuilder stepBuilde;
	 * 
	 * @Autowired private JobBuilder jobBuilder;
	 */
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Bean
	public FlatFileItemReader<Customer> reader()
	{
		
		FlatFileItemReader<Customer> itemReader=new FlatFileItemReader<Customer>();
		itemReader.setResource(new FileSystemResource("src/main/resources/CUSTOMER_DATA.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		
		return itemReader;
	}
	
	@Bean
	public LineMapper<Customer> lineMapper() {
		
		DefaultLineMapper<Customer> lineMapper=new DefaultLineMapper<Customer>();
		DelimitedLineTokenizer delimitedLineTokenizer=new  DelimitedLineTokenizer();
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setStrict(false);
		delimitedLineTokenizer.setNames("CUSTOMERID","COUNTRY","FULL_NAME");
		
		BeanWrapperFieldSetMapper<Customer> fieldSetMapper=new BeanWrapperFieldSetMapper<Customer>();
		fieldSetMapper.setTargetType(Customer.class);
		
		lineMapper.setLineTokenizer(delimitedLineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		return lineMapper;
		
	}
	
	@Bean
	public CustomerProcessor processor()
	{
		return new CustomerProcessor();
	}
	
	@Bean
	public  RepositoryItemWriter<Customer> writer()
	{
		RepositoryItemWriter<Customer> writer=new RepositoryItemWriter<Customer>();
		writer.setRepository(customerRepository);
		writer.setMethodName("save");
		return writer;
	}
	
	@Bean
	public Step step1() {
		
		return new  StepBuilder("csv-step", jobRepository).<Customer,Customer>chunk(10,transactionManager)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
		
		
		
	}
	
	
	@Bean
	public Job runJob()
	{
		return new JobBuilder("importCustomer",jobRepository)
				.flow(step1()).end().build();
		
	}

}
