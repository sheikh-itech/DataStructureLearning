package java8lambda;

public class GenericStreamTypeNumberAdd {

	public static void main(String[] args) {

		Add<Integer> add = (x, y) -> x+y;
		System.out.println(add.process(10, 20));
		
		Add<Float> mult = (x, y) -> x*y;
		System.out.println(mult.process(10F, 20.5F));
		
		Add<Double> div = (x, y) ->{ return x>0 ? x/y : 0; };
		System.out.println(div.process(0.0, 20.5));
		
		Add<Integer> sub = (x, y) -> x-y;
		System.out.println(sub.process(0, 20));
		
		int num1=0;
		double num2=0.0;
		System.out.println(num1>num2); //false
		System.out.println(num2>num1); //false
		
		Adds<Number> adds = (Number[] arg) -> {
			long sum=0L;
			for(Number o:arg) {
				sum=sum+Long.valueOf(o.toString());
			}
			return sum;
		};

		System.out.println(adds.goOn(1,2));
		System.out.println(adds.goOn(1,2,3,4,5,6,7,8,9,10));
	}

}

/**
 * 
 * With Type Restrictions
 * This interface can be used for any Number type and its subclasses
 */
@FunctionalInterface
interface Add<I extends Number> {
	I process(I value1, I value2);
}

@FunctionalInterface
interface Adds<T extends Number> {
	T goOn(T ...value);
}