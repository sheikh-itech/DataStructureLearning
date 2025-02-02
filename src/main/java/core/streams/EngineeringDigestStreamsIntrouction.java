package core.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EngineeringDigestStreamsIntrouction {

	public static void main(String[] args) {

		List<String> fruits = Arrays.asList("Apple", "Banana", "Papaya");
		
		// 1. List to Stream
		Stream<String> stream1 = fruits.stream();
		
		int nums[] = {1, 2, 3, 4, 5};
		
		// 2. Arrays to Stream
		IntStream numsstream = Arrays.stream(nums);
		
		// 3. Random Stream Generation
		
		Stream<Integer> nums1 = Stream.of(1, 2, 3, 4, 5);
		
		// 4. Random Ranged Stream
		
		Stream.iterate(0, n->n+1).limit(100);	//Start: 0, n=n+1 for 100 times
		
		// 5. Random Ranged Duplicate Stream
		
		Stream.generate(()->"Hello").limit(5);	// 'Hello' for 5 times

		//Unique
		Stream.generate(()->(int)Math.random()*10).limit(10);
		
	}
}
