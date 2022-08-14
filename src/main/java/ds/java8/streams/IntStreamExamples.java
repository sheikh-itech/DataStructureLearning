package ds.java8.streams;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**	A sequence of primitive int-valued elements supporting 
 * 	sequential and parallel aggregate operations
 * 
 * 	Empty stream will return 'true' and predicate will not evaluated
 * 
 * 
 */

public class IntStreamExamples {

	public static void main(String[] args) {
			
		List<Integer> nums = Data.getIntList(50);
		
/** Empty stream will return 'true' and predicate will not evaluated */
		
		boolean temp = nums.stream().allMatch(predicate->predicate/2==0);
		System.out.println("All even: "+temp);
		
		temp = nums.stream().allMatch(predicate->predicate>0);
		System.out.println("All +ve: "+temp);
		
	/** May not evaluate the predicate on all elements 
	 * if not necessary for determining the result 
	 * Returns 'false' for Empty Stream */
		
		temp = nums.stream().anyMatch(predicate->predicate/2==0);
		System.out.println("Any even: "+temp);
		
		//Can't call stream twice once terminal method called Or closed
		IntStream intStream = nums.stream().mapToInt(n->n);
		
		OptionalDouble avg = intStream.average();
		System.out.println("Average: "+avg);
		
		
/**Returns Stream consisting of the elements of this IntStream, each boxed to an Integer */
	     
		Stream<Integer> stream = nums.stream().mapToInt(n->n).boxed();
		System.out.println("Total element: "+stream.count());
		
		IntStream stream1 = nums.stream().mapToInt(n->n);
		IntStream stream2 = nums.stream().mapToInt(n->n);
		
		//Concat 2 streams
		
		avg = IntStream.concat(stream1, stream2).average();
		System.out.println("2 Stream Avg: "+avg);
		
		//Returns Distinct Element's Stream
		
		IntStream distinctStream = nums.stream().mapToInt(n->n).distinct();
		System.out.println("Distinct count: "+distinctStream.count());
		
		//Collect method
		Object ints = nums.stream().mapToInt(n->n).collect(ArrayList::new, (a,b)->a.add(b), ArrayList::add);
		System.out.println(ints);
		
		avg = nums.stream().mapToInt(n->n).filter(n->n>25).average();
		System.out.println("Avg nums>25: "+avg);
		
		OptionalInt first = nums.stream().mapToInt(n->n).skip(7).filter(n->n>25).findFirst();
		System.out.println("First: "+first);
		
		//FlatMap of IntStream
		
		IntStream flatNums = nums.stream().mapToInt(n->n).limit(10).flatMap(mapper->IntStream.of(mapper+2));
		System.out.println("Average Of New Stream: "+flatNums.average());
		
		//Statistics of IntStream
		
		IntSummaryStatistics summary = nums.stream().mapToInt(n->n).summaryStatistics();
		System.out.println(summary);
		
		boolean flag = nums.stream().mapToInt(n->n).noneMatch(predicate->predicate<0);
		System.out.println("nums<0: "+flag);
		
		List<Integer> tempList = new ArrayList<>();
		nums.stream().mapToInt(n->n).forEach(action->tempList.add(action+10));
		System.out.println(tempList);
		
		int [] arr = IntStream.generate(() -> 10).limit(5).toArray();
		System.out.println(arr);
	}
}
