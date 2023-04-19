package com.empdata;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestEmpStream {

	List<Employee> list=new ArrayList<Employee>();
	
	public List<String> genderType()
	{
		List<String> Gender=list.stream().map(x->x.getGender()).distinct().collect(Collectors.toList());
		return Gender;
	}
	
	public void countofgenders()
	{
		System.out.println("Count of Male and Female Employees in the Organizarion ");
		long Malecount= list.stream().map(emp -> emp.getGender()).filter(emp -> emp.equals("MALE")).count();
		long Femalecount= list.stream().map(emp -> emp.getGender()).filter(emp -> emp.equals("FEMALE")).count();
		System.out.println("Male Count : "+Malecount);
		System.out.println("Female Count : "+Femalecount);
	}
	public List<String> printAllDept()
	{
		
		List<String> dept=list.stream().map(emp->emp.getDepartment()).distinct().collect(Collectors.toList());
		return dept; 
	}
	
	public void avgAgeGenderwise()
	{
		System.out.println("Average of Age of  Employee Gender wise in the organization");
		int avgMale =(int) list.stream().filter(emp->(emp.getGender()).equals("MALE")).mapToInt(e->e.getAge()).average().orElseThrow();
		int avgFeMale =(int) list.stream().filter(emp->(emp.getGender()).equals("FEMALE")).mapToInt(e->e.getAge()).average().orElseThrow();
		System.out.println("Male Average Age : "+avgMale);
		System.out.println("Female Average Age : "+avgFeMale);
	}
	
	public void highestPaidEmployee()
	{
		System.out.println("Highest Paid Employee in the Organization");
		long high=list.stream().mapToLong(x->x.getSalary()).max().getAsLong();
		list.stream().filter(emp->emp.getSalary()==high).forEach(emp ->
		System.out.println("Name : "+emp.getName()+"\nAge : "+emp.getAge()+"\nSalary : "+emp.getSalary()
		+"\nGender : "+emp.getGender()+"\nDeparrtment : "+emp.getDepartment()+"\nYearOfJoining : "+emp.getYearOfJoining()));
	}
	
	public void empJoinedAfter()
	{
		System.out.println("Names of Employees Joined After 2015 in the Organization");
		list.stream().filter(emp->(emp.getYearOfJoining())>2015).map(emp->emp.getName()).forEach(System.out::println);
		
	}
	
	public void noEmpEachDept()
	{
		System.out.println("Number of Employees in each Department in the Organization");
		List<String> dept=printAllDept();
		for(String s:dept)
		{
			System.out.println(s+" : "+(list.stream().filter(emp->(emp.getDepartment()).equals(s)).count()));
		}
	}
	
	public void avgSalaryEachDept()
	{
		System.out.println("Average Salary of Employees in each Department in the Organization");
		List<String> dept=printAllDept();
		for(String s:dept)
		{
			System.out.println(s+" : "+(list.stream().filter(emp->(emp.getDepartment()).equals(s)).mapToLong(e->e.getSalary()).average().orElseThrow()));
		}
	}
	
	Comparator<Employee> ageComparator = new Comparator<Employee>() {
		  @Override
		  public int compare(Employee i1,Employee i2) {
		     if((i2.getAge())<(i1.getAge()))
		    	return 1;	 
		     else
		    	 return -1;
		  }
		}; 
	public void youngMaleProd()
	{
		
		System.out.println("Young Male Employee in product Department in the Organization");
		Employee e=list.stream().filter(emp->(emp.getGender()).equals("MALE")).sorted(ageComparator).findFirst().get();
		System.out.println("Name : "+e.getName()+"\nAge : "+e.getAge()+"\nSalary : "+e.getSalary()+"\nDepartment : "
				+e.getDepartment()+"\nGender : "+e.getGender()+"\nYear of Joining : "+e.getYearOfJoining());
	}
	
	public void mostWorkingExpEmp()
	{
		
		System.out.println("Most Working Experience Employee in the Organization");
		int mostExp=list.stream().mapToInt(emp->emp.getYearOfJoining()).min().orElseThrow();
		list.stream().filter(emp->(emp.getYearOfJoining())==mostExp).forEach(e ->
		System.out.println("Name : "+e.getName()+"\nAge : "+e.getAge()+"\nSalary : "+e.getSalary()+"\nDepartment : "
				+e.getDepartment()+"\nGender : "+e.getGender()+"\nYear of Joining : "+e.getYearOfJoining()));
	}
	
	public void countsalesmarketGenderwise()
	{
		
		System.out.println("Gender wise Employee in sales and Marketing Department in the Organization");
		List<String> dept=printAllDept();
		for(String s:dept)
		{
		if(s.equals("PRODUCT DEV"))
			continue ;
		System.out.println(s);
		long malecount = list.stream().filter(emp->(emp.getDepartment()).equals(s)&&(emp.getGender()).equals("MALE")).count();
		long femalecount = list.stream().filter(emp->(emp.getDepartment()).equals(s)&&(emp.getGender()).equals("FEMALE")).count();
		System.out.println("Male : "+malecount);
		System.out.println("Female : "+femalecount);
		}
	}
	
	public void avgSalaryGenderwise()
	{
		System.out.println("Average Salary of Employees Gender Wise in the Organization");
		List<String> gender=genderType();
		for(String s:gender)
		{
			Double Average=list.stream().filter(e->(e.getGender()).equals(s)).mapToLong(x->x.getSalary()).average().orElseThrow();
			System.out.println(s+"Average Salary : "+Average);
		}
	}
	
	public void nameEachDept()
	{
		System.out.println("Name of Employees Department wise in the Organization");
		List<String> dept=printAllDept();
		for(String s:dept)
		{
			System.out.println("\n"+s+":");
			list.stream().filter(emp->(emp.getDepartment()).equals(s)).forEach(e->System.out.println(e.getName()));
		}
	}
	
	public void avgTotalSalrayOrg()
	{
		System.out.println("Total Salary and Average Salary of the Organization");
		long Total=list.stream().mapToLong(x->x.getSalary()).sum();
		Double Average=list.stream().mapToDouble(x->x.getSalary()).average().orElseThrow();
		System.out.println("Total Salary : "+Total+"\nAverage Salary : "+Average);
	}
	public void separateEmployeebyAge()
	{
		System.out.println("Separating Employee By Age in the Organization");
		List<Employee> JuniorEmp=list.stream().filter(e->(e.getAge())<=25).collect(Collectors.toList());
		List<Employee> SeniorEmp=list.stream().filter(e->(e.getAge())>25).collect(Collectors.toList());
		System.out.println("Empolyees are younger or equal to 25");
		for(Employee e:JuniorEmp) {
			System.out.println(e.getName());
			//System.out.println("Name : "+e.getName()+"\nAge : "+e.getAge()+"\nSalary : "+e.getSalary()+"\nDepartment : "
				//	+e.getDepartment()+"\nGender : "+e.getGender()+"\nYear of Joining : "+e.getYearOfJoining()));
		}
		System.out.println("Empolyees are older than 25");
		for(Employee e:SeniorEmp) {
			//System.out.println("Name : "+e.getName()+"\nAge : "+e.getAge()+"\nSalary : "+e.getSalary()+"\nDepartment : "
				//	+e.getDepartment()+"\nGender : "+e.getGender()+"\nYear of Joining : "+e.getYearOfJoining()));
			System.out.println(e.getName());
		}
	}
	
	public void oldestEmployee()
	{
		System.out.println("Oldest Employee in the Organization");
		Long max=list.stream().mapToLong(e->e.getAge()).max().orElseThrow();
		List<Employee> emp=list.stream().filter(x->(x.getAge()) == max).collect(Collectors.toList());
		for(Employee e:emp) {
			System.out.println("Name : "+e.getName()+"\nAge : "+e.getAge()+"\nSalary : "+e.getSalary()+"\nDepartment : "
						+e.getDepartment()+"\nGender : "+e.getGender()+"\nYear of Joining : "+e.getYearOfJoining());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestEmpStream s=new TestEmpStream();
		
		s.list.add(new Employee("Deepak",25,2018,50000,"PRODUCT DEV","MALE"));
		s.list.add(new Employee("Arun",30,2015,100000,"PRODUCT DEV","MALE"));
		s.list.add(new Employee("Najima",25,2018,60000,"PRODUCT DEV","FEMALE"));
		s.list.add(new Employee("Deepika",22,2018,45000,"SALES","FEMALE"));
		s.list.add(new Employee("Rajesh",28,2015,70000,"MARKETING","MALE"));
		s.list.add(new Employee("Sudha",26,2020,70000,"SALES","FEMALE"));
		s.list.add(new Employee("Kiran",32,2012,185000,"SALES","MALE"));
		s.list.add(new Employee("Nithya",26,2015,65000,"MARKETING","FEMALE"));
		s.list.add(new Employee("Ramya",26,2015,65000,"MARKETING","FEMALE"));
		System.out.print("\n\n");
		s.countofgenders();
		System.out.print("\n\n");
		s.avgAgeGenderwise();
		System.out.print("\n\n");
		System.out.println("Print All Departments in the Organizarion ");
		System.out.println(s.printAllDept().toString());
		System.out.print("\n\n");
		s.highestPaidEmployee();
		System.out.print("\n\n");
		s.empJoinedAfter();
		System.out.print("\n\n");
		s.noEmpEachDept();
		System.out.print("\n\n");
		s.avgSalaryEachDept();
		System.out.print("\n\n");
		s.youngMaleProd();
		System.out.print("\n\n");
		s.mostWorkingExpEmp();
		System.out.print("\n\n");
		s.countsalesmarketGenderwise();
		System.out.print("\n\n");
		s.avgSalaryGenderwise();
		System.out.print("\n\n");
		s.nameEachDept();
		System.out.print("\n\n");
		s.avgTotalSalrayOrg();
		System.out.print("\n\n");
		s.separateEmployeebyAge();
		System.out.print("\n\n");
		s.oldestEmployee();
	}

}
