package ds.java8.lambda;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**	Takes One Input of <T> type
 * 	and produces one result of <T>
 */
public class Function_Example {

	public static void main(String[] args) {

		Function<String, Integer> func1 = x -> x.length();
		Function<String, String> func2 = x -> x+"_";
		Function<String, String> func3 = x -> x + "Vehleen";
		Function<Integer, Integer> func4 = Function.identity();
		
		System.out.println("'Arham' length: "+func1.apply("Arham"));


		/**	andThen(...)
		 * Returns a composed function that first applies this function to its input, 
		 * and then applies the after function to the result
		 */
//Chain Function<T, R> using-> andThen
		//First -> Second
		
		System.out.println(func2.andThen(func3).apply("Arham"));

		/**	compose(...)
		 * Returns a composed function that first applies the before function to its input, 
		 * and then applies this function to the result
		 */
//Chain Function<T, R> using-> compose
		//Second -> First
		System.out.println(func2.compose(func3).apply("Arham"));
		
//Function.identity
		
		System.out.println(func4.apply(10));
		
		Set<Integer>nums = Arrays.asList(10, 5, 6, 8, 22).stream().map(Function.identity()).collect(Collectors.toSet());
		System.out.println(nums);
		
		nums.forEach(num->System.out.print(func4.apply(num)+", "));
	}
}
