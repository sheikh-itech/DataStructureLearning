package ds.java8lambda;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import ds.beans.DataProvider;

public class LambdaExceptionHandling {

	public static void main(String[] args) {

		List<Integer> nums = DataProvider.getIntList(30); 

		//Update Data by 2
		
		Function<Integer, Integer> fun = (x)->x+2;
		nums.forEach(num->System.out.print(fun.apply(num)+", "));
		
		System.out.println();
		
		BiFunction<Integer, Integer, Integer> func =(x, y)->x+y;
		nums.forEach(num->System.out.print(func.apply(num, 3)+", "));
		
		BiFunction<Integer, Integer, Integer> div =(x, y)->x/y;
		
		nums.forEach(num->System.out.print(div.apply(num, 3)+", "));
		
		process(nums, 2, (x, y)->System.out.print((x/y)+", "));
		System.out.println();
		
//Exception Handled
		process(nums, 0, processWrapper((x, y)->System.out.print((x/y)+", ")));
		
		
	}
	
	public static void process(List<Integer> nums, int key, BiConsumer<Integer, Integer> con) {
		nums.forEach(num->con.accept(num, key));
	}
	
	public static BiConsumer<Integer, Integer> processWrapper(BiConsumer<Integer, Integer> con) {
		return (x, y)->{
			try {
				con.accept(x, y);
			} catch(Exception ex) {
				System.out.print("Arithmetic error, ");
			}
		};
	}
}
