package core.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListExcersize {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 2, 12, 10, 22);

		//Even numbers list
		List<Integer> filteredList = nums.stream().filter(n -> n%2==0).collect(Collectors.toList());
		System.out.println(filteredList);
		
		// Divide by 2 all elements
		List<Integer> halfList = filteredList.stream().map(n -> n/2).collect(Collectors.toList());
		System.out.println(halfList);
		
		//Squared list elements
		List<Integer> squareList = filteredList.stream().map(n -> n*n).collect(Collectors.toList());
		System.out.println(squareList);
		
		//Distinct sorted list ASC order
		List<Integer> sortedDistinct = halfList.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedDistinct);
		
		//Distinct sorted list DESC order
		List<Integer> sortedDescDistinct = halfList.stream().distinct().sorted((a, b) -> (b-a)).collect(Collectors.toList());
		System.out.println(sortedDescDistinct);
		
		//Limit and Skip
		List<Integer> limitAndSkip = halfList.stream().distinct().sorted((a, b) -> (b-a))
				.skip(2).limit(2).collect(Collectors.toList());
		System.out.println(limitAndSkip);
		
		//Peek is consumer
		List<Integer> list = Stream.iterate(0, n -> n+1)
				.limit(101).skip(1).peek(n->System.out.print(n+" ")).collect(Collectors.toList());
		
		// Get max in ascending order
		int max = Stream.iterate(0, n -> n+1)
				.limit(101).skip(1).max((a, b) -> (a-b)).get();
		System.out.println("\nMax: "+max);
		
		// Get max in descending order
		int max1 = Stream.iterate(0, n -> n+1)
				.limit(101).skip(1).max((a, b) -> (b-a)).get();
		System.out.println("Desc Max: "+max1);
	}
}
