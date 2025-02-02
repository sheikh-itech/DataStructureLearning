package core.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaWithStream {

	public static void main(String[] args) {

		/* On filtered stream forEach lambda applied */
		List<String> names = Arrays.asList("John", "Jane", "Doe", "Alice");
		
		names.stream()
	    .filter(name -> name.startsWith("J"))
	    .forEach(System.out::println);

	}
}
