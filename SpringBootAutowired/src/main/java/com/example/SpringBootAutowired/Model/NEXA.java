package com.example.SpringBootAutowired.Model;

import org.springframework.stereotype.Component;

@Component
public class NEXA implements Budget {

	@Override
	public void BudgetType() {
		System.out.println("NEXA TYPE");
		
	}
	
}
