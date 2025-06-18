package core.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaBasicDemo {

	static List<String> names = Arrays.asList("John", "Jane", "Doe", "Alice");
	
	public static void main(String args[]) throws Exception {
		
		/* 1. No Parameters */
		Demo1 d1 = () -> System.out.println("Hello World from Lambda");
		d1.demo();
		
		/* 2. One Parameter */
		Demo2 d2 = x -> System.out.println(x);
		//Demo2 d2 = (x) -> System.out.println(x);
		d2.demo("Hello World from Lambda");
		
		/* 2. Multiple Parameters, [x is array of string] */
		Demo3 d3 = (x) -> {
			for(String y:x)
				System.out.print(y);
		};
		/*
		Demo3 d3 = (x) -> {
			Arrays.stream(x).forEach(System.out::print);		
		};
		*/
		d3.demo("Hello"," World"," from"," Lambda", " with"," vararg\n");
		
		/* 3. With Type Declaration */
		Demo4 d4 = (int x, int y) -> System.out.println(x+y);
		d4.demo(5, 7);
		
		
		/** Before Lambda
			 Comparator<String> comp = new Comparator<String>() {
			    @Override
			    public int compare(String s1, String s2) {
			        return s1.compareTo(s2);
			    }
			 };
		 */
		
		/* Comparator with Lambda*/
		Comparator<String> compare = (s1, s2) -> s1.compareTo(s2);
		System.out.println("Comparator: "+compare.compare("A", "B"));
		
		Comparator<Integer> comparator = (a, b) -> a - b;
		System.out.println("Comparator: "+comparator.compare(8, 2));
		
		/*
		 Callable<String> oldCallable = new Callable<String>() {
		    @Override
		    public String call() throws Exception {
		        return "Callable result";
		    }
		};
		 */
		
		/* Custom Functional Interface */
		Calculator add = (a, b) -> a + b;
		Calculator mult = (a, b) -> a * b;
		Calculator div = (a, b) -> a / b;
		System.out.println("Addition: "+add.calculate(7, 10));
		System.out.println("Multiplication: "+mult.calculate(7, 10));
		System.out.println("Division: "+div.calculate(70, 10));
		
		Predicate<String> isEmpty = s -> s.isEmpty();
		System.out.println("Empty string: "+isEmpty.test(""));
		
		Consumer<String> consumer = name -> System.out.print(name+" ");
		System.out.println("Consumer\n----------");
		names.forEach(consumer);
		
		/* Callable with Lambda*/
		Callable<String> lambdaCallable = () -> "Callable result";
		System.out.println(lambdaCallable.call());
		
		Function<String, Integer> length = s -> s.length();
		System.out.println("Length with Function: "+length.apply("Hello"));
		
		Supplier<Double> randomValue = () -> Math.random();
		System.out.println("Supplier: "+randomValue.get());
		
		BiFunction<Integer, Integer, Double> powerFunction = (x, y) -> Math.pow(x, y);
        System.out.println("BiFunction: "+powerFunction.apply(2, 3));
	}
}

//Functional Interfaces with exact 1 method

interface Demo1 {
	
	abstract void demo();
}

interface Demo2 {
	
	abstract void demo(String x);
}

interface Demo3 {
	
	abstract void demo(String... x);
}

interface Demo4 {
	
	abstract void demo(int a, int b);
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}