package hari_krishna.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 *	Enumeration is meant for Vector & Hashtable,
 *	But using Collections utility class,
 *	We can extend Enumeration usage to Collection as well
 *
 *	Iterator is meant for Collection &
 *	ListIterator for List 
 */

public class EnumerationOverCollection {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("hapheej");
		names.add("sheikh");
		names.add("mansoori");
		
		Enumeration<String> enums = Collections.enumeration(names);
		
		while(enums.hasMoreElements()) {
			System.out.println(enums.nextElement());
		}
	}
}
