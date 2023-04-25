package com.unittest.mockito;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.verify;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito.Then;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.is;  
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;

public class ToDoBusinessMock {
	
	@Rule
	public MockitoRule mockitoRule=MockitoJUnit.rule();
	
	@Mock
	ToDoService toDoService;
	
	@InjectMocks
	ToDoBusiness toDoBusiness;
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	@Test
	public void deleteTodosusing_BDD() {

		// Given
		List<String> combinedlist = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate",
				"Use Spring MVC");

		given(toDoService.getTodos("dummy")).willReturn(combinedlist);

		// When   
		toDoBusiness.deleteTodosNotRelatedToHibernate("dummy");

		// Then   
		verify(toDoService, times(1)).deleteTodos("Use Spring MVC");
		verify(toDoService, never()).deleteTodos("Use Hibernate Java");
		verify(toDoService, never()).deleteTodos("Use Hibernate");
		System.out.println("test is working..");
	}	
	
	@Test   
    public void deleteTodosusing_BDD_usingArgumentCaptor() {  


	//Given
	List<String> combinedList=Arrays.asList("Use Hibernate Java",  
		      "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");
	given(toDoService.getTodos("dummy")).willReturn(combinedList);
	
	//When
	toDoBusiness.deleteTodosNotRelatedToHibernate("dummy");
	
	//Then
	then(toDoService).should().deleteTodos(argumentCaptor.capture());
	assertThat(argumentCaptor.getValue(),is("Use Spring MVC"));
	System.out.println("Test is working");
	
	}

}
