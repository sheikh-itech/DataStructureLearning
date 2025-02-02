package core.generics;

import java.util.Arrays;

public class GenericsDemo {

	public static void main(String[] args) {

		String[] names = {"Alice", "Bob", "Carol"};
		Integer[] numbers = {1, 2, 3, 4, 5};
		
		//1. Generic Class/Interface
		
		Box<Integer> integerBox = new Box<>();
		integerBox.set(123);
		System.out.println("Num box: "+integerBox.get());
		
		Box<String> stringBox = new Box<>();
		stringBox.set("Black box");
		System.out.println("String box: "+stringBox.get());
		
		NumberBox<Integer> boundedBox = new NumberBox<>();
		boundedBox.set(250);
		System.out.println("Bounded Num box: "+boundedBox.get());
		
		
		//2. Generic Method
		
		Utils.printArray(names);
		System.out.println();
		Utils.printNumbers(Arrays.asList(numbers));
		System.out.println();
		
		//Multiple Bounded Type Parameters
		DataProcessor<Integer> processor = new DataProcessor<>(10);
		System.out.println(processor.isPositive());
		
		//Generic Interfaces
		Storage<String> storage = new ListStorage<>();
		storage.add("Generics");
		System.out.println(storage.get(0));
		
		//Custom Generic Collection with Iterable Interface
		GenericStack<String> stack = new GenericStack<>();
		stack.push("Java");
		stack.push("Generics");
		for (String item : stack) {
		    System.out.print(item+", ");
		}
		System.out.println();
		
		//Self-Bounded Types
		StringComparableBox box1 = new StringComparableBox("Test");
		StringComparableBox box2 = new StringComparableBox("Test");
		System.out.println(box1.isEqual(box2));
		
		//Generic Constructors
		GenericConstructor stringPrinter = new GenericConstructor("Hello, Generics!");
		GenericConstructor integerPrinter = new GenericConstructor(123);
		stringPrinter.print();
		integerPrinter.print();
	}
}
