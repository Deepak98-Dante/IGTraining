package com.streampractice;

import java.nio.file.DirectoryStream.Filter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestStream {

	List<Integer> list = Arrays.asList(9, 2, 4, 15, 7, 6, 12, 10, 8, 10, 1, 12);
	String str = "JAVA8 STREAM PRACTICEJ";
	List<String> names = Arrays.asList("Arun", "Spring", "Stream", "Java", "apple", "anil");

	public void FindEvenNumber() {

		System.out.println("Find Even Number given List:");
		System.out.println("Givenn list values:" + list);
		System.out.print("Even Numbers:");
		list.stream().filter(x -> x % 2 == 0).forEach((x) -> {
			System.out.print(x + " ");
		});
	}

	public void FindStartingwith1() {

		System.out.println("Find  Number Starting with 1 given List:");
		List<Integer> list = Arrays.asList(10, 25, 14, 5, 750, 12, 1245, 218, 110, 1);
		System.out.println("Givenn list values:" + list);
		System.out.print("Starting With Number 1:");
		list.stream().map(x -> x.toString()).filter(x -> x.startsWith("1")).forEach(z -> {
			System.out.print(z + " ");
		});
	}

	public void FindDuplicate() {
		System.out.println("Find Duplicate Number given List:");
		System.out.println("Givenn list values:" + list);
		System.out.print("Duplicate Numbers in the List: ");
		Set<Integer> numbers = new HashSet<Integer>();
		System.out.print(list.stream().filter(x -> numbers.add(x) == false).collect(Collectors.toSet()));

	}

	public void FindFirstElment() {

		System.out.println("Find First Number given List:");
		System.out.println("Givenn list values:" + list);
		System.out.print("First Number of List: ");
		System.out.print(list.stream().findFirst().get());

	}

	public void Findcount() {

		System.out.println("Find Number of Elements in given List:");
		System.out.println("Givenn list values:" + list);
		System.out.print("Number of elements(Count) in List: ");
		System.out.print(list.stream().count());

	}

	public void FindMax() {

		System.out.println("Find Maximum value in given List:");
		System.out.println("Givenn list values:" + list);
		System.out.print("Maximum Value in List: ");
		System.out.print(list.stream().mapToInt(x -> x).max().getAsInt());

	}

	public void findStringStartwith() {
		System.out.println("Find Number of String starts with a in given List:");
		System.out.println("Givenn list of Strings:" + names);
		System.out.print("Number of String starts with a : ");
		System.out.print(names.stream().map(x -> x.toLowerCase()).filter(s -> s.startsWith("a")).count());

	}
	
	//17-Apr
	
	public void CountEmptyString()
	{
		System.out.println("Find Number of Empty String  in given List:");
		List<String> arrStr = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println("Givenn list of Strings:" + arrStr);
        long count = arrStr.stream().filter(x -> x.isEmpty()).count();
        System.out.println("Empty Count: " + count);
		
	}
	
	public void RemoveEmptyString()
	{
		System.out.println("Remove Empty String  in given List:");
		List<String> arrStr = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println("Givenn list of Strings:" + arrStr);
        arrStr = arrStr.stream().filter(x -> x.isEmpty()== false).collect(Collectors.toList());
        System.out.println("After Removing Empty String: " + arrStr);
		
	}
	
	public void SortingInteger()
	{
		System.out.println("Sorting Number given List:");
		System.out.println("Givenn list values:" + list);
		System.out.println("Ascending order of Given List : ");
		list.stream().sorted().forEach(z->System.out.print(z+" "));
		System.out.println("\nDescending order of Given List : ");
		list.stream().sorted(Collections.reverseOrder()).forEach(z->System.out.print(z+" "));
	}
	
	public  void CountLengthMoreThree()
	{
		System.out.println("Find Number of Strings lenght more than 3  in given List:");
		List<String> arrStr = Arrays.asList("java","abc", "", "bc", "efg", "abcd","", "jkl","apple");
		System.out.println("Givenn list of Strings:" + arrStr);
        long count = arrStr.stream().filter(x -> x.length()>3).count();
        System.out.println("Count of Strings Length more than Three: " + count);
	}
	
	public void CreateListMoreTwoChar()
	{
		System.out.println("Create a List  Strings lenght more than 2  in given List:");
		List<String> arrStr = Arrays.asList("java","abc", "", "bc", "efg", "abcd","", "jkl","apple");
		System.out.println("Givenn list of Strings:" + arrStr);
        List<String> Strlist = arrStr.stream().filter(x -> x.length()>2).collect(Collectors.toList());
        System.out.println("Strings Length more than Two: " + Strlist);
	}
	public void JoinComma()
	{
		System.out.println("String to UpperCase Join with Comma");
		List<String> arrStr = Arrays.asList("java","abc", "bc", "efg", "abcd", "jkl","apple");
		System.out.println("Givenn list of Strings:" + arrStr);
        String str = arrStr.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println("Strings Length more than Two: " + str);
		
	}
	
	public void FindSquareDisinct()
	{
		System.out.println("Find the Square for Distinct Numbers from List");
		System.out.println("Givenn list values:" + list);
		System.out.print("Distinct Squares : ");
		List<Integer> Square= list.stream().distinct().map(x->x*x).collect(Collectors.toList());
		System.out.print(Square);
	}
	
	public void CMMSA()
	{
		System.out.println("Find Count,Min,Max,Sum and the average for numbers");
		System.out.println("Givenn list values:" + list);
		long count=list.stream().count();
		int min=list.stream().mapToInt(x->x).min().orElseThrow();
		int max=list.stream().mapToInt(x->x).max().orElseThrow();
		//Sum using Reduce 
		//int sum=list.stream().reduce(0,(a,b) -> a+b);
		int sum=list.stream().mapToInt(Integer::intValue).sum();
		Double avg=list.stream().mapToInt(Integer::intValue).average().orElseThrow();
		System.out.println("Count : "+count+"\nMin Value : "+min+"\nMax Value : "+max);
		System.out.println("Sum : "+sum+"\nAverage : "+avg);
		
	}
	
	

	
	  public void findFirstNonRepeated() {
		  
	  System.out.println("Find First non repeated character with a  given string:"); 
	  System.out.println("Given String:"+str);
	  System.out.print("First Non Repeated Character in given String : ");
	  
	  System.out.print(str.chars().mapToObj(c->Character.valueOf((char)c))
			  .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
			  .entrySet().stream()
			  .filter(entry->entry.getValue()==1L)
			  .map(entry->entry.getKey())
			  .findFirst().get());
	 }
	  
	  public void findFirstRepeated()
	  {
		  System.out.println("Find First repeated character with a in given String:"); 
		  System.out.println("Given String:"+str);
		  System.out.print("First Repeated Character in given String : ");
		  System.out.print(str.chars().mapToObj(c->Character.valueOf((char)c))
				  .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
				  .entrySet().stream()
				  .filter(entry->entry.getValue() > 1L)
				  .map(entry->entry.getKey())
				  .findFirst().get());
		  
	  }
	 

	public static void main(String args[]) {
		TestStream s = new TestStream();
		s.FindEvenNumber();
		System.out.print("\n\n");
		s.FindStartingwith1();
		System.out.print("\n\n");
		s.FindDuplicate();
		System.out.print("\n\n");
		s.FindFirstElment();
		System.out.print("\n\n");
		s.Findcount();
		System.out.print("\n\n");
		s.FindMax();
		System.out.print("\n\n");
		s.findStringStartwith();
		System.out.print("\n\n");
		s.CountEmptyString();
		System.out.print("\n\n");
		s.SortingInteger();
		System.out.print("\n\n");
		s.CountLengthMoreThree();
		System.out.print("\n\n");
		s.CreateListMoreTwoChar();
		System.out.print("\n\n");
		s.RemoveEmptyString();
		System.out.print("\n\n");
		s.JoinComma();
		System.out.print("\n\n");
		s.FindSquareDisinct();
		System.out.print("\n\n");
		s.CMMSA();
		System.out.print("\n\n");
		s.findFirstNonRepeated();
		System.out.print("\n\n");
		s.findFirstRepeated();
	}
}
