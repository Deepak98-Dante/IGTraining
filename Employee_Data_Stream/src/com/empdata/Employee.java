package com.empdata;

public class Employee {

	private int age,yearOfJoining;
	private long salary;
	private String  name,department,gender;
	
	public Employee( String name,int age, int yearOfJoining, long salary, String department, String gender) {
		super();
		this.age = age;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
		this.name = name;
		this.department = department;
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
