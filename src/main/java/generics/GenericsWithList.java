package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWithList {


	public static void main(String[] args) {
			
		/**
		 * If we don't declare "Generic Type" in declaration statement
		 * as shown below then we can add any types of data  
		 */
		List names = new ArrayList<String>();
		names.add(1);
		names.add('c');
		names.add("cc");
		System.out.println(names);
		
		List numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add('a');
		numbers.add("aa");
		System.out.println(numbers);
	}

}
