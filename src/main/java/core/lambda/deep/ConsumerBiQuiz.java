package core.lambda.deep;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ConsumerBiQuiz {

	private static List<Employee> emps = new ArrayList<>();
	
	public static void main(String[] args) {
		init();
		
	// 1. Use BiConsumer to print Employee name and salary

		BiConsumer<String, Float> empPay = (name, salary) 
				-> System.out.println(name + " earns ₹" + salary);

		emps.forEach(e -> empPay.accept(e.getName(), e.getSalary()));

	// 9. BiConsumer: Print each map entry in "key=value" format

		Map<String, Integer> stock = Map.of("Apple", 10, "Banana", 5);
		
		BiConsumer<String, Integer> printEntry = (k, v) -> System.out.println(k + "=" + v);
		stock.forEach(printEntry);

	}
	
	private static void init() {

		emps.add(new Employee(1, "Arham", 12300.5f, "Eng"));
		emps.add(new Employee(2, "Fatima", 17300.5f, "Medical"));
		emps.add(new Employee(3, "Hapheej", 2300.5f, "Eng").setActive(false));
	}
}
