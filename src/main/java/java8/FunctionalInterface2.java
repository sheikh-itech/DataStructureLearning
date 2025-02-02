package java8;

@FunctionalInterface
public interface FunctionalInterface2 /* extends FunctionalInterface1 */ {

	/*	If import allow then it will consider normal interface
	 * 	Not as functional
	 * 	Since after extend it will have 2 methods 'firstMethod' and its own
	 * 	
	 * 	Either remove 'Extend' or '@FunctionalInterface'
	 */
	public abstract void secondMethod();
}
