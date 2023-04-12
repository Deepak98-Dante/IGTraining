package com.designpattern;

public class Singleton {
	
	private static Singleton single=null;
	
	public String s;
	
	
		
	private Singleton() {
		s="Hello I am a string part of Singleton class";
	}



	public static synchronized Singleton getInstance()
	{
		if(single==null)
		{
			single=new Singleton();
		}
		return single;
	}

}
