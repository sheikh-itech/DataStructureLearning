package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoublePredicate;

/**	Predicate-> represents boolean valued function [Used with/for filtering]
 * 	
 * 	Can used for lambda expression Or method reference
 */
public class Predicate_Double_Example {

	public static void main(String[] args) {

		double[] nums = new double[]{1, 15, 22, 6, 17, 8, 23, 4, 34, 9, 11, 10};
		
		List<Double> result = null;
		
		DoublePredicate moreThen20 = (num)-> num > 20;
		DoublePredicate lessThen10 = (num)-> num < 10;
		
		result = Arrays.stream(nums).filter(moreThen20)
				.collect(ArrayList<Double>::new, ArrayList::add, ArrayList::addAll);
		System.out.println(result);
		
		result = Arrays.stream(nums).filter(moreThen20.negate())
				.collect(ArrayList<Double>::new, ArrayList::add, ArrayList::addAll);
		System.out.println(result);
		
		result = Arrays.stream(nums).filter(lessThen10)
				.collect(ArrayList<Double>::new, ArrayList::add, ArrayList::addAll);
		System.out.println(result);
		
		result = Arrays.stream(nums).filter(lessThen10.negate().and(moreThen20.negate()))
				.collect(ArrayList<Double>::new, ArrayList::add, ArrayList::addAll);
		System.out.println(result);
	}
}
