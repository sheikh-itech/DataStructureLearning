package core.lambda.deep;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**	Supplier<T> takes no input but returns a result of type T
 */
public class SupplierQuiz {

	private static List<Employee> emps = new ArrayList<>();
	private static List<String> fruits = new ArrayList<>();
	
	
	public static void main(String[] args) {
		init();

	// 1. Generate a constant greeting message every time

		Supplier<String> greet = () -> "Hello, World!";

		System.out.println(greet.get());

	// 2. Generate a random number between 1 and 100

		Supplier<Integer> randomNum = () -> (int) (Math.random() * 100) + 1;

		System.out.println(randomNum.get());

	// 3. Supply current timestamp

		Supplier<LocalDateTime> currentTime = () -> LocalDateTime.now();

		System.out.println(currentTime.get());

	// 4. Supply a new UUID string

		Supplier<String> newUUID = () -> UUID.randomUUID().toString();

		System.out.println(newUUID.get());

	// 5. Provide a random Employee from a list

		Supplier<Employee> randomEmp = () -> {
			return emps.get(new Random().nextInt(emps.size()));
		};

		System.out.println(randomEmp.get());

	// 6. Supply a new Employee object with default values

		Supplier<Employee> defaultEmp = () -> new Employee(0, "Default Name", 0.0f, "NA");

		System.out.println(defaultEmp.get());

	// 7. Generate a list of 5 random integers using a Supplier

		Supplier<List<Integer>> randList = () -> IntStream.range(0, 5).mapToObj(i 
				-> new Random().nextInt(100)) // nextInt(100) - value max bound
				.collect(Collectors.toList());

		System.out.println(randList.get());

	// 8. Supply a password of random 8 characters

		Supplier<String> passwordGen = () -> {
			String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			return IntStream.range(0, 8).mapToObj(i 
					-> String.valueOf(chars.charAt(new Random().nextInt(chars.length()))))
					.collect(Collectors.joining()); //.nextInt max bound
		};
		System.out.println(passwordGen.get());

	// 9. Supply today's date in dd-MM-yyyy format

		Supplier<String> dateFormat = () -> LocalDate.now()
				.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		System.out.println(dateFormat.get());

	// 10. Supply a new list of uppercased fruit names

		Supplier<List<String>> upperFruits = () -> fruits.stream().map(String::toUpperCase)
				.collect(Collectors.toList());

		System.out.println(upperFruits.get());
	}

	private static void init() {
		emps.add(new Employee(1, "Arham Shekh", 12300.5f, "Eng"));
		emps.add(new Employee(2, "Fatima Shekh", 17300.5f, "Medical"));
		emps.add(new Employee(3, "Hapheej Shekh", 2300.5f, "Eng").setActive(false));
		
		fruits.add("Apple");	fruits.add("PineApple");
		fruits.add("Banana");	fruits.add("Blackberry");
		fruits.add("Apple");	fruits.add("Mango");
		fruits.add("Guava");	fruits.add("Grape");
		fruits.add("Banana");	fruits.add("Watermelon");
	}
}
