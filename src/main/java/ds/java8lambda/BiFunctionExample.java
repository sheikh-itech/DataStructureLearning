package ds.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * 	Only 2 methods-> accept(T1, T2), andThen(BiConsumer)
 * 	
 * 	Takes 2 input, Returns Value [produces a result]
 */
public class BiFunctionExample {

	public static void main(String[] args) {

		List<Integer> nums1 = getIntList();
		List<Integer> nums2 = getIntList();
		BiFunction<List<Integer>, List<Integer>, List<Integer>> addList = 
		(t1, t2)->{
			List<Integer> temp = new ArrayList<>();
			for(int i=0;i<t1.size()&&i<t2.size(); i++) {
				temp.add(t1.get(i)+t2.get(i));
			}
			
			return temp;
		};
		List<Integer> temp = addList.apply(nums1, nums2);
		System.out.println(temp);
		
		BiFunction<Integer, Integer, Integer> add = (t1, t2)->t1+t2;
		add = add.andThen(a->a*2);
		System.out.println(add.apply(5, 7));
		
		
	}
	
	private static List<Integer> getIntList(){
		
		List<Integer> nums = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			nums.add(i);
		}		
		return nums;
	}
}
