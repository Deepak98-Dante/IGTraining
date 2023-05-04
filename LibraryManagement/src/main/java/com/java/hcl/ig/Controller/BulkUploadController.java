package com.java.hcl.ig.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lms/bulkupload")
public class BulkUploadController {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BulkUploadController.class);
	
	@GetMapping
	@Scheduled(cron = "0 10 * * Mon")//Every monday at 10AM
	public BatchStatus load() throws JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		LOGGER.info("BulkUploadController:: BatchStatus!!!! :");
		
		JobParameters jobParameters=new JobParametersBuilder().addLong("StartAt", System.currentTimeMillis()).toJobParameters();
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);

		System.out.println("JobExecution: " + jobExecution.getStatus());
		System.out.println("Batch is Running...");
		while (jobExecution.isRunning()) {
			System.out.println("...");
		}

		return jobExecution.getStatus();

		
	}
}
