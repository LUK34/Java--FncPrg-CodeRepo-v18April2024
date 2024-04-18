package kw.kng;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP14Functional_FileUsingStreams 
{
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("-------------------------------------------------------------- ");
		System.out.println("Programme 1: ");
		Files.lines(Paths.get("file.txt"))
				.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------- ");
		System.out.println("Programme 2: ");
		Files.lines(Paths.get("file.txt"))
			    .map(str -> str.split(""))
			    .flatMap(Arrays::stream)
				.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------- ");
		System.out.println("Programme 3: ");
		Files.lines(Paths.get("file.txt"))
			    .map(str -> str.split(" "))
			    .flatMap(Arrays::stream)
				.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------- ");
		System.out.println("Programme 4: ");
		Files.lines(Paths.get("file.txt"))
			    .map(str -> str.split(" "))
			    .flatMap(Arrays::stream)
			    .sorted()
				.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------- ");
		System.out.println("Programme 5: ");
		Files.lines(Paths.get("file.txt"))
			    .map(str -> str.split(" "))
			    .flatMap(Arrays::stream)
			    .distinct()
			    .sorted()
				.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------- ");
		System.out.println(" Contents present at root directory is as follows : ");
		Files.list(Paths.get("."))
		        .forEach(System.out::println);
		System.out.println("-------------------------------------------------------------- ");
		System.out.println("Folders present at root directory is as follows : ");
		Files.list(Paths.get("."))
		        .filter(Files::isDirectory).forEach(System.out::println);
		System.out.println("-------------------------------------------------------------- ");
	}
	
	

}




/*
 
 1. For the programme to work the location of the file should be placed at the root folder which is basically outside the src folder.
 
 2. The flatMap method in Java's Stream API is used to flatten streams of streams into a single stream.
 This method is particularly useful when you want to transform each element of a stream into one or more elements represented as another stream,
  and then concatenate all these streams together into a single stream.
 
 
 
 
 */

