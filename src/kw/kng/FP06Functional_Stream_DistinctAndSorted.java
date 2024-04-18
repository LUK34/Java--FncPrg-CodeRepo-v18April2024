package kw.kng;

import java.util.Comparator;
import java.util.List;

public class FP06Functional_Stream_DistinctAndSorted 
{
	
	
	public static void main(String[] args)
	{
		List<Integer> numero=List.of(12,9,3,4,5,6,12,15);
		List<String> coursero= List.of("Spring","Spring Boot","API","Microservices",
				"AWS","PCF","Azure","Docker","Kubernetes");
		print_Stream_Distinct(numero);
		print_Stream_Sorted_ASC(numero);
		print_Stream_Sorted_DESC(numero);
		print_Stream_Distinct_Sorted_ASC(numero);
		print_Stream_Distinct_Sorted_DESC(numero);
		
		print_Stream_String_Sorted_ASC(coursero);
		print_Stream_String_Sorted_DESC(coursero);
		print_Stream_String_Length(coursero);
		
		print_Stream_String_Length_ASC_OR_DESC(coursero,false); //To get the List of Strings in ASC order of Length
		print_Stream_String_Length_ASC_OR_DESC(coursero,true); //To get the List of Strings in DESC order of Length
	}
	private static void print_Stream_Distinct(List<Integer> numbers)
	{
		System.out.println("The Distinct numbers: ");
				numbers.stream()
								 .distinct()
								 .forEach(System.out::println);
	}
	
	private static void print_Stream_Sorted_ASC(List<Integer> numbers)
	{
		System.out.println("The Sorted numbers in ASC Order: ");
				numbers.stream()
								.sorted(Comparator.naturalOrder())
								 .forEach(System.out::println);
	}
	
	
	private static void print_Stream_Sorted_DESC(List<Integer> numbers)
	{
		System.out.println("The Sorted numbers in DESC Order: ");
				numbers.stream()
							   .sorted(Comparator.reverseOrder())
							   .forEach(System.out::println);
	}
	
	private static void print_Stream_Distinct_Sorted_ASC(List<Integer> numbers)
	{
		System.out.println("The Sort DISTINCT numbers in ASC Order: ");
				numbers.stream()
				 				.distinct()
								.sorted(Comparator.naturalOrder())
								 .forEach(System.out::println);
	}
	
	
	private static void print_Stream_Distinct_Sorted_DESC(List<Integer> numbers)
	{
		System.out.println("The Sort DISTINCT numbers in DESC Order: ");
				numbers.stream()
				 				.distinct()
							   .sorted(Comparator.reverseOrder())
							   .forEach(System.out::println);
	}
	
	
	private static void print_Stream_String_Sorted_ASC(List<String> coursero)
	{
		System.out.println("The Sorted List of Strings in DESC Order: ");
		coursero.stream()
							   .sorted(Comparator.reverseOrder())
							   .forEach(System.out::println);
	}
	
	private static void print_Stream_String_Sorted_DESC(List<String> coursero)
	{
		System.out.println("The Sort List of Strings in ASC Order: ");
		coursero.stream()
						.sorted(Comparator.naturalOrder())
					    .forEach(System.out::println);
	}
	
	private static void print_Stream_String_Length(List<String> coursero)
	{
		System.out.println("The Sort List of Strings length wise Order: ");
		coursero.stream()
						.sorted(Comparator.comparing( str -> str.length() ))
						.map(s->"Name: "+" "+s+" "+" "+"Length: " +s.length())
					    .forEach(System.out::println);
	}
	
	private static void print_Stream_String_Length_ASC_OR_DESC(List<String> coursero, boolean descending) 
	{
	    System.out.println("The Sorted List of Strings length-wise ASC(Flag Value =False) / DESC (Flag Value= True) Order:");
	  
	    System.out.println("---------------------------------------" );
	    System.out.println("FLAG Value: " + descending );
	    System.out.println("---------------------------------------" );
	    
	    Comparator<String> comparator = Comparator.comparing(String::length);
	    if (descending) //If true then this line will be executed.
	    {
	        comparator = comparator.reversed();
	    }

	    coursero.stream()
	    				.sorted(comparator)
	    				.map(s -> "Name: " + s + " Length: " + s.length())
	    				.forEach(System.out::println);
	}
	
	
	
	
	
}
