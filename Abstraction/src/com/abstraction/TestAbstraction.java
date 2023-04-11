package com.abstraction;

public class TestAbstraction  {

 

	public static void main(String[] args) {
		Bike b=new Honda();
		b.engineType();
		b.run();
		
		Bike b1=new Hero();
		b1.engineType();
		b1.run();
	}
}