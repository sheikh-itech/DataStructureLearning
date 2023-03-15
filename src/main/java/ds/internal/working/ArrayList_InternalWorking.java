package ds.internal.working;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_InternalWorking {

	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<>();
		
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(5, 55);
		nums.add(7);
		nums.add(8);
		nums.add(9);
		
		System.out.println(nums);
	}
}
