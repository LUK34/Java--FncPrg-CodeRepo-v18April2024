package kw.kng;

import java.util.List;

public class FP01Functional_Lambda 
{
	
	public static void main(String[] args)
	{
		List<Integer> numero=List.of(12,9,3,4,5,6);
		printAllNumbersInList(numero);
		printEvenNumbersInList(numero);
		printOddNumbersInList(numero);	
	}
	
	private static void printNumbersViaMethodReferenceApproach(int number)
	{
		System.out.println(number);
	}
	
	// Retrieving ALL numbers from the LIST
	private static void printAllNumbersInList(List<Integer> numbers)
	{
		System.out.println("Functional Programming");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the numbers -> Method Reference Approach");
		numbers.stream()
					   .forEach(FP01Functional_Lambda :: printNumbersViaMethodReferenceApproach);
	}
	
	// Retrieving EVEN numbers from the LIST
	private static void printEvenNumbersInList(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the EVEN numbers -> Lambda expression ");
		numbers.stream()
						.filter( number -> number%2 ==0)
					   .forEach(System.out::println);
	}
	
	
	// Retrieving ODD numbers from the LIST
	private static void printOddNumbersInList(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the ODD numbers  -> Lambda expression ");
		numbers.stream()
						.filter( number -> number%2 !=0)
						.forEach(System.out::println);
	}

}
