package core.util;

public class NumUtil {

	// Prime numbers are numbers that have exactly 2 factors: 1 and themselves
	// 2, 3, 5, 7, 11 [0 & 1 not counted]
	public static boolean isPrime(int num) {
		
		if (num < 2) 
			return false;
		
		if (num == 2)
	    	return true;
	    
	    if (num % 2 == 0)
	    	return false;
		
	    for (int i = 2; i <= num / 2; i++)
	        if (num % i == 0)
	        	return false;
	    
	    return true;
	}
	
	// Number that remains the same when its digits are reversed 121-> 121
	public static boolean isPalindrome(int num) {
	
		int rev = 0, n = num;
	    while (n > 0) {
	        rev = rev * 10 + n % 10;
	        n /= 10;
	    }
	    return rev == num;
	}
	
	// 1 is 1!, 6 is 3!, 24 is 4!, 120 is 5!
	public static boolean isFactorialNum(int num) {
		
		int fact = 1, i = 1;
		
	    while (fact < num)
	    	fact = fact * ++i;    // factorial logic 
	    	
	    return fact == num;
	}
	
	public static boolean sumOf2NumsIsPrime(int num1, int num2) {
		
		int sum = num1 + num2;
		
	    if (sum < 2)
	    	return false;
	    
	    for (int i = 2; i <= sum / 2; i++)
	        if (sum % i == 0) 
	        	return false;
	    
	    return true;
	}
	
	public static void main(String args[]) {
		System.out.println(isPrime(11));
	}
}
