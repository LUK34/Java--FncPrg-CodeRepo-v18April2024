package kw.kng;

import java.util.List;

public class FP05Functional_StreamsAndReduce
{
	public static void main(String[] args)
	{
		List<Integer> numero=List.of(12,9,3,4,5,6);
		print_SumOfSquare_ofEach_Number(numero);
		print_SumOfCube_ofEach_Number(numero);
		print_Odd_SumOfSquare_ofEach_Number(numero);
		print_Odd_SumOfCube_ofEach_Number(numero);
		print_Even_SumOfSquare_ofEach_Number(numero);
		print_Even_SumOfCube_ofEach_Number(numero);
	}
	private static void print_SumOfSquare_ofEach_Number(List<Integer> numbers)
	{
		System.out.println("The SUM of SQUARE of each number: ");
		int a= numbers.stream()
								 .map(x-> x*x)
								 .reduce( 0 , Integer::sum);
		
		System.out.println("RESULT:" + a);
	}
	
	
	private static void print_SumOfCube_ofEach_Number(List<Integer> numbers)
	{
		System.out.println("The SUM of SQUARE of each number: ");
		int a= numbers.stream()
								  .map(x-> x*x*x)
								  .reduce( 0 , Integer::sum);;
		
		System.out.println("RESULT:" + a);
	}
	

	private static void print_Odd_SumOfSquare_ofEach_Number(List<Integer> numbers)
	{
		System.out.println("The SUM of SQUARE of ODD number: ");
		int a= numbers.stream()
								  .filter(x->x%2==1)
								  .map(x-> x*x)
								  .reduce( 0 , Integer::sum);;
		
		System.out.println("RESULT:" + a);
	}
	
	private static void print_Odd_SumOfCube_ofEach_Number(List<Integer> numbers)
	{
		System.out.println("The SUM of CUBE of ODD number: ");
		int a= numbers.stream()
								  .filter(x->x%2==1)
								  .map(x-> x*x*x)
								  .reduce( 0 , Integer::sum);;
		
		System.out.println("RESULT:" + a);
	}
	
	private static void print_Even_SumOfSquare_ofEach_Number(List<Integer> numbers)
	{
		System.out.println("The SUM of SQUARE of EVEN number: ");
		int a= numbers.stream()
								  .filter(x->x%2==0)
								  .map(x-> x*x)
								  .reduce( 0 , Integer::sum);;
		
		System.out.println("RESULT:" + a);
	}
	
	private static void print_Even_SumOfCube_ofEach_Number(List<Integer> numbers)
	{
		System.out.println("The SUM of CUBE of EVEN number: ");
		int a= numbers.stream()
								  .filter(x->x%2==0)
								  .map(x-> x*x*x)
								  .reduce( 0 , Integer::sum);;
		
		System.out.println("RESULT:" + a);
	}
	
	
	
	
	
	
	
	
	
}
