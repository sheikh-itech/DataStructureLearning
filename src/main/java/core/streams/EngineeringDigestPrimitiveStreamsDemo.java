package core.streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class EngineeringDigestPrimitiveStreamsDemo {

	public static void main(String[] args) {

		int[] nums = {2, 4, 3, 6, 5, 7, 6, 2, 3};
		
		IntStream num1 = Arrays.stream(nums);
		
		// Returns boxed stream -> boxed()
		/*	boxed()-> convert a primitive stream (like IntStream, LongStream, or DoubleStream) 
		 * into a stream of wrapper objects — such as Stream<Integer>, Stream<Long> */
		IntStream.range(1, 5).boxed().collect(Collectors.toList());
		
		IntStream.of(1, 2, 3, 4, 5);
		
		DoubleStream doubleStream = new Random().doubles(5);
		//System.out.println("Sum: "+doubleStream.sum());
		System.out.println(doubleStream.boxed().collect(Collectors.toList()));
		
		IntStream intStream = new Random().ints();
	}
}
