package java8.lambda;

import java.util.function.ToIntFunction;

/**	function that produces an int-valued result
 * 	This is the int-producing primitive specialization for Function
 */
public class ToIntFunction_Example {

	public static void main(String[] args) {

		ToIntFunction<Double> ob = a -> (int)(a * 10);
		
		System.out.println(ob.applyAsInt(3.2));
	}
}
