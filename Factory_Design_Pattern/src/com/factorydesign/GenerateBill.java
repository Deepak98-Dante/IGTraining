package com.factorydesign;

import java.util.Scanner;

public class GenerateBill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetPlanFactory planFactory=new GetPlanFactory();
		System.out.print("Enter the name of plan for which the bill will be generated: ");  
		
		Scanner s=new Scanner(System.in);
		String planname=s.nextLine();
		
		System.out.print("Enter the number of units for bill will be calculated: ");  
		int units=s.nextInt();
		
		Plan p=planFactory.getPlan(planname);
		System.out.print("Bill amount for "+planname+" of  "+units+" units is: ");  
        p.getRate();  
        p.calculateBill(units);  
	}

}
