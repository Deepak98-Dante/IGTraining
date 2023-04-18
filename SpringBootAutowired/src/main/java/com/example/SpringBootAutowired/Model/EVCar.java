package com.example.SpringBootAutowired.Model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class EVCar implements Car {

	@Override
	public void Drive() {
		System.out.println("Driving Electric Car");
		
	}

}
