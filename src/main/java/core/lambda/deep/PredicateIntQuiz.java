package core.lambda.deep;

import java.util.function.IntPredicate;

import core.util.NumUtil;

/* Represents a predicate (boolean-valued function) of one int-valued argument */
public class PredicateIntQuiz {

	public static void main(String[] args) {

	// 1. Check if an integer is even
		
		IntPredicate isEven = num -> num % 2 == 0;
		
		System.out.println(isEven.test(8));
		
	// 2. Check if a number is prime
	// Prime numbers are greater than 1 and divisible only by 1 and themselves
		
		IntPredicate isPrime = num -> NumUtil.isPrime(num);
		
		System.out.println(isPrime.test(5));
	
	// 3. Check if a number is in the range 10 to 100 (inclusive)
		
		IntPredicate inRange = num-> num>=10 && num<=100;
		
		System.out.println(inRange.test(20));
		
	// 4. Check if a number is a multiple of 5
		
		IntPredicate multipleOf5 = num-> num%5==0;
		
		System.out.println(multipleOf5.test(15));
		
	// 5. Check if the number is a palindrome 121-> 121
		
		IntPredicate isPalindrome = num -> NumUtil.isPalindrome(num);
		
		System.out.println(isPalindrome.test(121));
		
	// 6. Check if the number is a perfect square
	// A number is a perfect square if its square root is an integer
		
		IntPredicate isPerfectSquare = num -> Math.sqrt(num) % 1 == 0;
		
		System.out.println(isPerfectSquare.test(25));
		
	// 7. Check if a number is a power of 2
	// Bitwise trick — only powers of 2 have a single 1 in binary
	// Power of 2 => 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024
		
		IntPredicate powerOfTwo = num -> num > 0 && (num & (num - 1)) == 0;
		
		System.out.println(powerOfTwo.test(16));
		
	// 8. Check if a number contains digit 7
		
		IntPredicate hasDigit7 = num -> String.valueOf(num).contains("7");
		
		System.out.println(hasDigit7.test(2782));
		
	// 9. Check if the number is divisible by both 3 and 7
		
		IntPredicate divBy3And7 = num -> num % 3 == 0 && num % 7 == 0;
		
		System.out.println(divBy3And7.test(21));
		
	// 10. Check if number is a factorial number (e.g., 1, 2, 6, 24, 120...)
		
		IntPredicate isFactorial = num -> NumUtil.isFactorialNum(num);
		
		System.out.println("isFactorial 120: "+isFactorial.test(120));
		System.out.println("isFactorial 122: "+isFactorial.test(122));
	}
}
