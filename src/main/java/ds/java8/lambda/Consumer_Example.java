package ds.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


/**	It represents a function which takes one argument and produces a result
 * 
 * 	However these kind of functions don’t return any value
 *
 *	It can assign to lambda expression or method reference
 *	NullPointerException- if input is null
 */
public class Consumer_Example {

	public static void main(String args[]) {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> result = new ArrayList<>();
		
		// Consumer to display a object
        Consumer<Object> display = obj -> System.out.println(obj);
        
        Consumer<List<Integer>> modify = lst ->lst.forEach(val->result.add(val+2));
        
        Consumer<List<Integer>> modify1 = lst ->lst.stream().filter(v-> v>3?result.add(v+2):false ).count();
        
        Consumer<List<Integer>> modify2 = lst ->lst.forEach(val->{ if(val>3)result.add(val+2);} );
        
        Consumer<List<Integer>> display1 = lst ->lst.forEach(val->System.out.println(val));
        
        display.accept("Arham Vehleen");
        display.accept(nums);
        
        modify.accept(nums);
        System.out.println(result);
        
        result.clear();
        modify1.accept(nums);
        System.out.println(result);
        
        result.clear();
        modify2.accept(nums);
        System.out.println(result);

        
//andThen        
        result.clear();
        modify.andThen(display).accept(nums);
        System.out.println(result);
        
        result.clear();
        modify.andThen(modify2).accept(nums); //process 'modify' first then 'modify2'
        System.out.println(result);
        
        //display.andThen(modify2).accept(nums);	//display takes Object, not nums/List<Integer>
        
        display1.andThen(modify2).accept(nums);
	}
}
