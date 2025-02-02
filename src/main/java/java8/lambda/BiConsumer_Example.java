package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**	Accepts two input arguments and returns no result
 * 	This is the two-arity specialization of Consumer
 */
public class BiConsumer_Example {

	public static void main(String[] args) {

		BiConsumer<Integer, Integer> con = (x, y)-> System.out.println(x+y);
		
		con.accept(10, 7);
		
		// Create the first list
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(2);
        lista.add(1);
        lista.add(3);
        // Create the second list
        List<Integer> listb = new ArrayList<Integer>();
        listb.add(2);
        listb.add(1);
        listb.add(2);
        
        BiConsumer<List<Integer>, List<Integer> >
        equals = (list1, list2) ->
        {
	        if (list1.size() != list2.size()) {
	            System.out.println("False");
	        }
	        else {
	            for (int i = 0; i < list1.size(); i++)
	                if (list1.get(i) != list2.get(i)) {
	                    System.out.println("False");
	                    return;
	                }
	            System.out.println("True");
	        }
        };
        
        BiConsumer<List<Integer>, List<Integer> > disp = (list1, list2) ->
        {
            list1.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
            list2.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        };
        
        equals.accept(lista, listb);
        
        System.out.println("\n andThen() method usage \n========================");
     // Using addThen() method
        equals.andThen(disp).accept(lista, listb);
	}
}
