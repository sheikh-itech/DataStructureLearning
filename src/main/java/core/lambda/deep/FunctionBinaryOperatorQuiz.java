package core.lambda.deep;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/*	A functional interface that takes two operands of the same type and 
 * 	returns a result of the same type,
 *  This is equivalent to Function<T, T, R>
 * 	BinaryOperator<T> operator = (a, b) -> { return ... };	*/
public class FunctionBinaryOperatorQuiz {

	private static List<String> fruits = new ArrayList<>();
	
	public static void main(String[] args) {
		init();
		
		
	// 1. Add two integers, Hint: Basic arithmetic, also useful in reduce() operations
		
		BinaryOperator<Integer> add = (a, b) -> a + b;
		
		System.out.println(add.apply(5, 7));
		
	// 2. Concatenate two strings
		
		BinaryOperator<String> concat = (a, b) -> a + b;
		
		System.out.println(concat.apply("Arham ", "Shekh"));
		
	// 3. Find the longer string
		
		BinaryOperator<String> longer = (a, b) -> a.length() >= b.length() ? a : b;
		
		System.out.println(longer.apply("Arham", "Shekh"));
		
	// 4. Return the greater of two integers
		
		BinaryOperator<Integer> max = (a, b) -> Integer.max(a, b);
		
		System.out.println(max.apply(5,  12));
		
	//5. Merge two maps (if value is Integer, sum it)
		
		BinaryOperator<Integer> mergeMaps = (v1, v2) -> v1 + v2;
		
		Map<String, Integer> itemCount = fruits.stream()
				.collect(Collectors.toMap(
						Function.identity(), // key = fruit
						val -> 1, // value = 1 for each occurrence
						mergeMaps // if duplicate, sum the counts
				));

		System.out.println(itemCount); // {orange=1, banana=2, apple=3}
		
	// 6. Subtract smaller from larger number
		
		BinaryOperator<Integer> absDiff = (a, b) -> Math.abs(a - b);
		
		System.out.println(absDiff.apply(5, 17));
		
	// 7. Combine two lists into one
		
		@SuppressWarnings("unused")
		BinaryOperator<List<Integer>> mergeLists = (l1, l2) -> {
			List<Integer> combined = new ArrayList<>(l1);
			combined.addAll(l2);
			return combined;
		};
		
	// 8. Combine two names into "Last, First" format
		
		BinaryOperator<String> nameFormat = (first, last) -> last + ", " + first;
		
		System.out.println(nameFormat.apply("Arham", "Shekh"));
		
	// 9. Multiply two decimals and round to 2 places
		
		BinaryOperator<Double> multiplyRound = (a, b) -> Math.round(a * b * 100.0) / 100.0;
		
		System.out.println(multiplyRound.apply(7d, 6d));
		
	// BinaryOperator.maxBy
		
		String result = fruits.stream().reduce(BinaryOperator.maxBy(String::compareTo)).get();
		System.out.println("Max by: "+result);
		
	// BinaryOperator.minBy
		
		result = fruits.stream().reduce(BinaryOperator.minBy(String::compareTo)).get();
		System.out.println("Min by: "+result);
	}
	
	private static void init() {
		fruits.add("Apple");	fruits.add("PineApple");
		fruits.add("Banana");	fruits.add("Blackberry");
		fruits.add("Apple");	fruits.add("Mango");
		fruits.add("Guava");	fruits.add("Grape");
		fruits.add("Banana");	fruits.add("Watermelon");
	}
}
