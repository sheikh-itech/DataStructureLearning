package core.streams;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**		**	Independent Task Only	**
 * 	Large data set
 * 	CPU Intensive task
 * 
 * 	May add overhead for small scale data
 */
public class EngineeringDigestParallelStreamDemo {

	public static void main(String[] args) {

		List<Integer> nums = Stream.iterate(1, n->n+1).limit(2000).toList();
		
		long startTime = System.currentTimeMillis();
		
		nums.stream().map(n->factorial(n)).toList();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Single thread stream time: "+(endTime-startTime)+" mili");
		
		startTime = System.currentTimeMillis();
		
		nums.parallelStream().map(n->factorial(n)).toList();
		
		endTime = System.currentTimeMillis();
		
		System.out.println("Multi thread stream time: "+(endTime-startTime)+" mili");
		
// Cumulative sum [1, 2, 3, 4, 5] => [1, 3, 6, 10, 15]
		
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
		
		AtomicInteger sum = new AtomicInteger();	//Final or Effectively Final ke case me
		
		List<Integer> finalVal = num.stream().parallel().map(sum::addAndGet).toList();
		
		// Diff order since parallel stream and not independent task
		System.out.println("Sum: "+finalVal);
		
		
//	Convert Parallel stream to Sequential stream
		
		nums.parallelStream().map(n->factorial(n)).sequential().toList();
		
		nums = Arrays.asList(5, 7, 8, 2, 9, 7, 4, 6);
		
//forEachOrder to process in same order
		
		nums.parallelStream().forEachOrdered(System.out::println);
	}
	
	private static BigInteger factorial(int n) {
		
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
