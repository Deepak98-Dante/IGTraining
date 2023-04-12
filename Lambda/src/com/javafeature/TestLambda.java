package com.javafeature;

import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class TestLambda{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		AddableInt a1=(a,b,c) -> { 
			return a+b+c; };
			System.out.println("Example of custom Functional Intwerface and Adding Three Numbers using Lambda");
			System.out.println("Given values are - 204,301,234");
			System.out.println(a1.add(204, 301, 234));
			
		System.out.println("Multiplication using Biconsumer:");
		System.out.println("Enter the values for biconsumer:");
		int x=s.nextInt();
		int y=s.nextInt();
		BiConsumer<Integer,Integer> bc=(a,b)->{ System.out.println(a*b); };
		bc.accept(x,y);
		
		System.out.println("Square Value using Function:");
		System.out.println("Enter the value for function:");
		int h=s.nextInt();
		Function<Integer, Integer> f=(a)->{ return a*a; };
		System.out.println(f.apply(h));


	}

}
