package hari_krishna.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 *	1. Max size of HashMap is Integer.MAX_VALUE
 */
public class HashMapSize {

	public static void main(String[] args) {

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(long count=0; count<=Long.MAX_VALUE; count++) {
			m.put((int)count, (int)count);
		}
		System.out.println(m);
	}
}
