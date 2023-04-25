package com.unittest.mockito;

import java.util.ArrayList;
import java.util.List;

public class ToDoBusiness {

	public ToDoService toDoService;
	
	public ToDoBusiness(ToDoService toDoService)
	{
		this.toDoService=toDoService;
	}
	 public List<String> getTodosforSpring(String user) {  
         
	        List<String> retrievedtodos = new ArrayList<String>();  
	        List<String> todos = toDoService.getTodos(user);  
	          
	        for(String todo :todos) {  
	            if(todo.contains("Spring")) {  
	                retrievedtodos.add(todo);  
	            }  
	        }  
	        return retrievedtodos;  
	        }  
	 
	 public void deleteTodosNotRelatedToHibernate(String user) {  
         
	        List<String> Combinedlist = toDoService.getTodos(user);  
	          
	        for(String todos:Combinedlist) {  
	            if(!todos.contains("Hibernate"))   
	            {  
	            	toDoService.deleteTodos(todos);  
	            }  
	        }  
	    }  
}
