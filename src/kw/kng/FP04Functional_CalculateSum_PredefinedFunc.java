package kw.kng;

import java.util.List;
import java.util.Optional;

public class FP04Functional_CalculateSum_PredefinedFunc
{
	
	public static void main(String[] args)
	{
		List<Integer> numero=List.of(12,9,3,4,5,6);
		printSum(numero);
		printSub(numero);
		printMin(numero);
		printMax(numero);
	}
	
	
		private static void printSum(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive the SUM Result using predefined func: ");
		int sum = numbers.stream()
					   .reduce(0, Integer::sum);//0+12,12+9,21+3....
				
			System.out.println("The Result of SUM using predefined func is :" + sum);
			
	}
		
		private static void printSub(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive the SUB Result: ");
		int sub = numbers.stream()
					   .reduce(0,(x,y)->x-y);//0-12,-12-9,-21-3....
				
		System.out.println("The Result of SUB:" + sub);
			
	}
		
		private static void printMin(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive the MIN Result using predefined func: ");
		Optional<Integer> min = numbers.stream()
					   .reduce(Integer::min);//0-12,-12-9,-21-3....
				
		System.out.println("The Result of MIN is using predfined func: " + min.get());
			
	}
		
		
		private static void printMax(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive the MIN Result using predefined func: ");
		Optional<Integer> max = numbers.stream()
					   .reduce(Integer::max);//0-12,-12-9,-21-3....
				
		System.out.println("The Result of MIN is using predfined func: " + max.get());
			
	}

}


/*
The operation in which we  convert a stream of numbers into one result value is called `reduce`. To perform reduce we have to perform an
inital value.
*/