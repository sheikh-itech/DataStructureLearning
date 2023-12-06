package leetcode.basic;

public class ArrayScenarios {

	public static void main(String[] args) {
	
		/**	Given array of integers nums and an integer target, 
		 * 	return indices of the two numbers such that they add up to target.
		 * 	Each input have exactly one solution & not use same element twice.
		 * 	Input: nums = [2,7,11,15], target = 9
		 * 	Output: [0,1]
		 */
		int arr[] = {3,2,3};
		scenario1(arr, 6);
	}
	
	public static int[] scenario1(int[] nums, int target) {
		
		for(int i=0; i<nums.length; i++) {
			for(int j=1; j<nums.length; j++) {
				if(i!=j &&(nums[i]+nums[j]==target))
					System.out.println("["+i+", "+j+"]");
			}
		}
		return null;
	}

}
