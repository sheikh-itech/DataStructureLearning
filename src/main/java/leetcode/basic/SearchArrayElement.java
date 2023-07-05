package leetcode.basic;

import java.util.ArrayList;
import java.util.List;

/**	Given an integer array nums where every element appears three times except for one, 
 * 	which appears exactly once. Find the single element and return it.
 * 	You must implement a solution with a linear runtime complexity and 
 * 	use only constant extra space
 */

public class SearchArrayElement {

	public static void main(String[] args) {
		
        int[] nums = {2, 2, 3, 2, 3, 3, 5, 0, 0, 1, 0, 1, 1,6,7};
        
        int singleElement = singleNumber(nums);
        System.out.println("Unique/Single element: " + singleElement);
        
        singleElement = advSingleNumber(nums);
        System.out.println("Unique/Single element: " + singleElement);
        
        List<Integer> result = singleNumberString(nums);
        System.out.println("Unique/Single element: " + result);
    }
	
	private static List<Integer> singleNumberString(int[]nums) {
		List<Integer> result = new ArrayList<>();
		int max=0;
		String numStr="";
		for(int num: nums) {
			numStr += num;
			max=num>max?num:max;
		}
		
		for(int i=0; i<=max; i++) {
			int orgLen = numStr.length();
			int len = numStr.replaceAll(i+"", "").length();
			if(orgLen-len<3 && orgLen-len>0)	
				result.add(i);
		}
		return result;
	}
	
	public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
	
	public static int advSingleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int commonBits;
        
        for (int num : nums) {
            // Update twos by adding the common bits between twos and the current number
            twos |= (ones & num);
            
            // Update ones by XORing it with the current number
            ones ^= num;
            
            // Calculate the common bits between ones and twos
            commonBits = ~(ones & twos);
            
            // Remove the common bits from ones and twos
            ones &= commonBits;
            twos &= commonBits;
        }
        
        return ones;
    }
}
