package ds.internal.working;

import java.util.HashMap;
import java.util.Map;

public class HashMap_InternalWorking {

	public static void main(String[] args) {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(11111, 1111);
		map.put(22222, 91111);
		map.put(3333, 911131);
		map.put(9999, 911211);
		map.put(888888, 911011);
		System.out.println(map);
	}
}

/**
HashMap Internal Working
------------------------

1. Creates Array of Node<k, v> with 16 capacity [called table]
2. Put call
	1. Find index using Capacity & HashCode
	2. If that Index is empty/null->Assign value
	3. If Index already has value
		1. Check if Key & HashCode are equal-> replace old value
		2. Check if nextNode[Node inside Node] is null-> assign value to internal null node
		3. If nextNode not Null-> 
			Check if Key & HashCode are equal-> replace old value
		4. If Parent-To-Internal Node count more then TREEIFY_THRESHOLD/7
			Resize arrayNode/table
		5. if Parent-To-Internal Node count more then MIN_TREEIFY_CAPACITY/63
			Convert array Node to TreeNode
*/