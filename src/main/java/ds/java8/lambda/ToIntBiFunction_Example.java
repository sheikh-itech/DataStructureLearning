package ds.java8.lambda;

import java.util.function.ToIntBiFunction;

/**	Represents function that accepts two arguments and produces an int-valued result
 */
public class ToIntBiFunction_Example {

	public static void main(String[] args) {

		ToIntBiFunction<Integer, Integer> test1 = (t, u) -> t * u;
		ToIntBiFunction<Integer, String> test2 = (t, u) -> t * Integer.parseInt(u);
		
		System.out.println(test1.applyAsInt(10, 7));
		System.out.println(test2.applyAsInt(8, "5"));
	}
}
