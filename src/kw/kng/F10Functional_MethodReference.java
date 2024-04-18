package kw.kng;

import java.util.List;
import java.util.function.Supplier;

public class F10Functional_MethodReference 
{
	private static void print(String str)
	{
		System.out.println(str);
	}
	
	public static void main(String[] args)
	{
		List<String> courses= List.of("Spring", "SpringBoot","AWS","PCF","Azure","Docker","Kubernetes" );
		
		courses.stream()
					.map(str ->str.toUpperCase())
					//.forEach(str -> System.out.println(str));
					.forEach(F10Functional_MethodReference::print);
		
		Supplier<String> supplier = String:: new;
		
		
	}

}
