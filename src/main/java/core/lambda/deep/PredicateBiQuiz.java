package core.lambda.deep;

import java.util.List;
import java.util.function.BiPredicate;

import core.util.NumUtil;
import core.util.StringUtil;

public class PredicateBiQuiz {

	public static void main(String[] args) {

	// 1. Check if two strings are anagrams (ignore case and spaces)

		BiPredicate<String, String> isAnagram = (a, b) -> StringUtil.isAnagram(a, b);

		System.out.println(isAnagram.test("Listen", "Silent"));

	// 2. Check if one number is a multiple of another

		BiPredicate<Integer, Integer> isMultiple = (a, b) -> a % b == 0;

		System.out.println(isMultiple.test(20, 5)); // true

	// 3. Check if two employees belong to the same department

		BiPredicate<Employee, Employee> sameDept = (e1, e2) -> e1.getDept().equals(e2.getDept());

		System.out.println(sameDept.test(
				new Employee(1, "Arham", 0.0f, "Eng"), 
				new Employee(3, "Hapheej", 0.0f, "Eng")
				));

	// 4. Check if length difference between two strings is within 3 characters

		BiPredicate<String, String> lengthClose = (s1, s2) 
				-> Math.abs(s1.length() - s2.length()) <= 3;

		System.out.println(lengthClose.test("hello", "hey")); // true

	// 5. Check if sum of two integers is a prime number

		BiPredicate<Integer, Integer> sumIsPrime = (a, b) -> NumUtil.sumOf2NumsIsPrime(a, b);

		System.out.println(sumIsPrime.test(2, 3)); // true (2+3 = 5)

	// 6. Check if two file names have the same extension

		BiPredicate<String, String> sameExtension = (f1, f2) -> f1.substring(f1.lastIndexOf("."))
				.equalsIgnoreCase(f2.substring(f2.lastIndexOf(".")));

		System.out.println(sameExtension.test("data.xml", "config.XML")); // true

	// 7. Check if two strings are palindromes of each other

		BiPredicate<String, String> palindromePair = (s1, s2) 
				-> new StringBuilder(s1).reverse().toString().equalsIgnoreCase(s2);

		System.out.println(palindromePair.test("madam", "madam")); // true
		System.out.println(palindromePair.test("god", "dog")); // false

	// 8. Check if employee’s name starts with given prefix (custom search)

		BiPredicate<Employee, String> nameStartsWith = (emp, prefix) -> emp.getName().toLowerCase()
				.startsWith(prefix.toLowerCase());

		Employee e1 = new Employee(1, "Arham", 50.0f, "Eng");

		System.out.println(nameStartsWith.test(e1, "ar"));

	// 9. Check if two employees have salaries within a certain range (e.g., ±100)

		BiPredicate<Employee, Employee> salaryClose = (em1, em2) 
				-> Math.abs(em1.getSalary() - em2.getSalary()) <= 100;

		Employee e2 = new Employee(3, "Hapheej", 24.0f, "Eng");

		System.out.println(salaryClose.test(e1, e2));

	// 10. Check if two lists have at least one common element

		BiPredicate<List<Integer>, List<Integer>> hasCommon = (l1, l2) 
				-> l1.stream().anyMatch(l2::contains);

		System.out.println(hasCommon.test(List.of(1, 2, 3), List.of(4, 2, 5))); // true
	}
}
