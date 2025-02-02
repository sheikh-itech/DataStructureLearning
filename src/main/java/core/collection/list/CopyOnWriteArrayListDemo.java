package core.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**	Whenever adds new element it creates copy of existing one and then adds element to that
 * 	newly created copy
 * 	In this scenario this existing read operation don't affects
 * 
 * 	Assume while looping list element if we want to add new element then in ArrayList
 * 	concurrent modification exception comes, but CopyOnWriteArrayList resolves problem
 */
public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) {
		
		List<Integer> num1 = new ArrayList<>();
		List<Integer> num2 = new CopyOnWriteArrayList<>();
		
		num1.add(2); num1.add(5); num1.add(7); num1.add(9); num1.add(8);
		num2.add(2); num2.add(5); num2.add(7); num2.add(9); num2.add(8);
		
		for(Integer num: num1)
			if(num%7==0) {
				//num1.add(11);	//ConcurrentModificationException for ArrayList
				continue;
			}
			else
				System.out.print(num+" ");
		
		System.out.println();
		
		for(Integer num: num2)
			if(num%7==0)
				num2.add(11);	//It will merge to final list after read operation completion
			else
				System.out.print(num+" ");
		
		System.out.println("\nFinal num1: "+num1);
		System.out.println("Final num2: "+num2);
	}
}
