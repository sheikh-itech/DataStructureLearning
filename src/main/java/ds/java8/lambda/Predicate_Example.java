package ds.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**	Predicate-> represents boolean valued function [Used with/for filtering]
 * 	
 * 	Can used for lambda expression Or method reference
 */
public class Predicate_Example {

	public static void main(String[] args) {
		
		predicateNames();
	}
	

	private static void predicateNames() {
		
		List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
		
		Predicate<String> namePredicate = (name)->name.startsWith("S");
		
		Predicate<String> lengthPredicate1 = (name)->name.length()>4;
		
		Predicate<String> lengthPredicate2 = (name)->name.length()>=5;
		
		Predicate<String> lengthPredicate3 = (name)->name.length()>3;

		
		
//Predicate- boolean		
		List<String> names1 = names.stream().filter(namePredicate).collect(Collectors.toList());
		System.out.println(names1);
		
//Predicate- and	
		List<String> names2 = names.stream().filter(namePredicate.and(lengthPredicate1)).collect(Collectors.toList());
		System.out.println(names2);
		
		//And-> Checks condition over each elements, returns whichever true
		names1 = names.stream().filter(namePredicate.and((name)->name.length()>6)).collect(Collectors.toList());
		
//Predicate- isEqual		
		Predicate<Object> predObject = Predicate.isEqual(names.stream()
				.filter(namePredicate.and(lengthPredicate2)).collect(Collectors.toList()));
		
		boolean isEquals = predObject.test(names2);
		System.out.println(isEquals);

//Predicate- or
		names1 = names.stream().filter(namePredicate.or((name)->name.length()>3)).collect(Collectors.toList());
		System.out.println(names1);

		
//Predicate- negate	
		names1 = names.stream().filter(namePredicate.and(lengthPredicate3.negate())).collect(Collectors.toList());
		System.out.println(names1);
	}
}
