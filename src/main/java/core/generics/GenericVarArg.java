package core.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVarArg {

	public static void main(String[] args) {

		printAll("A", "B", "C");
        printAll(1, 2, 3);

        
        List<Object> list = new ArrayList<>();
        list.add(12);
        list.add("Shekh");
        
        
        GenericVarArg obj = new GenericVarArg();
       
        obj.safer(list);
        
        obj.unsafe(1, 2);
	}

	@SafeVarargs
    public static <T> void printAll(T... items) {
        for (T item : items) {
        	System.out.println(item);
        }
    }
	
	//@SafeVarargs, Only allowed for static or final methods (and private constructors)
	public <T> void unsafe(T... items) {
	    Object[] array = items;
	    array[0] = "This is not type-safe!";
	    T item = items[0];  // May cause ClassCastException at runtime
	}
	
	public <T> void safer(List<T> items) {
	    for (T item : items) {
	        System.out.println(item);
	    }
	}
}
