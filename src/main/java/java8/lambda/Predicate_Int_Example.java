package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

/**	Predicate-> represents boolean valued function [Used with/for filtering]
 * 	
 * 	Can used for lambda expression Or method reference
 */
public class Predicate_Int_Example {

	public static void main(String[] args) {

		int[] nums = new int[]{1, 5, 22, 6, 7, 8, 23, 4, 34, 9, 11, 10};
		
		List<Integer> result = null;
		
		IntPredicate moreThen20 = (num)-> num > 20;
		IntPredicate lessThen5 = (num)-> num<5;
		
		result = Arrays.stream(nums).filter(moreThen20).collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
		System.out.println(result);
		
		result = Arrays.stream(nums).filter(moreThen20.or(lessThen5)).collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
		System.out.println(result);
		
		result = Arrays.stream(nums).filter(lessThen5.negate().and(moreThen20.negate())).collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
		System.out.println(result);
		
		result = Arrays.stream(nums).filter(moreThen20.negate()).collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
		System.out.println(result);
		
		System.out.println("moreThen20: "+moreThen20.test(11));
		System.out.println("moreThen20: "+moreThen20.test(21));
	}
}
