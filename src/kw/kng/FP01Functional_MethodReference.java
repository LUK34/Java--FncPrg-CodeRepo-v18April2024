package kw.kng;

import java.util.List;

public class FP01Functional_MethodReference 
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

	
	private static boolean printEvenNumbersViaMethodReferenceApproach(int number)
	{
		return number%2 ==0; 
	}
	
	
	private static boolean printOddNumbersViaMethodReferenceApproach(int number)
	{
		return number%2 !=0;
	}
	
	
	// Retrieving ALL numbers from the LIST
	private static void printAllNumbersInList(List<Integer> numbers)
	{
		System.out.println("Functional Programming -> Method Reference Approach");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the numbers ");
		numbers.stream()
					   .forEach(FP01Functional_MethodReference :: printNumbersViaMethodReferenceApproach);
	}
	
	// Retrieving EVEN numbers from the LIST
	private static void printEvenNumbersInList(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the EVEN numbers ->  Method Reference Approach ");
		numbers.stream()
					   .filter(FP01Functional_MethodReference :: printEvenNumbersViaMethodReferenceApproach)
					   .forEach(System.out::println);
	}
	
	
	// Retrieving ODD numbers from the LIST
	private static void printOddNumbersInList(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the ODD numbers -> Method Reference Approach ");
		numbers.stream()
					   .filter(FP01Functional_MethodReference :: printOddNumbersViaMethodReferenceApproach)
					   .forEach(System.out::println);
	}

}
