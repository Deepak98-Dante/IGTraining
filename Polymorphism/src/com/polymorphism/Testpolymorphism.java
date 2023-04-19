package com.polymorphism;

public class Testpolymorphism {

	public static void main(String[] args) {
		
		MethodOverloading mo=new MethodOverloading();
		//Method Overloading
		System.out.println("Adding values:");
		mo.add(10,20);
		mo.add(22.3,24.5);
		mo.add(120,130, 440);
		mo.count();
		
		MethodOverride md=new MethodOverride();
		md.add(10, 20);
		md.count();
		
		//Override method call if have parent reference
		MethodOverloading mo1=new MethodOverride();
		md.add(22, 24);
		md.add(44, 55, 11);
	}

}
