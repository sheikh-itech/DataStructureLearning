package core.lambda.deep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerQuiz {

	private static Set<String> names = new HashSet<>();
	private static List<String> fruits = new ArrayList<>();
	private static List<Integer> nums = Arrays.asList(1, 2, 5, 90, 12, 70, 5, 8, 19);
	private static List<Employee> emps = new ArrayList<>();
	private static List<String> mails = new ArrayList<>();
	private static List<String> files = new ArrayList<>();
	private static List<Double> dbls = new ArrayList<>();

	public static void main(String[] args) {
		init();

	// 1. Print each fruit from a list using a Consumer

		Consumer<String> printFruit = fruit -> System.out.print(fruit+", ");
		fruits.forEach(printFruit);
		System.out.println();

	// 2. Print square of each number from a list

		Consumer<Integer> squarePrint = num -> System.out.print(num * num + ", ");
		nums.forEach(squarePrint);
		System.out.println();
		
	// 3. Display full name and department of each employee

		Consumer<Employee> empInfo = emp 
				-> System.out.println(emp.getName() + " - " + emp.getDept());
		emps.forEach(empInfo);

	// 4. Print length of each file name

		Consumer<String> fileLength = file 
				-> System.out.println(file + " -> " + file.length());
		files.forEach(fileLength);

	// 5. Convert all elements in a list to uppercase in-place

		Consumer<List<String>> toUpper = list -> {
			for (int i = 0; i < list.size(); i++)
				list.set(i, list.get(i).toUpperCase());
		};
		toUpper.accept(fruits);
		System.out.println(fruits);

	// 6. Log email addresses containing "admin"

		Consumer<String> adminLogger = mail -> {
			if (mail.contains("admin"))
				System.out.println("Admin Email: " + mail);
		};

		mails.forEach(adminLogger);

	// 7. Add a prefix to every file name and print

		Consumer<String> prefixFile = name -> System.out.println("FILE_" + name);
		files.forEach(prefixFile);

	// 8. Use BiConsumer to print Employee name and salary

		BiConsumer<String, Float> empPay = (name, salary) 
				-> System.out.println(name + " earns ₹" + salary);

		emps.forEach(e -> empPay.accept(e.getName(), e.getSalary()));

	// 9. BiConsumer: Print each map entry in "key=value" format

		Map<String, Integer> stock = Map.of("Apple", 10, "Banana", 5);
		
		BiConsumer<String, Integer> printEntry = (k, v) -> System.out.println(k + "=" + v);
		stock.forEach(printEntry);

	// 10. Consumer: Format and print list of currency amounts

		Consumer<Double> printCurrency = val 
				-> System.out.print(String.format("₹%.2f", val)+", ");

		dbls.forEach(printCurrency);
	}

	private static void init() {
		fruits.add("Apple");	fruits.add("PineApple");
		fruits.add("Banana");	fruits.add("Blackberry");
		fruits.add("Apple");	fruits.add("Mango");
		fruits.add("Guava");	fruits.add("Grape");
		fruits.add("Banana");	fruits.add("Watermelon");

		names.add("Arham");	names.add("Fatima");
		names.add("Hapheej");

		emps.add(new Employee(1, "Arham", 12300.5f, "Eng"));
		emps.add(new Employee(2, "Fatima", 17300.5f, "Medical"));
		emps.add(new Employee(3, "Hapheej", 2300.5f, "Eng").setActive(false));

		mails.add("Arham@mail.com");
		mails.add("hapheejmailcom");

		files.add("text1.java");	files.add("text2.xml");
		files.add("one text3.java");	files.add("two text.xml");
		
		dbls.add(10.3); dbls.add(15.2); dbls.add(11.9);
		dbls.add(10.8); dbls.add(19.6); dbls.add(8.4);
	}
}
