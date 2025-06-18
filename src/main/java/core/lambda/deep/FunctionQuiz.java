package core.lambda.deep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionQuiz {

	private static Set<String> names = new HashSet<>();
	private static List<String> fruits = new ArrayList<>();
	private static List<Integer> nums = Arrays.asList(1, 2, 5, 90, 12, 70, 5, 8, 19);
	private static List<Double> dbls = new ArrayList<>();
	private static List<Employee> emps = new ArrayList<>();
	private static List<String> mails = new ArrayList<>();
	private static List<String> files = new ArrayList<>();
	
	public static void main(String[] args) {
		init();
		
	// 1. Convert a list of strings to their lengths
		
		Function<String, Integer> wordToLength = str -> str.length();
		
		List<Integer> res = fruits.stream().map(wordToLength)
				.collect(Collectors.toList());
		
		//fruits.stream().map(String::length).collect(Collectors.toList()); inline Function
		
		System.out.println(res);
		
		/* fruits.forEach(f -> {
			nums.add(wordToLength.apply(f));
		}); */
		
	// 2. From List<Employee>, convert all employee names to uppercase List<String>
		
		Function<Employee, String> empToUpperCase = emp -> emp.getName().toUpperCase();
		
		List<String> empNames = emps.stream().map(empToUpperCase)
				.collect(Collectors.toList());
		
		System.out.println(empNames);
		
		// OR
		
		Function<List<Employee>, List<String>> empTNameLst = emp -> {
			
			List<String> l = new ArrayList<>();
			
			emp.forEach(e-> l.add(e.getName().toUpperCase()));
			
			return l;
		};
		System.out.println(empTNameLst.apply(emps));
		
	// 3. From List<String>, return Map<String, String> where each value is the reversed string
		
		Function<String, String> revMap = str -> new StringBuilder(str).reverse().toString();
		
		Map<String, String> fruitsRevMap = fruits.stream()
				.collect(Collectors.toMap(
						Function.identity(),
						revMap,
						(v1, v2) -> v1,               // Keep first duplicate
				        LinkedHashMap::new            // Preserve insertion order
					));
		System.out.println(fruitsRevMap);
		
	// 4. Convert List<Double> into List<Integer> by rounding each number
		
		Function<Double, Integer> numConvert = d-> (int)Math.round(d);
		
		List<Integer> intLst = dbls.stream().map(numConvert).collect(Collectors.toList());
		
		System.out.println(intLst);
		
	/* 5. From List<Employee>, 
	 * return Map<Integer, String> where key = emp.getId() and value = full name
	 */
		
		Function<Employee, Integer> empToId = emp -> emp.getId();
		
		Map<Integer, String> empIdName = emps.stream()
				.collect(Collectors.toMap(empToId, empToUpperCase));
		
		System.out.println(empIdName);
		
	// 6. Given List<String>, return new list with all spaces replaced by _
		
		Function<String, String> spaceToUnder = str-> str.replace(' ', '_');
		
		List<String> newFiles = files.stream().map(spaceToUnder).collect(Collectors.toList());
		
		System.out.println(newFiles);
		
	// 7. Given List<Integer>, return list of their squares
		
		Function<Integer, Integer> numSquare = num -> num*num;
		
		List<Integer> newNums = nums.stream().map(numSquare).collect(Collectors.toList());
		
		System.out.println(newNums);
		
	// 8. Given List<String>, return a list of file extensions (e.g., .txt, .java)
		
		Function<String, String> fileExe = str
				-> str.contains(".") ? str.substring(str.lastIndexOf(".")) : "";
		
		List<String> fileNames = files.stream().map(fileExe).collect(Collectors.toList());
		
		System.out.println(fileNames);
		
	// 9. Get initials of employee names, Arham Shekh -> A.S.
		
		Function<Employee, String> initials = str -> {
			
			String[] s = str.getName().split(" ");
			String out="";
			for(int i=0; i<s.length; i++)
				out += s[i].charAt(0)+".";

			return out;
		};
		
		Function<Employee, String> initials1 = emp -> {
		    return Arrays.stream(emp.getName().split(" "))
		                 .map(s -> s.substring(0, 1).toUpperCase())
		                 .collect(Collectors.joining(".")) + ".";
		};
		
		List<String> shortNames = emps.stream().map(initials).collect(Collectors.toList());
		
		System.out.println(shortNames);
		
		shortNames = emps.stream().map(initials1).collect(Collectors.toList());
		
		System.out.println(shortNames);
		
	// 10. Convert list of numbers to a formatted currency string 200.25 -> ₹200.25
		
		Function<Double, String> currency = val -> String.format("₹%.2f", val);
		
		List<String> realCurrency = dbls.stream().map(currency).collect(Collectors.toList());
		
		System.out.println(realCurrency);
	}
	
	private static void init() {
		fruits.add("Apple");	fruits.add("PineApple");
		fruits.add("Banana");	fruits.add("Blackberry");
		fruits.add("Apple");	fruits.add("Mango");
		fruits.add("Guava");	fruits.add("Grape");
		fruits.add("Banana");	fruits.add("Watermelon");
		
		names.add("Arham"); names.add("Fatima"); names.add("Hapheej");
		
		emps.add(new Employee(1, "Arham Shekh", 12300.5f, "Eng"));
		emps.add(new Employee(2, "Fatima Shekh", 17300.5f, "Medical"));
		emps.add(new Employee(3, "Hapheej Shekh", 2300.5f, "Eng").setActive(false));
		
		mails.add("Arham@mail.com"); mails.add("hapheejmailcom");
		
		files.add("text1.java"); files.add("text2.xml");
		files.add("one text3.java"); files.add("two text.xml");
		
		dbls.add(10.3); dbls.add(15.2); dbls.add(11.9);
		dbls.add(10.8); dbls.add(19.6); dbls.add(8.4);
	}
}
