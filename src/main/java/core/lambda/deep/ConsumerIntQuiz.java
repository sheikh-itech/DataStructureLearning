package core.lambda.deep;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ConsumerIntQuiz {

	public static void main(String[] args) {

		int factor = 3;
		
		IntConsumer square = x -> System.out.println(x * x + " ");
        square.accept(5);
        
        IntConsumer multiply = x -> System.out.println(x * factor);
        multiply.accept(4);
        
        
    // andThen method
        
        System.out.println("----andThen----");
        multiply.andThen(square).accept(7);
        
        
        AtomicInteger ai = new AtomicInteger(10);
        
        IntConsumer counter = x -> {
        	ai.set(ai.get()+x);
            System.out.println(ai.get());
        };
        counter.accept(5);
        
        //IntConsumer adder = x -> total += x; variable total must be final or effectively final
        
        IntConsumer consumer = System.out::println;
        consumer.accept(123);
        
        IntConsumer printer = i -> System.out.print(i + "-");
        IntStream.range(1, 4).forEach(printer);
	}
}
