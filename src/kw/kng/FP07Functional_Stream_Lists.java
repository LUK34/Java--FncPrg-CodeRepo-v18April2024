package kw.kng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP07Functional_Stream_Lists
{
	
	public static void main(String[] args)
	{
		List<Integer> numero=List.of(12,9,3,4,5,6);
		
		
		List<String> coursero= List.of("Spring","Spring Boot","API","Microservices",
				"AWS","PCF","Azure","Docker","Kubernetes");
		
		
		List<Integer> result_DoubleList = doubleList(numero);
		System.out.println("Double Numbers List = " + result_DoubleList );
		
		List<Integer> result_TripleList = tripleList(numero);
		System.out.println("Triple Numbers List = " + result_TripleList );
		
		List<Integer> result_EvenNumbersList = evenNumberList(numero);
		System.out.println("Even Numbers List = " + result_EvenNumbersList );
		
		List<Integer> result_OddNumbersList = oddNumberList(numero);
		System.out.println("Odd Numbers List = " + result_OddNumbersList );
		
		List<Integer> result_EvenSqNumbersList = evenSqNumberList(numero);
		System.out.println("Square the Even Numbers in a List = " + result_EvenSqNumbersList );
		
		List<Integer> result_OddSqNumbersList = oddSqNumberList(numero);
		System.out.println("Square the Odd Numbers in a List = " + result_OddSqNumbersList );
		
		List<Integer> result_EvenCubeNumbersList = evenCubeNumberList(numero);
		System.out.println("Cube the Even Numbers in a List = " + result_EvenCubeNumbersList );
		
		List<Integer> result_OddCubeNumbersList = oddCubeNumberList(numero);
		System.out.println("Cube the Odd Numbers in a List = " + result_OddCubeNumbersList );
		
		List<String> listy1= List_Stream_String_Length_ASC_OR_DESC(coursero,false); //To get the List of Strings in ASC order of Length
		System.out.println("List containing courses in ASC Order: "+listy1);
			
		List<String> listy2= List_Stream_String_Length_ASC_OR_DESC(coursero,true); //To get the List of Strings in ASC order of Length
		System.out.println("List containing courses in ASC Order: "+listy2);
	
		System.out.println("Stream using `joining` using space ");
		System.out.println(coursero.stream().collect(Collectors.joining(" ")));
		
		System.out.println("Stream using `joining` using comma ");
		System.out.println(coursero.stream().collect(Collectors.joining(",")));
		
		System.out.println("Split example ");
		System.out.println( coursero.stream().map(c ->c.split("")).flatMap(Arrays::stream).collect(Collectors.toList()) );
		
		System.out.println("Split  distinct example ");
		System.out.println( coursero.stream().map(c ->c.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()) );
		
		List<String> coursero2=coursero.stream().map(c ->c.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		/*
		 Flatmap: each element of Stream replaced with content of mapped stream.Mapping function ->Arrays::stream
		*/
	
	}

	private static List<Integer> doubleList(List<Integer> numero) 
	{
		return numero.stream()
								.map( n -> n*n)
								.collect(Collectors.toList());
	}

	private static List<Integer> tripleList(List<Integer> numero) 
	{
		return numero.stream()
								.map( n -> n*n*n)
								.collect(Collectors.toList());
	}
	
	private static List<Integer> evenNumberList(List<Integer> numero) 
	{
		return numero.stream()
								.filter(n->n%2==0)
								.collect(Collectors.toList());
	}
	
	private static List<Integer> oddNumberList(List<Integer> numero) 
	{
		return numero.stream()
								.filter(n->n%2==1)
								.collect(Collectors.toList());
	}
	
	
	private static List<Integer> evenSqNumberList(List<Integer> numero) 
	{
		return numero.stream()
								.filter(n->n%2==0)
								.map(n->n*n)
								.collect(Collectors.toList());
	}
	
	private static List<Integer> oddSqNumberList(List<Integer> numero) 
	{
		return numero.stream()
								.filter(n->n%2==1)
								.map(n->n*n)
								.collect(Collectors.toList());
	}
	
	
	private static List<Integer> evenCubeNumberList(List<Integer> numero) 
	{
		return numero.stream()
								.filter(n->n%2==0)
								.map(n->n*n*n)
								.collect(Collectors.toList());
	}
	
	private static List<Integer> oddCubeNumberList(List<Integer> numero) 
	{
		return numero.stream()
								.filter(n->n%2==1)
								.map(n->n*n*n)
								.collect(Collectors.toList());
	}
	
	
	private static List<String> List_Stream_String_Length_ASC_OR_DESC(List<String> coursero, boolean descending)
	{
		System.out.println("The Sorted List of Strings length-wise ASC(Flag Value =False) / DESC (Flag Value= True) Order:");
		  
	    System.out.println("---------------------------------------" );
	    System.out.println("FLAG Value: " + descending );
	    System.out.println("---------------------------------------" );
	    
	    Comparator<String> comparator = Comparator.comparing(String::length);
	    if (descending) //If true then this line will be executed.
	    {
	        comparator = comparator.reversed();
	    }

	    return coursero.stream()
	    				.sorted(comparator)
	    				.map(s -> "Name: " + s + " Length: " + s.length())
	    				.collect(Collectors.toList());
	}
	
	
}


/*

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//1. What are Intermediate Operations??
 
 Ans. Intermediate operations are those operations on streams that return a new stream as a result. 
 These operations are lazy, meaning they do not execute until a terminal operation is invoked. 
 Here are some common intermediate operations in Java 8 along with their method names:

filter(Predicate<T>) - Returns a stream consisting of the elements that match the given predicate.
map(Function<T, R>) - Returns a stream where each element is replaced by the results of applying a given function.
flatMap(Function<T, Stream<R>>) - Used to flatten a stream of collections to a stream of objects.
distinct() - Returns a stream with distinct elements (according to the equals() method of the elements).
sorted() and sorted(Comparator<T>) - Returns a stream sorted according to natural order or a custom comparator.
peek(Consumer<T>) - Applies a non-interfering action to the elements as they are consumed from the stream, mainly for debugging purposes.
limit(long n) - Truncates the stream to be no longer than the specified size.
skip(long n) - Skips the first n elements of the stream.

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 //2. What are Terminal Operations??
  
Terminal operations are those operations that close the stream and start the processing of data. 
They produce a result (such as a primitive value, a collection, or no value at all) and, once performed, 
the stream can no longer be used. Here are some common terminal operations in Java 8:

forEach(Consumer<T>) - Performs an action for each element of the stream.
toArray() - Returns an array containing the elements of the stream.
reduce(BinaryOperator<T>) and reduce(T, BinaryOperator<T>) - Performs a reduction on the elements of the stream using an associative accumulation function.
collect(Collector<T, A, R>) - Performs a mutable reduction operation on the elements of the stream using a Collector.
min(Comparator<T>) and max(Comparator<T>) - Returns the minimum or maximum element of the stream based on a comparator.
count() - Returns the count of elements in the stream.
anyMatch(Predicate<T>), allMatch(Predicate<T>), and noneMatch(Predicate<T>) - These operations are used to check if some, all, or no elements of the stream match the given predicate, respectively.
findFirst() and findAny() - Return an Optional describing some element of the stream, or an empty Optional if the stream is empty.



 */





























