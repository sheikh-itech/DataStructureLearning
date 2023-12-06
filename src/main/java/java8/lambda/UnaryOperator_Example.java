package java8.lambda;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**	Represents operation on a single operand that produces result of same type as its operand
 * 	This is a specialization of Function
 */
public class UnaryOperator_Example {

	public static void main(String[] args) {

		UnaryOperator<Boolean> op = UnaryOperator.identity();
		UnaryOperator<Test> test = UnaryOperator.identity();
		UnaryOperator<Integer> xor = a -> a ^ 1;
		UnaryOperator<Integer> and = a -> a & 1;
		
        Function<Integer, Integer> andThen = xor.andThen(and);
        Function<Integer, Integer> compose = xor.compose(and);
        
        
        System.out.println(compose.apply(231));
        
        System.out.println(andThen.apply(2));
        
        System.out.println(xor.apply(2));
        
		System.out.println(op.apply(true));
		
		System.out.println(test.apply(new Test("Arham")));
	}
}

class Test {
	String name;
	Test(String name){
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "{name: " + name + "}";
	}
}