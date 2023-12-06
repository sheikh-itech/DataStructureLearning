package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**	A mutable reduction operation that accumulates input elements into a mutable result container
 * 	Reduction operations can be performed either sequentially or in parallel
 * 
 *	Collectors is implementation of Collector
 */
public class CollectorExample {

	public static void main(String[] args) {

		//More Examples of Collectors
		new CollectorExample().CollectorExamples();
	}
	
	void CollectorExamples() {
		
		List<String> lists = Arrays.asList("a", "bb", "ccc", "dd", "a");
		
		List<String> temp1 = lists.stream().collect(Collectors.toUnmodifiableList());
		//temp1.add("A");	UnsupportedOperationException
		System.out.println(temp1);
		
		Set<String> temp2 = lists.stream().collect(Collectors.toUnmodifiableSet());
		//temp2.add("AA");	UnsupportedOperationException
		System.out.println(temp2);
		
		//Skipping for duplicate issue
		Map<String, Integer> temp3 = lists.stream().skip(1).collect(Collectors.toUnmodifiableMap(Function.identity(), String::length));
		System.out.println(temp3);
		
	}
}
