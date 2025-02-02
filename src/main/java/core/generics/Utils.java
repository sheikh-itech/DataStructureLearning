package core.generics;

import java.util.List;

public class Utils {

	public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element+", ");
        }
    }
	
	//Upper Bound Wildcard
	public static void printNumbers(List<? extends Number> list) {
	    for (Number n : list) {
	        System.out.print(n+", ");
	    }
	}
}
