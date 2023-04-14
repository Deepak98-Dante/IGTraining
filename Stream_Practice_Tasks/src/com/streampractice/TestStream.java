package com.streampractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestStream {

	List<Integer> list = Arrays.asList(9, 2, 4, 15, 7, 6, 12, 10, 8, 10, 1, 12);
	String str = "JAVA8 STREAM PRACTICE";
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

	/*
	 * public void findFirstNonRepated() {
	 * System.out.println("Find First non repeated character with a in given List:"
	 * ); System.out.println("Given String:"+str);
	 * System.out.print("First Non Repeated Character in given String : ");
	 * 
	 * System.out.print( names.stream().filter((x->x.charAt(0))
	 * 
	 * 
	 * }
	 */

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
	}
}
