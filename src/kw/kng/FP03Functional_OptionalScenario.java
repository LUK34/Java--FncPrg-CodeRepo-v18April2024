package kw.kng;

import java.util.List;
import java.util.Optional;

public class FP03Functional_OptionalScenario 
{
	public static void main(String[] args)
	{
		List<String> fruits= List.of("Apples","Oranges","Kiwi","Watermelon");
		Optional<String> opt= fruits.stream().filter(f  -> f.startsWith("K") ).findFirst();
		System.out.println(opt);
		System.out.println(opt.isEmpty());
		System.out.println(opt.isPresent());
		System.out.println(opt.get());
	}
}
