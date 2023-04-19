package com.example.SpringBootAutowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.SpringBootAutowired.controller.CarController;



@SpringBootApplication
public class SpringBootAutowiredApplication {

	public static void main(String[] args) {
		 var context= SpringApplication.run(SpringBootAutowiredApplication.class, args);
		
		CarController carCon=(CarController) context.getBean("carController");
		carCon.CarType();
	}

}
