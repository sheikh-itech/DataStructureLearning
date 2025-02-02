package core.generics;

public class GenericFunctionalInterface {

	public static void main(String[] args) {

		Generic<Integer, Integer, Integer> sum = (x, y)-> x + y;
		Generic<Integer, Integer, Integer> mult = (x, y)-> x * y;
		Generic<String, String, String> concat = (x, y)-> x + " " + y;
		
		System.out.println(sum.test(4, 9));
		System.out.println(mult.test(4, 9));
		System.out.println(concat.test("Hello", "Hapheej"));
	}
}

@FunctionalInterface
interface Generic<T, T1, T2> {
	
	T test(T1 t1, T2 t2);
}