package com.abstraction;

public abstract class Bike implements Engine{

	public abstract void run();
	
	Bike()
	{
		System.out.println("Abstract class object Created");
	}
}
