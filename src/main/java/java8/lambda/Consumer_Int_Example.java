package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

/**	Process only single int, not list, or other object
 */
public class Consumer_Int_Example {

	public static void main(String[] args) {

		
		IntConsumer mul = num -> System.out.println(num*5);
		
		IntConsumer div = num -> System.out.println(num/2);
		
		IntConsumer mediator = num -> mul.andThen(div);
		
		IntConsumer mediatorAccept = num -> mul.andThen(div).accept(num);
		
		mul.accept(5);
		div.accept(26);
		
		System.out.println();
		
		mediator.accept(12);
		mediatorAccept.accept(12);
		
		List<Integer> nums = new ArrayList<>();
		
		IntConsumer multi = num -> nums.add(num*5);
		IntConsumer divide = num -> nums.add(num/2);
		IntConsumer mediator1 = num -> multi.andThen(divide);
		IntConsumer mediator2 = num -> multi.andThen(divide).accept(num);
		
		multi.accept(13);
		divide.accept(14);
		mediator1.accept(12);
		mediator2.accept(12);
		
		System.out.println("\n"+nums);
	}
}
