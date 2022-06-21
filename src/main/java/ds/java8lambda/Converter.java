package ds.java8lambda;

/**
 * @author Hapheej
 *
 */
public class Converter {


	public static void main(String[] args) {

		Convert<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer value = converter.convert("12345");
		System.out.println(value);
		
		Convert<String, Integer> converter1 = Integer::valueOf;
		System.out.println(converter1.convert("123456"));
	}

}

@FunctionalInterface
interface Convert<F, T> {
    T convert(F from);
}
