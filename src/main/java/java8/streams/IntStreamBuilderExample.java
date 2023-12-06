package java8.streams;

import java.util.stream.IntStream;

public class IntStreamBuilderExample {

	public static void main(String[] args) {

		IntStream stream = IntStream.builder().add(5).add(7).add(9).build();
		stream.forEach(c->System.out.println(c));
		
		IntStream.builder().add(5).add(7).add(9).build().average().ifPresent(System.out::println);

	}
}
