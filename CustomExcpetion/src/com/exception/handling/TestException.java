package com.exception.handling;

import java.util.Scanner;

public class TestException {
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("\t Age Validation For Voting");
		System.out.println("Enter your Age");
		int age=s.nextInt();
		try
		{
			if(age<18)
			{
				throw new AgeValidationException("Under Age for Voting");
			}
			else
			{
				System.out.println("Eligiable for Vote");
			}	
		}
		
		catch (AgeValidationException e)
		{
			System.out.println(e.getMessage());
		}
		catch ( Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
