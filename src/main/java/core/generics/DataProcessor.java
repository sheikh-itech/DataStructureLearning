package core.generics;

/**		Multiple Bounded Type Parameters
 *	Java allows multiple bounds, meaning a type parameter can be constrained by more than one type
 *	When using multiple bounds, class types must be listed first, followed by interfaces
 */
public class DataProcessor<T extends Number & Comparable<T>> {

	private T data;

    public DataProcessor(T data) {
        this.data = data;
    }

    @SuppressWarnings("unchecked")
	public boolean isPositive() {
    	
        return data.compareTo((T)Integer.valueOf(0)) > 0;
    }
}
