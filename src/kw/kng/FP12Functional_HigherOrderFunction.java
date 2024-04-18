package kw.kng;


import java.util.List;
import java.util.function.Predicate;

public class FP12Functional_HigherOrderFunction
{
	
	public static void main(String[] args)
	{
		List<Courses> coursero=List.of(
				new Courses("Spring", "Framework" , 98 , 20000 ),
				new Courses("Spring Boot", "Framework" , 95 , 18000 ),
				new Courses("API", "Microservices" , 97 , 22000 ),
				new Courses("Microservices", "Microservices" , 91 , 14000 ),
				new Courses("FullStack", "FullStack" , 91 , 14000 ),
				new Courses("AWS", "Cloud" , 92 , 21000 ),
				new Courses("Azure", "Cloud" , 99 , 21000 ),
				new Courses("Docker", "Cloud" , 92 , 20000 ),
				new Courses("Kubernetes", "Cloud" , 91 , 20000 ),
				new Courses("Core Java", "Programming Language" , 91 , 12000 ),
				new Courses("Adv Java", "Programming Language" , 91 , 12000 ),
				new Courses("Python", "Programming Language" , 84 , 10000 )
			);
		
		
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
																			// Higher Order Functions
		Predicate<Courses>  reviewScoreGreaterThan95Predicate = ReviewScoreGenerator(100);
		Predicate<Courses>  reviewScoreGreaterThan90Predicate = ReviewScoreGenerator(95);
	
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("allMatch -> Are all the courses greater than 90 using Predicate:");
		System.out.println(  coursero.stream()
														.allMatch(reviewScoreGreaterThan90Predicate)  );
		System.out.println("allMatch -> Are all the courses greater than 95 using Predicate:");
		System.out.println(  coursero.stream()
														.allMatch(reviewScoreGreaterThan95Predicate)  );
		
		
	}

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
																				// Functions being used inside Higher Order Function

	private static Predicate<Courses> ReviewScoreGenerator(int ReviewScore)
	{
		return course -> course.getReviewScore()>ReviewScore;
	}

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
}


/*

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//1. What are Higher order functions in Java??
 
 Ans:
 

Higher order functions in Java are functions that can either take other functions as parameters or return a function as a result. 
In Java, higher order functions are implemented through the use of functional interfaces and lambda expressions. 
These concepts were significantly enhanced with Java 8, which introduced a more functional style of programming to the language.

Key Concepts:
--------------------
Functional Interfaces:
 A functional interface in Java is an interface with a single abstract method (SAM interface). These interfaces are intended to be implemented by lambda expressions or method references. Common examples include Runnable, Callable, Comparator, and interfaces in the java.util.function package like Function<T,R>, Predicate<T>, Consumer<T>, and Supplier<T>.
Lambda Expressions:
 These are short blocks of code which take parameters and return a value. Lambda expressions are similar to methods, but they do not need a name and can be implemented right in the body of a method.
Method References:
 These are shorthand syntax for a lambda expression that executes just one method. They are part of making Java code more concise and readable.



select the stream using mouse -> right click ->select `Refactor`->`Extract Method`
 */





























