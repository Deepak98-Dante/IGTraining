package com.example.SpringBootAutowired.Model;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine{
	
	@Override
	public void TypeEngine() {
		System.out.println("Petrol Engine");
		
	}

}
