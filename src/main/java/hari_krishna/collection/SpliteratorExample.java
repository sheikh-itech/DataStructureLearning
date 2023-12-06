package hari_krishna.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 *	It support parallel processing of stream of elements for any collection
 *	tryAdvance() method to iterate elements individually in different threads,
 *	It helps in parallel processing
 *	To iterate elements sequentially in a single Thread
 *	The trySplit() method is used partition the spliterator, if it is possible
 */

public class SpliteratorExample {

	
	public static void main(String []args) {
		
		int expected = Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
		
		List<Integer> nums = new ArrayList<>();
		fillList(nums);
		
		Spliterator<Integer> spl1 = nums.spliterator();
		
		Spliterator<Integer> spl2 = spl1.trySplit();

		System.out.println("expected: "+expected+":: "+(spl1.characteristics()==expected));
		System.out.println("estimateSize(): "+spl1.estimateSize());
		System.out.println("getExactSizeIfKnown(): "+spl1.getExactSizeIfKnown());
		
		spl1.forEachRemaining(action->System.out.print(action+", "));
		System.out.println();
		spl1.forEachRemaining(action->System.out.print(action+", "));
		System.out.println("\ndone");
		
	}
	
	private static void fillList(List<Integer> nums) {
		
		for(int i=0; i<99; i++) {
			nums.add(i);
		}
	}
}
