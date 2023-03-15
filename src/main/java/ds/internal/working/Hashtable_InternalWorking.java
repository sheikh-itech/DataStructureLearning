package ds.internal.working;

import java.util.Hashtable;
import java.util.Map;

public class Hashtable_InternalWorking {

	public static void main(String[] args) {

		Map<Integer, Integer> map1 = new Hashtable<Integer, Integer>();
		
		map1.put(1, 1);
		map1.put(11111, 1111);
		map1.put(22222, 91111);
		map1.put(3333, 911131);
		map1.put(9999, 911211);
		map1.put(888888, 911011);
		System.out.println(map1);
	}
}
/**
Hashtable Internal Working
--------------------------

It contains Array of Entry<?, ?> class [table]

1. If value null-> NullPoniterException
2. If key already exists [Key && hashCode both are matched]
	Replace old value
3. If Key not exists [Key && hashCode any of them Not matched]
4. Add new Entry/Node
	1. Check if Count reached to threshold
		->Rehash table if threshold exceeds
		->Create new Entry of array with new capacity
		->Copy old value to new array of Entry/table
	2. Add new value to Index, if with that Index old value is there
	3. Assign that old value to it's Internal Entry/nextEntry

Synchronized put method
*/