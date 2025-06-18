package core.lambda.deep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionBiQuiz {

	private static List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 5, 90, 12, 70, 5, 8, 19, 12));
	private static List<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 2, 5, 90, 12, 70, 5, 8, 19, 12));
	private static Map<String, Integer> map1 = new HashMap<>();
	private static Map<String, Integer> map2 = new HashMap<>();
	
	public static void main(String[] args) {
		init();
		
	// 1. Combine two strings with a hyphen in between and convert the result to uppercase
		
		BiFunction<String, String, String> combineUpper = (a, b) -> (a + "-" + b).toUpperCase();
		
		System.out.println(combineUpper.apply("arham", "Shekh"));
		
	//	2. Given two integers, return a string that shows the larger value
		
		BiFunction<Integer, Integer, String> maxAsString = (a, b) -> "Max is: " + Math.max(a, b);
		
		System.out.println(maxAsString.apply(15, 72));
		
	// 3. Given an Employee and a bonus percentage, return the new salary after applying the bonus
		
		BiFunction<Employee, Double, Double> salaryWithBonus = (e, bonus) 
				-> e.getSalary() + e.getSalary() * bonus;
		
		System.out.println(salaryWithBonus.apply(new Employee(1, "Arham", 22022, "Eng"), 1.18));
		
	// 4. Given two lists of integers, return a list of their element-wise sums
		
		BiFunction<List<Integer>, List<Integer>, List<Integer>> sumLists = (l1, l2) 
				-> IntStream.range(0, Math.min(l1.size(), l2.size()))
				.mapToObj(i -> l1.get(i) + l2.get(i)).collect(Collectors.toList());
				
		System.out.println(sumLists.apply(nums, nums1));
		
	// 5. Merge two maps by summing values of common keys
		
		BiFunction<Map<String, Integer>, Map<String, Integer>, Map<String, Integer>> mergeMaps = 
				(m1, m2) -> {
					Map<String, Integer> result = new LinkedHashMap<>(m1);
					m2.forEach((k, v) -> result.merge(k, v, Integer::sum));
					return result;
				};
				
		System.out.println(mergeMaps.apply(map1, map2));
		
	// 6. Concatenate two lists and sort the result in descending order
		
		BiFunction<List<Integer>, List<Integer>, List<Integer>> concatSortDesc = (l1, l2) 
				-> {
					l1.addAll(l2);
					l1.sort(Comparator.reverseOrder());
					return l1;
				};
		
		System.out.println(concatSortDesc.apply(nums, nums1));
		
	// 7. Find out character occurrence in given String
		
		BiFunction<String, Character, Long> countChar = (str, ch) 
				-> str.chars().filter(c -> c == ch).count();
				
		System.out.println(countChar.apply("Hello world", 'l'));
		
	// 8. Given a product price and tax rate, return the formatted price after tax (₹xx.xx)
		
		BiFunction<Double, Double, String> taxedPrice = (price, tax) 
				-> String.format("₹%.2f", price + (price * tax));
			
		System.out.println(taxedPrice.apply(24d, 0.18));
	}
	
	private static void init() {		
		map1.put("Arham", 4);
		map1.put("Fatima", 2);
		map1.put("Hapheej", 36);
		
		map2.put("Arham", 4);
		map2.put("Fatima", 2);
	}
}
