package ds.java8;

/**
 * @author Hapheej
 *
 */
public class DefaultMethodImpl {

	public static void main(String[] args) {

		DefaultMethod dflt = new DefaultMethod() {
			
			@Override
			public double calculate(int number) {
				
				return Math.sqrt(number*10);
			}
		};
		
		System.out.println(dflt.calculate(5));
		System.out.println(dflt.sqrt(10));
	}
}
