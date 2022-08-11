package ds.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * 	Only 2 methods-> accept(T1, T2), andThen(BiConsumer)
 * 	
 * 	Takes 2 input, Returns Nothing
 */

public class BiConsumerExample {

	public static void main(String[] args) {

		List<Integer> nums1 = getIntList();
		List<Integer> nums2 = getIntList();
		
		BiConsumer<List<Integer>, List<Integer>> addList = (t1, t2)
		-> {
				t1.addAll(t2);
		};
		addList.accept(nums1, nums2);

		BiConsumer<List<Integer>, List<Integer>> print = (t1, t2)
		-> {
				t1.stream().forEach(action->System.out.println(action));
				t2.stream().forEach(action->System.out.println(action));
		};
		
		addList.andThen(print).accept(nums1, nums2);
		
		appendChars("SHEIKH".toCharArray(), "hapheej".toCharArray());
		
	}
	
	private static void appendChars(char[] c1, char[]c2) {
		
		BiConsumer<char[], char[]> appendChars = (t1, t2)
		-> {
				char[] temp = new char [t1.length+t2.length+2];
				int min = t1.length<t2.length?t1.length:t2.length;
				int count=0;
				for(int i=0; i<min; i++) {
					temp[count++]=t1[i];
					temp[count++]=t2[i];
					
					if(i==t1.length-1) {
						for(int j=min; j<t2.length; j++)
							temp[count++]=t2[j];
					} else if(i==t2.length-1){
						for(int j=min; j<t1.length; j++)
							temp[count++]=t1[j];
					}
				}
				System.out.println(temp);
		};
		
		appendChars.accept(c1, c2);
	}
	
	private static List<Integer> getIntList(){
		
		List<Integer> nums = new ArrayList<Integer>();
		for(int i=0; i<50; i++) {
			nums.add(i);
		}		
		return nums;
	}
}
