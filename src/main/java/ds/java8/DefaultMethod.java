package ds.java8;

/**
 * Java 8 enables us to add non-abstract method implementations 
 * to interfaces by utilizing the default keyword. 
 * This feature is also known as Extension Methods
 * @author Hapheej
 *
 */
public interface DefaultMethod {

	public double calculate(int number);
	
	default double sqrt(int number) {
		return Math.sqrt(number);
	}
}
