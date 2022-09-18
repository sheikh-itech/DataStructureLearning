package ds.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/** Accepts two arguments & produces a result
 */
public class BiFunction_Example {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		Function<Integer, Integer> multiply = (a) -> a*3;
		
		System.out.println(add.apply(8, 9));
		
		System.out.println(add.andThen((a) -> a * 2).apply(5,  8));
		
		System.out.println(add.andThen(multiply).apply(7, 5));
	}
}
