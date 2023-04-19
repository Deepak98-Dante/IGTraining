package com.example.SpringBootAutowired.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.SpringBootAutowired.Model.Budget;
import com.example.SpringBootAutowired.Model.BudgetQualifier;
import com.example.SpringBootAutowired.Model.Car;
import com.example.SpringBootAutowired.Model.Company;

import com.example.SpringBootAutowired.Model.Engine;


@Controller
public class CarController {
	
	@Autowired
	private Car car;//by Type with Primary of EV Car
	@Autowired
	private Engine petrolEngine;//byname
	
	private Company company;
	private Budget budget;
	
	//Constructor Aurowired with Custom Qualifier
	@Autowired
	public CarController(@BudgetQualifier("NEXA")Budget budget) {
		
		this.budget = budget;
	}
	 


	/*Setter Autowired*/
	 @Autowired
	 @Qualifier("suzuki")
	 public void setCompany(Company company) {
			this.company = company;
		} 
	 
	

	



	public void CarType()
	{	
		company.name();
		budget.BudgetType();
		petrolEngine.TypeEngine();
		car.Drive();		
	}

	
		
	
				
	
	
}
