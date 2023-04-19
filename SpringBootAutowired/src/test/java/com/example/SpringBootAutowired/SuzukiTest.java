package com.example.SpringBootAutowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.SpringBootAutowired.Model.Suzuki;

public class SuzukiTest {

	private Suzuki s;
	
	@BeforeEach
	public void setup() {
	s=new Suzuki();}
	
	@Test
	public void nameTest()
	{
		assertEquals("Maruti Suzuki", s.name());
	}
}
