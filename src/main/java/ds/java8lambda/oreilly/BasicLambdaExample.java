package ds.java8lambda.oreilly;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import javax.swing.JButton;

/**
 * @author Hapheej
 *
 */
public class BasicLambdaExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		lambda();
		
	}
	
	public static void lambda() {
		
		/**
		 * lambda expression with no arguments at all
		 */
		Runnable noArguments = () -> System.out.println("Hello World");
		noArguments.run();
		
		/**
		 * only one argument to the lambda expression,
		 * which lets us leave out the parentheses around the arguments
		 */
		ActionListener oneArgument = event -> System.out.println("button clicked");
		oneArgument.actionPerformed(null);
		
		/**
		 * Instead of the body of the lambda expression being just an expression,
		 * in it’s a full block of code, bookended by curly braces ({})
		 * These code blocks follow the usual rules that you would expect from a method.
		 * For example, you can return or throw exceptions to exit them.
		 */
		Runnable multiStatement = () -> {
		System.out.print("Hello");
		System.out.println(" World");
		};
		multiStatement.run();
		
		BinaryOperator<Long> add = (x, y) -> x + y;
		add.apply(5L, 10L);
		
		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
		System.out.println("BinaryOperator: "+ addExplicit.apply(20L, 30L));
		//addExplicit(29L, 48L);
		
		//Effectively final variable in Lambda Expression
		String name = "Hapheej Sheikh";
		ActionListener button = event -> System.out.println("hi " + name);
		button.actionPerformed(null);
		
		//Predicate—a functional interface that checks whether something is true or false
		Predicate<Integer> atLeast5 = x -> x > 5;
		System.out.println(atLeast5.test(5));
		
		CustomIntPred intPred = x -> x%2==0;
		System.out.println("Custom IntPred: " + intPred.test(7));
		
		//CustomIntPred1 intPred2 = z -> z%2==0;	--> Operator not defined for argument z
		CustomIntPred1<Integer> intPred1 = y -> y%2==0;
		System.out.println("Custom IntPred: " + intPred1.test(7));
		
		JButton button1 = new JButton();
		button1.addActionListener(event ->
		System.out.println(event.getActionCommand()));
		
		
		effectivelyFinal(name);
	}
	
	public static void effectivelyFinal(final String name) {
		System.out.println("Effectively final name: "+name);
	}

}

interface CustomIntPred {
	boolean test(Integer value);
}

interface CustomIntPred1<T> {
	boolean test(T value);
}
