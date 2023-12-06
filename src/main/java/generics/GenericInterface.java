package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericInterface implements Generic<Integer> {

	private static List<Integer> nums;
	
	public static void main(String[] args) {

		nums = new ArrayList<>();
		GenericInterface ins = new GenericInterface();
		ins.add(10);
		ins.add(20);
		System.out.println(nums);
	}

	@Override
	public void add(Integer t) {
		nums.add(t);
	}

}

interface Generic<T> {
	
	public void add(T t);
}