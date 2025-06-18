package core.lambda.deep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import core.util.NumUtil;

public class PredicateQuiz {

	private static Set<String> names = new HashSet<>();
	private static List<String> fruits = new ArrayList<>();
	private static List<Integer> nums = Arrays.asList(1, 2, 5, 90, 12, 70, 5, 8, 19);
	private static List<Employee> emps = new ArrayList<>();
	private static List<String> mails = new ArrayList<>();
	private static List<String> files = new ArrayList<>();
	
	public static void main(String[] args) {
		init();
		
	/* 1. Given a list of names, find all names that start with the letter ‘A’ 
	 * and have more than 3 characters
	 */
		
		Predicate<String> startWithA = str -> str.startsWith("A") && str.length()>3 ;
		fruits.forEach(f-> {
			if(startWithA.test(f))
				System.out.print(f+", ");
		});
		System.out.println();
		
		//fruits.stream().filter(startWithA).forEach(f -> System.out.print(f + ", "));

		
	/* 2. Given a list of integers, filter out all the even numbers 
	 * that are also greater than 50
	 */
		Predicate<Integer> evenNums = num -> num%2==0 && num>50;
		
		nums.forEach(n->{
			if(evenNums.test(n))
				System.out.print(n+", ");
		});
		System.out.println();
		
		//nums.stream().filter(evenNums).forEach(n -> System.out.print(n + ", "));
		
	/* 3. You have a list of strings.
	 * Find out if any string contains the word "Mango" (case insensitive)
	 */
		
		Predicate<String> specialWord = str -> str.equalsIgnoreCase("Mango") ;
		
		fruits.forEach(f-> {
			if(specialWord.test(f))
				System.out.print(f+", ");
		});
		System.out.println();
		
		/*
		boolean contains = fruits.stream().anyMatch(specialWord);
		System.out.println("Contains Mango? " + contains);
		*/
		
	/* 4. From a list of employees, get the ones whose salary > 500 and department is 'Eng' */
		
		Predicate<Employee> specialEmp = emp -> emp.getSalary()>500 && emp.getDept().equals("Eng");
		
		emps.forEach(e->{
			if(specialEmp.test(e))
				System.out.println(e);
		});
		System.out.println();
		
		//emps.stream().filter(specialEmp).forEach(System.out::println);
		
	/* 5. Check if all elements in a list of strings are non-empty and 
	 * start with an uppercase letter
	 */
		
		Predicate<String> validEle = str -> !str.isEmpty() && 
				Character.isUpperCase(str.charAt(0));

		
		fruits.forEach(f-> {
			if(validEle.test(f))
				System.out.print(f+", ");
		});
		System.out.println();
		
		/*
		 	boolean allValid = fruits.stream().allMatch(valid);
			System.out.println("All valid? " + allValid);
		 */
		
	/* 6. From a list of integers, count the elements that are prime using a predicate */
		
		Predicate<Integer> prime = num-> NumUtil.isPrime(num);
		
		nums.forEach(n->{
			if(prime.test(n))
				System.out.print(n+", ");
		});
		System.out.println();
		
	/* 7. Given a list of email addresses, 
	 * remove any invalid emails (e.g., not containing “@” and “.”)
	 */
		
		//Predicate<String> correctMail = mail-> mail.indexOf("@")>1 && mail.indexOf(".")>4;
		Predicate<String> correctMail = mail -> mail != null && 
				mail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
		mails.forEach(m->{
			if(correctMail.test(m))
				System.out.print(m+", ");
		});
		System.out.println();
		
	/* 8. From a list of file names, filter only those that end with .java or .xml 
	 * and contain no spaces
	 */
		
		Predicate<String> validFiles = str-> (str.endsWith(".java") || str.endsWith(".xml")) 
				&& !str.contains(" ");
		
		files.forEach(f->{
			if(validFiles.test(f))
				System.out.print(f+", ");
		});
		System.out.println();
		
	/* 9.  Given a list of users, check if none of them are marked as inactive */
		
		boolean noneInactive = emps.stream().noneMatch(e -> !e.isActive());
		System.out.println("All active? " + noneInactive);
		
	/* 10. From a list of strings, keep only those strings that have length between 4 and 8 
	 * (inclusive) and contain only alphabets
	 */
		Predicate<String> alphaWords = str-> str.length() >= 4 && str.length() <= 8 
				&& str.matches("^[a-zA-Z]+$");
		
		fruits.forEach(f->{
			if(alphaWords.test(f))
				System.out.print(f+", ");
		});
		System.out.println();
	}
	
	private static void init() {
		fruits.add("Apple");	fruits.add("PineApple");
		fruits.add("Banana");	fruits.add("Blackberry");
		fruits.add("Apple");	fruits.add("Mango");
		fruits.add("Guava");	fruits.add("Grape");
		fruits.add("Banana");	fruits.add("Watermelon");
		
		names.add("Arham"); names.add("Fatima"); names.add("Hapheej");
		
		emps.add(new Employee(1, "Arham", 12300.5f, "Eng"));
		emps.add(new Employee(2, "Fatima", 17300.5f, "Medical"));
		emps.add(new Employee(3, "Hapheej", 2300.5f, "Eng").setActive(false));
		
		mails.add("Arham@mail.com"); mails.add("hapheejmailcom");
		
		files.add("text1.java"); files.add("text2.xml");
		files.add("one text3.java"); files.add("two text.xml");
	}
}
