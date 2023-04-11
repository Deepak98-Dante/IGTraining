package com.polymorphism;

public class MethodOverloading {

	static int counter=10;
	void count()
	{
		for(int f=0;f<3;f++)
		{
			counter++;
		}
		System.out.println("Counter Value : "+counter);
	}
	
	
	void add (int a,int b)
	{
		System.out.println("Sum of "+a+"+"+b+": "+(a+b));
	}
	
	//overload can't be done by chnaging return type
	//int add(int a,int b){ return a+b;	}
	void add (int a,int b,int c)
	{
		System.out.println("Sum of "+a+"+"+b+"+"+c+": "+(a+b+c));
	}
	
	void add (double x,double y)
	{
		System.out.println("Sum of "+x+"+"+y+": "+(x+y));
	}
}
