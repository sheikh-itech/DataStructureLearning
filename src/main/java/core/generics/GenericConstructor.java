package core.generics;

/**		Generic Constructors
 * 	We can have generic constructors in a non-generic class to initialize 
 * 	objects with flexible types
 */
public class GenericConstructor {

	private Object item;

    public <T> GenericConstructor(T item) {
        this.item = item;
    }

    public void print() {
        System.out.println(item);
    }
}
