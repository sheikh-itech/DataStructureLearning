package hari_krishna.collection;

import java.util.ArrayList;
import java.util.List;

public class FewCollectionMethods {

	public static void main(String[] args) {

		List<String> names1 = new ArrayList<>();
		names1.add("a");
		names1.add("b");
		names1.add("c");
		names1.add("d");
		names1.add("e");
		names1.add("f");
		
		List<String> names2 = new ArrayList<>();
		names2.add("d");
		names2.add("e");
		names2.add("f");
		names2.add("f");
		names2.add("g");
		names2.add("h");
		
		System.out.println("contailsAll(Collection c): "+names1.containsAll(names2));
		
		names1.addAll(names2);
		System.out.println("addAll(Collection c): "+names1);
		
		System.out.println("contailsAll(Collection c): "+names1.containsAll(names2));
		
		names1.retainAll(names2);
		System.out.println("retainAll(Collection c): "+names1);
		
		names1.removeAll(names2);
		System.out.println("removeAll(Colletion c): "+names1);
	}
}
