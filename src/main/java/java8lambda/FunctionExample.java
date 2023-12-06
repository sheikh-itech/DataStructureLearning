package java8lambda;

import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {

		Function<String, Double> convert = (a)->Double.parseDouble(a);
		convert = convert.andThen(a->a/2);
		System.out.println(convert.apply("10"));
		
		
	}

}
