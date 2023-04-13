package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListFunction {

	void FunArraylist()
	{
		List<String> list=new ArrayList<String>();
		
		System.out.println("Is ArrayList Empty: "+list.isEmpty());
		list.add("Mango");
		list.add("Apple");
		list.add("Banana");  
        list.add("Apple");  
        list.add("Strawberry");  
        list.add("Pineapple");
        System.out.println("After insertion");
        System.out.println("Is ArrayList Empty: "+list.isEmpty());
        
        System.out.println("Inserted values :");
     // Synchronizing ArrayList 
        list = Collections.synchronizedList(list);
        
        synchronized (list) {  
            Iterator<String> itr = list.iterator();  
            while (itr.hasNext()) {  
                System.out.println(itr.next()); 		
            }
        }
        
        System.out.println("The size of the array is: " + list.size());
        
        Collections.sort(list);
        System.out.println("Sorted ArrayList Values:"+list);
	}  
}
