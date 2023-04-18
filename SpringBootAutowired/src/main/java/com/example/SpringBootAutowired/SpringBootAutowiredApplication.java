package com.example.SpringBootAutowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.SpringBootAutowired.controller.CarController;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class SpringBootAutowiredApplication {

	public static void main(String[] args) {
		 var context= SpringApplication.run(SpringBootAutowiredApplication.class, args);
		
		CarController carCon=(CarController) context.getBean("carController");
		carCon.CarType();
	}

}
