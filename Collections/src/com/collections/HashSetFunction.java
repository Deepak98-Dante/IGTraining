package com.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetFunction {

	void HashSetFun()
	{
		Set<String> set=new HashSet<String>();
		
		//Synchronizing Set 
		set=Collections.synchronizedSet(set);
		
		set.add("Deepak");
		set.add("Arun");
		set.add("Ravi");
		set.add("Deepak");
		set.add("Rajesh");
		
		System.out.println("Iteerating Set Values:");
		
		Iterator<String> itr=set.iterator();
		while(itr.hasNext())  
        {  
        System.out.println(itr.next());  
        }
		
		//Removing specific element from HashSet  
        set.remove("Ravi");
        
        System.out.println(set);
        
        HashSet<String> set1=new HashSet<String>();  
        set1.add("Ajay");  
        set1.add("Gaurav");  
        set.addAll(set1);  
        System.out.println("Updated vlaues: "+set);  
        //Removing all the new elements from HashSet  
        set.removeAll(set1);  
        System.out.println("After invoking removeAll() method: "+set);
        
      //Removing elements on the basis of specified condition  
        set.removeIf(str->str.contains("Rajesh"));    
        System.out.println("After invoking removeIf() method: "+set);  
        //Removing all the elements available in the set  
        set.clear();  
        System.out.println("After invoking clear() method: "+set);  
      
        
	}
	
}
