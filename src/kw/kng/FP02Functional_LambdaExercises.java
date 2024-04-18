package kw.kng;

import java.util.List;

public class FP02Functional_LambdaExercises 
{
	
	public static void main(String[] args)
	{
		List<Integer> numero=List.of(12,9,3,4,5,6);
		
		List<String> courses= List.of("Spring","Spring Boot","API","Microservices",
				"AWS","PCF","Azure","Docker","Kubernetes");
		
		
		printAllNumbersInList(numero);
		System.out.println(" ======================================================================================= ");
		System.out.println("											Using FILTERS														");
		System.out.println(" ======================================================================================= ");
		printEvenNumbersInList(numero);
		printOddNumbersInList(numero);	
		printAllCoursesInList(courses);
		printSpecificCoursesInList(courses);
		printCourseLength4InList(courses);
		
		System.out.println(" ======================================================================================= ");
		System.out.println("											Using FILTERS and MAP										");
		System.out.println(" ======================================================================================= ");
		printSqEvenNumbersInList(numero);
		printSqOddNumbersInList(numero);
		printCubeOddNumbersInList(numero);
		printCourseLengthInList(courses);
		
		
		
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
		System.out.println("Retrive all the numbers -> Method Reference Approach ");
		numbers.stream()
					   .forEach(FP02Functional_LambdaExercises :: printNumbersViaMethodReferenceApproach);
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
	


	
	//Retrieve all courses from the LIST
	private static void printAllCoursesInList(List<String> stringy)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the courses  -> Lambda expression ");
		stringy.stream()
				 .forEach(System.out::println);
	}
	
	//Retrieve all courses from the LIST
	private static void printSpecificCoursesInList(List<String> stringy)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive specifc the courses  -> Lambda expression ");
		stringy.stream()
					.filter( s->s.contains("Spring") )
					.forEach(System.out::println);
	}
	
	//Retrieve all course length with length greater than 4 from the LIST
	private static void printCourseLength4InList(List<String> stringy)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive specifc the courses withe course length greater than or equal to 4 -> Lambda expression ");
		stringy.stream()
					.filter( s->s.length() >=4 )
					.forEach(System.out::println);
	}
	
	// Retrieving EVEN numbers from the LIST-> SQUARE
	private static void printSqEvenNumbersInList(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the EVEN numbers and SQUARE it -> Lambda expression ");
		numbers.stream()
						.filter( number -> number%2 ==0)
						.map(n -> n* n)
					   .forEach(System.out::println);
	}
	
	// Retrieving ODD numbers from the LIST->SQUARE
	private static void printSqOddNumbersInList(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the ODD numbers and SQUARE it  -> Lambda expression ");
		numbers.stream()
						.filter( number -> number%2 !=0)
						.map(n -> n* n)
						.forEach(System.out::println);
	}
	
	
	private static void printCubeOddNumbersInList(List<Integer> numbers)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive all the ODD numbers and CUBE it  -> Lambda expression ");
		numbers.stream()
						.filter( number -> number%2 !=0)
						.map(n -> n * n*n)
						.forEach(System.out::println);
	}
	
	
	
	private static void printCourseLengthInList(List<String> stringy)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Retrive course length from the LIST -> Lambda expression ");
		stringy.stream()
					.map( s-> "Name of the course -> " +"  "+ s + " ->  "+" Length ->  " + s.length() )
					.forEach(System.out::println);
	}

}
