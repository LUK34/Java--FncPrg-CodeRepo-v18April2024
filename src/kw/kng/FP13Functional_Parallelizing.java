package kw.kng;

import java.util.stream.LongStream;

public class FP13Functional_Parallelizing 
{
	public static void main(String[] args)
	{
			long time= System.currentTimeMillis();
			
			//0, 100000000
			//System.out.println(LongStream.range(0, 100000000).sum());
			System.out.println(LongStream.range(0, 100000000).parallel().sum());
			
			System.out.println(System.currentTimeMillis() - time);
	}

}


/*

1.
This program is designed to demonstrate the efficiency gain (if any) from using parallel streams in Java for large-scale computations.
 It computes the sum of a very large range of numbers and prints both the result of the sum and the time taken to compute it,
 giving an insight into the performance benefits of parallel processing in Java.


2.Main Functionality

2.1 Time Measurement Start: 
The program first captures the current time in milliseconds using System.currentTimeMillis(). 
This is used to measure how long it takes to perform the subsequent operations.

2.2 LongStream.range(0, 100000000): 
This generates a sequence of long numbers starting from 0 up to (but not including) 100,000,000.

2.3 .parallel(): 
This method is used to convert the stream into a parallel stream.
 A parallel stream splits the data into multiple parts, processing them in parallel using multiple threads. 
 This can lead to performance improvements, especially on multi-core processors, depending on the nature of the data and the operation.

2.4 .sum(): 
This aggregates the values by summing them up. Since the operation is performed on a parallel stream, 
the sum is calculated in a concurrent manner across multiple threads.


 */