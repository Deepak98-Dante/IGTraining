package com.IG.Hcl.Junit.Mcokito.SpringbootMockitoTest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {

	@Id 
	private Long id;
	private String name;
	private String department;
	
	public Employee(Long id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
