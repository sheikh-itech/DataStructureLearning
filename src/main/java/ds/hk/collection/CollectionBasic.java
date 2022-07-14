package ds.hk.collection;

import java.util.HashMap;
import java.util.Map;

public class CollectionBasic {

	public static void main(String[] args) {

		//Max size of HashMap is Integer.MAX_VALUE
		//below will give either memory issue Or exceeded limit issue
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(long count=0; count<=Long.MAX_VALUE; count++) {
			m.put((int)count, (int)count);
		}
		System.out.println(m);
	}
}
