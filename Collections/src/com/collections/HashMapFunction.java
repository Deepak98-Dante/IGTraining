package com.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapFunction {

	void hashMapFun()
	{
		HashMap<String,Integer> hm=new HashMap<String, Integer>();    
	    System.out.println("Initial list of elements: "+hm);  
	      hm.put("CommerceDeptId",101);    
	      hm.put("PhysicalDeptId",120);    
	      hm.put("ComptuerScienceDeptId",121);   
	       
	      System.out.println("After invoking put() method ");  
	      for(Map.Entry m:hm.entrySet()){    
	       System.out.println(m.getKey()+" "+m.getValue());    
	      }  
	      
	      hm.putIfAbsent("ZoologyDeptId",213);
	      
	      System.out.println("After invoking putIfAbsent() method ");  
	      for(Map.Entry m:hm.entrySet()){    
	           System.out.println(m.getKey()+" "+m.getValue());    
	          }  
	      HashMap<String,Integer> map=new HashMap<String, Integer>();
	      map.put("ChemsiteryDeptId",142);
	      map.putAll(hm);  
	      System.out.println("After invoking putAll() method ");  
	      for(Map.Entry m:map.entrySet()){    
	           System.out.println(m.getKey()+" "+m.getValue());    
	          }  
	      
	    //key-based removal
	      map.remove("PhysicalDeptId");  
	      System.out.println("Updated list of elements: "+map);  
	}
}
