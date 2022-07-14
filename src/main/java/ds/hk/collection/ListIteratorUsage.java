package ds.hk.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *		ListIterator Can Traverse List In Reverse Order
 */

public class ListIteratorUsage {

	
	static void retrieveElemetInReverseOrder(List<String> names) {
		
		ListIterator<String> itr = names.listIterator(names.size());
		System.out.println("Reverse Order Of List Using ListIterator"
				+ "\n---------------------------------------");
		while(itr.hasPrevious()) {
			
			System.out.println(itr.previous());
		}
	}

	public static void main(String[] args) {

		List<String> names = new LinkedList<>();
		names.add("hapheej");
		names.add("sheikh");
		names.add("dummy");
		
		//ListIterator<String> itr = names.listIterator();
		ListIterator<String> itr = names.listIterator(0);
		
		boolean addOnce = true;
		
		while(itr.hasNext()) {

			//Otherwise it will add before each Element
			if(addOnce) {
				itr.add("mansoori");
				addOnce = false;
			}
		
			String temp = itr.next();
			if(temp.equals("hapheej")) {
				itr.set("Hapheej");
				System.out.println(names);
			}
			
			if(itr.hasPrevious()) {
				
				String tmp = itr.previous();
				
				if(tmp.equals("sheikh")) {
					itr.set("Sheikh");
					System.out.println(names);
				}
				//To Break Infinite Looping
				itr.next();
			}
	
		}
		System.out.println(names);
		
		//Reverse Order Traversal
		retrieveElemetInReverseOrder(names);
	}
}
