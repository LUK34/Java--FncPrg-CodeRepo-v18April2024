package kw.kng;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FP09Functional_BehaviourFuncInterfaces
{
	public static void main(String[] args)
	{
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		System.out.println("EVEN Numbers by Behaviour Parametrization using Functional Interface.");
		filterAndPrint(numbers, x -> x%2==0);
		System.out.println("ODD Numbers by Behaviour Parametrization using Functional Interface.");
		filterAndPrint(numbers, x -> x%2!=0);
		System.out.println("Multiples of 3 by Behaviour Parametrization using Functional Interface.");
		filterAndPrint(numbers, x -> x%3==0);
		
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("Mapping Function by Behaviour Parametrization using Functional Interface.");
		
		List<Integer> squaredNumbers= mappingAndCreateNewList(numbers,  x->x*x);
		System.out.println("SQUARING Result: " + squaredNumbers);
		
		List<Integer> cubedNumbers= mappingAndCreateNewList(numbers,  x->x*x*x);
		System.out.println("CUBING Result: " + cubedNumbers );

		List<Integer> summedUpNumbers= mappingAndCreateNewList(numbers,  x->x+x);
		System.out.println("SUM Result: " + summedUpNumbers );
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		Supplier<Integer> randomIntegerSupplier= () ->
		{
			Random r=new Random();
			return r.nextInt(1000);			
		} ;
		System.out.println("Suppplier doesnt have any Input, But it provides output. Value: "+ randomIntegerSupplier.get());
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		UnaryOperator<Integer> u=  (x)->3*x;
		System.out.println("Unary operator. Takes one input and return output of the same type: "+ u.apply(10));
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("BiPredicate example: ");
		System.out.println("--------------------------------");
		BiPredicate<Integer, String> biPredicate = (number, str) ->
		{
			return number<10 && str.length()>5;
		}; 
		/*
		BiPredicate<T, U>
			T ->	Input
			U -> Input
			
			BiPredicate evaluates to a boolean value based on the two inputs. It does not produce an output beyond the boolean result.
		 */
		System.out.println(biPredicate.test(5, "in28minutes"));
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("BiFunction example: ");
		System.out.println("--------------------------------");
		BiFunction<Integer, String, String> biFunction= (number, str) ->
		{
			return number + " "+ str;
		}; 
		/*
		 BiFunction<T, U, R>
		 				T -> Input
		 				U -> Input
		 				R -> Output
		 				
		 BiFunction accepts two inputs and produces one output, which can be of any type specified by R.		
		 */
		System.out.println(biFunction.apply(15, "in28minutes"));
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("BiConsumer example: ");
		System.out.println("--------------------------------");
		BiConsumer<Integer, String> biConsumer=(s1,s2)->{
			System.out.println(s1);
			System.out.println(s2);
		};
		/*
		 BiConsumer<T, U>
		 				T -> Input
		 				U -> Input
		 				
		 BiConsumer accepts two inputs but does not produce an output;
		 it is typically used for performing side-effects or operations that use the inputs, such as logging, sending messages, or updating an object's state.			
		 */
		biConsumer.accept(15, "in28Minutes") ;
		
		
	}
	private static void filterAndPrint( List<Integer> numbers , Predicate<? super Integer> predicate)
	{
		numbers.stream()
					   .filter(predicate)
					   .forEach(System.out::println);
	}
	
	private static List<Integer> mappingAndCreateNewList( List<Integer> numbers , Function<Integer,Integer> mappingFunction)
	{
		return numbers.stream()
					   .map(mappingFunction)
					   .collect(Collectors.toList());
	}
	
	
}



/*
 
 // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
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

 // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
 1. BiPredicate:
 --------------------------
A BiPredicate<T, U> is a functional interface that represents a predicate (boolean-valued function) of two arguments. It has one method:

boolean test(T t, U u)

This method evaluates the predicate on the given arguments. It returns true or false based on the implementation. 
BiPredicate is often used in filtering or matching scenarios where you need to evaluate a condition based on two input values.

Example: A BiPredicate to check if the sum of two integers is even could be implemented as:
Example:
BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;

 
 2.BiFunction:
  --------------------------
A BiFunction<T, U, R> is a functional interface that takes two arguments of types T and U, and returns an object of type R. It has one method:

R apply(T t, U u)
This method applies the function to the given arguments and returns a result. 
This is useful for scenarios where you need to perform a calculation or transformation involving two input values and produce a result.

Example: A BiFunction to combine two strings could look like:
Example:
BiFunction<String, String, String> concatenate = (a, b) -> a + b;

3. BiConsumer:
------------------------------
A BiConsumer<T, U> is a functional interface that represents an operation that accepts two input arguments and returns no result. It has one method:

void accept(T t, U u)
This is used for operations where you want to perform some action that consumes the input values without expecting a return value, such as setting values or printing.

Example: A BiConsumer to print two values could be implemented as:
Example:
BiConsumer<String, Integer> print = (name, age) -> System.out.println("Name: " + name + ", Age: " + age);







 */