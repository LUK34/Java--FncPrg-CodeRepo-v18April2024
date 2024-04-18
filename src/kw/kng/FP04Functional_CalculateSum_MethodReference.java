package kw.kng;

import java.util.List;

public class FP04Functional_CalculateSum_MethodReference
{
	
	public static void main(String[] args)
	{
		List<Integer> numero=List.of(12,9,3,4,5,6);
		printSum(numero);
		printSub(numero);
	}
	
	private static int sum(int a, int b)
	{
		
		System.out.println(a  +  "+" + b );
		return a+b;
	}
	
	private static int sub(int a, int b)
	{
		System.out.println(a  +  "-" + b );
		return a-b;
	}
	
	
		private static void printSum(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive the SUM Result: ");
		int sum = numbers.stream()
					   .reduce(0,FP04Functional_CalculateSum_MethodReference::sum);//0+12,12+9,21+3....
				
			System.out.println("The Result of SUM is :" + sum);
			
	}
		
		private static void printSub(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive the SUB Result: ");
		int sub = numbers.stream()
					   .reduce(0,FP04Functional_CalculateSum_MethodReference::sub);//0-12,-12-9,-21-3....
				
		System.out.println("The Result of SUB is :" + sub);
			
	}

}


/*
The operation in which we  convert a stream of numbers into one result value is called `reduce`. To perform reduce we have to perform an
inital value.
*/