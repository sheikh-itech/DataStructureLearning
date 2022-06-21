package ds.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hapheej
 *
 */
public class SetCollection {


	public static void main(String[] args) {
		
		Set<Object> uniqueNames = new HashSet<Object>();
		
		uniqueNames.add(new String("Hapheej"));
		uniqueNames.add(new String("Hapheej"));
		uniqueNames.add(1);
		uniqueNames.add(1);
		uniqueNames.add('v');
		uniqueNames.add('v');
		
		System.out.println(uniqueNames);

	}

}
