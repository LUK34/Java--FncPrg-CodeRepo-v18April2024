package kw.kng;

import java.util.List;

public class FP01Structred 
{
	
	public static void main(String[] args)
	{
		printAllNumbersInListFunctional(List.of(12,9,3,4,5,6));
		printAllEvenNumbersInListFunctional(List.of(12,9,3,4,5,6));
		printAllOddNumbersInListFunctional(List.of(12,9,3,4,5,6));
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Structred Programming approach");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the numbers using FOR Loop");
		for(int n: numbers)
		{
			System.out.println(n);
		}
		System.out.println("------------------------------------------------------------------------------");
		
		System.out.println("Refer FP01Functional_MethodReference.java for Functional Programming. This is STARTER");
	}

	
	private static void printAllEvenNumbersInListFunctional(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Structred Programming approach");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all EVEN numbers using FOR Loop");
		for(int n: numbers)
		{
			if(n%2==0)
			{
				System.out.println(n);
			}
			
		}
		System.out.println("------------------------------------------------------------------------------");
		
		System.out.println("Refer FP01Functional_MethodReference.java for Functional Programming. This is STARTER");
	}
	
	
	
	private static void printAllOddNumbersInListFunctional(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Structred Programming approach");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all ODD numbers using FOR Loop");
		for(int n: numbers)
		{
			if(n%2!=0)
			{
				System.out.println(n);
			}
			
		}
		System.out.println("------------------------------------------------------------------------------");
		
		System.out.println("Refer FP01Functional_MethodReference.java for Functional Programming. This is STARTER");
	}
}
