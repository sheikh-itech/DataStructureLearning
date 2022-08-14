package ds.java8lambda;

/**
 * @author Hapheej
 *
 */
public class GenericStreamNoTypeNumberAdd {

	public static void main(String[] args) {

		Maaths<Integer> add = (x, y) -> x+y;
		System.out.println(add.process(6, 7));
		
		Maaths<Float> mult = (x, y) -> x*y;
		System.out.println(mult.process(10F, 17.5F));
		
		Maaths<Double> div = (x, y) ->{ return x>0 ? x/y : 0; };
		System.out.println(div.process(0.0, 12.5));
		
		Maaths<Integer> sub = (x, y) -> x-y;
		System.out.println(sub.process(30, 17));
		
		Maaths<String> str = (x, y) -> x+" "+y;
		System.out.println(str.process("Hapheej", "sheikh"));

	}

}

/**
 * 
 * Without Type Restrictions
 * This interface can be used for any type
 */
@FunctionalInterface
interface Maaths<T> {
	T process(T value1, T value2);
}