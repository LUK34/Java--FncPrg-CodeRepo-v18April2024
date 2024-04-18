package kw.kng;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP08Functional_FunctionalInterfaces
{
	public static void main(String[] args)
	{
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
		Predicate<Integer> isEvenPredicate = x->x%2==0;
		Function<Integer,Integer> squareFunction=x->x*x;
		Consumer<Integer> sysoutConsumer= System.out::println;
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Part 1:");
		
		numbers.stream()	
					   .filter(isEvenPredicate)
					   .map(squareFunction)
					   .forEach(sysoutConsumer);
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Part 2:");
		
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		int sum= numbers.stream().reduce(0, sumBinaryOperator);
		System.out.println("Sum using Functional Interface: " + sum );
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Part 2.1 :");
		
		BinaryOperator<Integer> sumBinaryOperator2 =  new BinaryOperator<Integer>()
		{
			@Override
			public Integer apply(Integer t, Integer u) {
				
				return t+u;
			}	
		};
		int sum2= numbers.stream().reduce(0, sumBinaryOperator2);
		System.out.println("Sum using Functional Interface: " + sum2 );
		
	}
	
}



/*
 1. What is Functional Interface in Java 8??
 
In Java 8, a functional interface is an interface that has exactly one abstract method. 
These interfaces are intended to be used as targets for lambda expressions and method references.
The concept of functional interfaces is fundamental to the Java 8 Stream API,
 as they provide a clear and concise way to represent single-method interfaces used throughout the API.

Key Characteristics
Single Abstract Method (SAM): 
A functional interface has only one abstract method but can have multiple default or static methods.
Annotation @FunctionalInterface: 
This annotation is not required but can be used to convey intention and enable compile-time checking for the single abstract method criterion. It also helps in documentation.
Common Functional Interfaces in Java 8.Java 8 includes several built-in functional interfaces in the java.util.function package, which are extensively used in stream operations and lambda expressions:

Predicate<T>: 
Represents a predicate (boolean-valued function) of one argument. It is commonly used in filtering operations.

Method: boolean test(T t)
Function<T, R>: Represents a function that accepts one argument and produces a result. Used in map operations to transform stream elements.

Method: R apply(T t)
Supplier<T>: Provides an instance of a type T (such as when creating new instances).

Method: T get()
Consumer<T>: Represents an operation that accepts a single input argument and returns no result. It is often used in operations that operate on each stream element like forEach.

Method: void accept(T t)
BiFunction<T, U, R>: Similar to Function, but takes two arguments. It's useful for combining two streams.

Method: R apply(T t, U u)
UnaryOperator<T>: A special type of Function where the input and output are of the same type. Often used for "update" operations on elements.

Method: T apply(T t)
BinaryOperator<T>: A special type of BiFunction where both operands and the result are of the same type. Used in reduce operations.

Method: T apply(T t1, T t2)
 */