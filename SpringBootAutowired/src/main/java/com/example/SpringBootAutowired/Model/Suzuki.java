package com.example.SpringBootAutowired.Model;

import org.springframework.stereotype.Component;

@Component
public class Suzuki implements Company {

	@Override
	public void name() {
		System.out.println("Maruti Suzuki");
		
	}

}
