package com.polymorphism;

public class MethodOverride extends MethodOverloading {

	static int counter=0;
	void count()
	{
		
		super.count();
		for(int x=0;x<3;x++)
		{
			super.counter++;
			counter++;
		}
		System.out.println("Parent counter value : "+super.counter);
		System.out.println("Child counter value : "+counter);
		
		
	}
	
	void add(int a,int b)
	{
		System.out.println("Adding values by override method:");
		System.out.println(a+b);
	}
	
}
