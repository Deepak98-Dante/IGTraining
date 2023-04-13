package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestCollections {

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayListFunction al=new ArrayListFunction();
		System.out.println("\t---Working with ArrayList-----");
		al.FunArraylist();
		System.out.println("\t---Working with HashSet-----");
		HashSetFunction hs=new HashSetFunction();
		hs.HashSetFun();
		System.out.println("\t---Working with HashMap-----");
		HashMapFunction hm=new HashMapFunction();
		hm.hashMapFun();
	}

}
