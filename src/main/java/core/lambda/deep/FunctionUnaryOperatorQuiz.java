package core.lambda.deep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/*	It's a functional interface that takes one input of type T and 
 * 	returns a result of same type T.
 *  This is equivalent to Function<T, R>,
 * 	UnaryOperator<T> operator = t -> { return ... };	*/
public class FunctionUnaryOperatorQuiz {

	private static List<Integer> nums = Arrays.asList(1, 2, 5, 90, 12, 70, 5, 8, 19);
	private static List<String> fruits = new ArrayList<>();
	
	public static void main(String[] args) {
		init();
		
	// 1. Square each number in a list
		
		UnaryOperator<Integer> square = n -> n * n;
		
		nums.stream().map(square).forEach(n-> System.out.print(n+", "));
		System.out.println();
		
	// 2. Convert all strings in a list to lowercase
		
		UnaryOperator<String> lowerCase = str -> str.toLowerCase();
		
		fruits.stream().map(lowerCase).forEach(f-> System.out.print(f+", "));
		System.out.println();
		
	// 3. Trim extra spaces in strings
		
		UnaryOperator<String> trim = s -> s.trim();
		
		System.out.println(trim.apply(" Arham Shekh "));
		
	// 4. Add tax to a price
		
		UnaryOperator<Double> addTax = price -> price * 1.18;
		
		System.out.println(addTax.apply(100d));
		
	// 5. Toggle boolean value
		
		UnaryOperator<Boolean> toggle = b -> !b;
		
		System.out.println(toggle.apply(false));
		
	// 6. Append a suffix to a filename
		
		UnaryOperator<String> addSuffix = name -> name + "_v1";
		
		System.out.println(addSuffix.apply("Java"));
		
	// 7. Clamp a number between 0 and 100
		
		UnaryOperator<Integer> clamp = n -> Math.max(0, Math.min(100, n));
		
		System.out.println("Between 0 to 100: "+clamp.apply(111));
		
	// 8. Get next even number, Hint: Used in generating sequences
		
		UnaryOperator<Integer> nextEven = n -> (n % 2 == 0) ? n + 2 : n + 1;
		
		System.out.println("Next Even: "+nextEven.apply(3));
		
	// 9. Capitalize first letter of a word
		
		UnaryOperator<String> capitalize = s -> s.substring(0, 1).toUpperCase() + s.substring(1);
		
		System.out.println(capitalize.apply("arham"));
		
	// 10. Reverse digits of an integer (e.g. 123 -> 321)
		
		UnaryOperator<Integer> numReverse = num 
				-> Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
		
		System.out.println(numReverse.apply(123));
	}
	
	private static void init() {
		fruits.add("Apple");	fruits.add("PineApple");
		fruits.add("Banana");	fruits.add("Blackberry");
		fruits.add("Apple");	fruits.add("Mango");
		fruits.add("Guava");	fruits.add("Grape");
		fruits.add("Banana");	fruits.add("Watermelon");
	}
}
