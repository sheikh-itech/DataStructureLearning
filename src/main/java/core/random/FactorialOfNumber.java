package core.random;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class FactorialOfNumber {

	public static void main(String[] args) {

		System.out.println(factorial1(5));
		System.out.println(factorial2(5));
		System.out.println(factorial3(5));
		System.out.println(factorial4(5));
	}
	
	public static int factorial1(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
	
	public static int factorial2(int n) {
        
		if (n == 0 || n == 1) 
            return 1; // Base case
		
        return n * factorial2(n - 1); // Recursive case
    }
	
	public static int factorial3(int n) {
        
		return IntStream.rangeClosed(1, n) // Stream of numbers from 1 to n
                        .reduce(1, (a, b) -> a * b); // Multiply each element
    }
	
	public static BigInteger factorial4(int n) {
		
        BigInteger result = BigInteger.ONE;
        
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
