package com.example.SpringBootAutowired.Model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SedanCar implements Car{

	@Override
	public void Drive() {
		System.out.println("Driving Sedan Car");
		
	}

}
