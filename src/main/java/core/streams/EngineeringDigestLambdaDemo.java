package core.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**	Added Functional Programming Feature in Java 8 [Minimal code, Functional Programming]
 * 	Java 8-> Streams, Lambda, Date & Time API
 * 
 * 		Lambda
 * 	Anonymous function, only expressions, no return type, no access modifier
 * 	Lambda expression used to implement Functional Interface
 */
public class EngineeringDigestLambdaDemo {

	public static void main(String[] args) {
		

		
		//Streams-> Method & Constructor Reference, Lambdas, Functional Interface
		
	//	Lambda
		
		Thread t1 = new Thread(new Task());
		
		Thread t2 = new Thread(()-> {
			System.out.println("Using Lambda");
		});
		
		t1.start();
		t2.start();
		
		Generic<Integer, Integer, Integer> sum = (x, y)-> x + y;
		Generic<Integer, Integer, Integer> mult = (x, y)-> x * y;
		Generic<String, String, String> concat = (x, y)-> x + " " + y;
		
		System.out.println(sum.test(4, 9));
		System.out.println(mult.test(4, 9));
		System.out.println(concat.test("Hello", "Hapheej"));
		
		
	//	1. Predicate
		Predicate<Integer> isEven = x -> x%2==0;
		System.out.println("is 6 even: "+isEven.test(6));
		
		Predicate<String> startWithH = x -> x.toLowerCase().startsWith("a");
		Predicate<String> endsWithH = x -> x.toLowerCase().endsWith("m");
		Predicate<String> and = startWithH.and(endsWithH);
		
		System.out.println("Hapheej starts with 'a' and ends with 'm': "+and.test("Hapheej"));
		System.out.println("Arham starts with 'a' and ends with 'm': "+and.test("Arham"));
		
		
	//	2. Function
		
		Function<Integer, Integer> square = x -> x*x;
		Function<Integer, Integer> tripple = x -> x*3;
		Function<Integer, Integer> identity = Function.identity();	//Returns same value
		
		System.out.println(square.andThen(tripple).apply(2));	//Fist square
		System.out.println(square.compose(tripple).apply(2));	//First tripple
		System.out.println(square.apply(3));
		System.out.println(identity.apply(5));
	
		
	//	3. Consumer
		
		Consumer<String> print1 = x -> System.out.println("Welcome mr. "+x);
		
		Consumer<List<Integer>> print2 = x -> {
			x.forEach(ele->System.out.print(ele+", "));
		};
		
		print1.accept("Hapheej");
		print2.accept(Arrays.asList(1, 2, 3, 4, 5));
		
		System.out.println();
		
	//	3. Supplier
		
		Supplier<String> hello = () -> "Hello ";
		
		System.out.println(hello.get() + "Hapheej");
		
		// Combined example
		
		Supplier<Integer> supplier = () -> 6;
		Predicate<Integer> predicate = x -> x%2==0;
		Function<Integer, Integer> function = x -> x*x;
		Consumer<Integer> consumer = (x)->System.out.println("Even num square: "+x);
		
		if(predicate.test(supplier.get()))
			consumer.accept(function.apply(supplier.get()));
		
	// BiPredicate, BiFunction, BiConsumer
		
		BiPredicate<Integer, Integer> x1 = (x, y) -> x%y==0;
		
		System.out.println(x1.test(6, 2));
		
		BiFunction<Integer, Integer, Integer> x2 = (x, y) -> x*y;
		
		System.out.println(x2.apply(5, 7));
		
		BiConsumer<String, Integer> x3 = (x, y)->System.out.println(x+y);
		
		x3.accept("Even number: ", 10);
		
		/* Not to define data type twice as in Function & BiFunction and others */
		
		UnaryOperator<Integer> u1 = x->x*x;
		BinaryOperator<Integer> b1 = (x, y)-> x+y;
		
		System.out.println(u1.apply(5));
		System.out.println(b1.apply(5, 4));	//Defined 1 parameter type in definition
		
	//	Method reference using Lambda
		
		List<String> nums = Arrays.asList("Apple", "Banana", "Papaya");
		
		//	forEach is consumer lambda function
		nums.forEach(num->System.out.print(num+", "));
		System.out.println();
		
		
//	Method Reference
		nums.forEach(System.out::println);
		
		
//	Constructor Reference	-> .map(x-> new Mobile(x)) OR .map(Mobile::new)
		
		List<String> names = Arrays.asList("Apple", "One+", "Samsung");
		
		//List<Mobile> mobiles = names.stream().map(x-> new Mobile(x)).collect(Collectors.toList());
		
		List<Mobile> mobiles = names.stream().map(Mobile::new).collect(Collectors.toList());
		
		System.out.println(mobiles);
	}
}



class Mobile {
	
	private String name;

	public Mobile(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Mobile [name: " + name + "]";
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Using regular class");	
	}
}

@FunctionalInterface
interface Generic<T, T1, T2> {
	
	T test(T1 t1, T2 t2);
}
