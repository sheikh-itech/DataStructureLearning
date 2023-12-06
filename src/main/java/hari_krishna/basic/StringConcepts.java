package hari_krishna.basic;

public class StringConcepts {

	public static void main(String[] args) {

		String []names = {"sheikh", "hapheej"};
		String name = "sheikh";
		System.out.println(names[0]==name);
		
		int []nums = {1,2,3,4,5};
		Integer []nums1 = {1,2,3,4,5};
		int num = 5;
		System.out.println(nums[4]==num);
		System.out.println(nums1[4]==num);
		
		String a = "a";
		String ab = a+"b";
		String abc = "abc";
		System.out.println(ab==abc);
	}
}
