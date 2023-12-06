package hari_krishna.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorDemo {

	public static void main(String[] args) {

		Set<String> names = new TreeSet<>(new StringComparator());
		
		names.add("b");
		names.add("g");
		names.add("i");
		names.add("a");
		names.add("e");
		names.add("c");
		names.add("f");
		names.add("h");
		names.add("d");
		System.out.println("Comparator Sorted: "+names);
	}
}

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		return o1.hashCode() - o2.hashCode();
	}	
}