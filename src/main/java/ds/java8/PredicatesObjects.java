package ds.java8;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicatesObjects {

	public static void main(String[] args) {
		
		Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(predicate.test("sheikh"));
		Predicate<Object> nonNull = Objects::nonNull;
		System.out.println(nonNull.test(new Test("sheikh")));
		
		Predicate<String> isEmpty = String::isEmpty;
		System.out.println(isEmpty.test(""));
	}
}

class Test{
	String name;
	Test(String name){
		this.name=name;
	}
}