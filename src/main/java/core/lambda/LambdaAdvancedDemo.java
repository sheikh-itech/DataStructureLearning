package core.lambda;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class LambdaAdvancedDemo {

	/**	This class shows Chaining of Lambda Functions
	 */
	public static void main(String[] args) {

		Function<Integer, Integer> square = (x)-> x*x;
		Function<Integer, Integer> increment = (x)-> x+5;
		
		// Chain the functions to first square, then increment
        Function<Integer, Integer> squareThenIncrement = square.andThen(increment);
        
        // Chain the functions to first increment, then square
        Function<Integer, Integer> incrementThenSquare = square.compose(increment);
        
        System.out.println("Squre then increment: "+squareThenIncrement.apply(5));
        System.out.println("Increment then squre: "+incrementThenSquare.apply(5));
        
        
        //=======================================================//
        
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> longerThan5 = s -> s.length() > 5;

        Predicate<String> complexCondition = startsWithA.and(longerThan5);

        System.out.println("Starts with A AND length>5: "+complexCondition.test("ApplePie"));
        System.out.println("Starts with A AND length>5: "+complexCondition.test("APie"));
        
        Predicate<String> startWithOrLength = startsWithA.or(longerThan5);
        
        System.out.println("Starts with A OR length>5: "+startWithOrLength.test("APie"));
        
        Predicate<String> startWithAndLengthEmpty = startsWithA.and(Predicate.isEqual("AP"));
        System.out.println("Starts with A AND Equal to AP: "+startWithAndLengthEmpty.test("AP"));
        
        Predicate<String> startWithAndLengthNegate = startsWithA.and(longerThan5.negate());
        System.out.println("Starts with A AND length<5: "+startWithAndLengthNegate.test("APie"));

        Predicate<String> startWithOrLengthNot5 = startsWithA.or(Predicate.not(longerThan5));
        System.out.println("Starts with A OR Length Not >5: "+startWithOrLengthNot5.test("AP"));
        
        /*
         * We call negate() in function whereas in not() we provides function as argument
         */
        
        //=======================================================//
        
        
        /*	Currying and Partial Application	*/
        
        // A curried function that takes an initial rate and returns a function for that rate
        Function<Double, Function<Double, Double>> calculateFinalPrice = 
        		rate -> price -> price * (1 + rate);

        // Create a 10% tax function by providing rate
        Function<Double, Double> addTenPercentTax = calculateFinalPrice.apply(0.10);

        System.out.println("Price with 10% tax: "+addTenPercentTax.apply(100.0)); // Output: 110.0 (10% tax added to 100)
        
        
        /*	Higher-Order Functions	*/
        
        Function<Double, Double> tenPercentDiscount = price -> price * 0.10;
        
        // Applying the higher-order function
        Function<Double, Double> priceWithDiscount = customDiscount(tenPercentDiscount);

        System.out.println("10% Discount: "+priceWithDiscount.apply(200.0)); // Output: 180.0 (10% discount on 200)
        
        
        /*	Using Supplier for Lazy Evaluation	*/
        
        Supplier<Double> lazyValue = () -> Math.random() * 100;
        
        // Lazy evaluation happens here when get() called
        System.out.println("Generated value: " + lazyValue.get());
        
        
        /*	Memoization with Lambdas	*/
        
        // Define a single-element array to hold the lambda reference
        @SuppressWarnings("unchecked")
		final Function<Integer, Integer>[] fibonacci = new Function[1];

        // Initialize the lambda and reference itself for recursion
        fibonacci[0] = memoize(n -> n <= 1 ? n : fibonacci[0].apply(n - 1) + fibonacci[0].apply(n - 2));

        // Test the memoized Fibonacci function
        System.out.println("Fibonacci function: "+fibonacci[0].apply(10)); // Output: 55        
        
        
        /*	Consumer Chaining	*/
        
        Consumer<String> print = s -> System.out.print(s + " ");
        Consumer<String> shout = s -> System.out.print(s.toUpperCase() + " ");

        // Chaining consumers to first print and then shout
        Consumer<String> printThenShout = print.andThen(shout);

        printThenShout.accept("hello"); // Output: hello HELLO
        
        
        
        /*	UnaryOperator for Recursive Lambdas	*/
        UnaryOperator<Integer> factorial = new UnaryOperator<>() {
            @Override
            public Integer apply(Integer n) {
                return n == 0 ? 1 : n * apply(n - 1);
            }
        };

        System.out.println("Factorial of 5: "+factorial.apply(5)); // Output: 120
        
        
        /*	Usage of identity() */
        
        List<String> fruits = List.of("apple", "banana", "cherry");

        // Map each fruit to itself using identity() for values
        Map<String, String> fruitMap = fruits.stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity()));

        System.out.println("Using identity(): "+fruitMap);
	}
	
	// Higher-order function that accepts a function to apply a discount
    public static Function<Double, Double> customDiscount(Function<Double, Double> discountFunction) {
        return price -> price - discountFunction.apply(price);
    }
    
    // Helper function for memoizing results
    public static <T, R> Function<T, R> memoize(Function<T, R> func) {
        
    	Map<T, R> cache = new ConcurrentHashMap<>();
        return input -> cache.computeIfAbsent(input, func);
    }
}
