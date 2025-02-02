package core.collection.map;

import java.util.EnumMap;
import java.util.Map;

/**	Fast sine keys are predefined in Enum
 * 	Maintains order same as Enum have
 * 	Highly efficient and space-optimized mapping for enumerations
 * 
 * 	Keys must be of an enum type
 * 	Internally uses an array for storage, making it faster and more memory-efficient than HashMap or TreeMap
 * 	Does not allow null keys, but allows null values
 * 	
 * 	High Performance, Memory Efficient, Predictable Order, Type Safety
 */
public class EnumMapDemo {

	public static void main(String[] args) {

		//Map<Days, String> work = new HashMap<>();
		
		Map<Days, String> work = new EnumMap<>(Days.class);
		
		work.put(Days.Thursday, "Playground");
		work.put(Days.Monday, "Jogging");
		work.put(Days.Friday, "Prayer");
		
		System.out.println(work);
	}
}

enum Days {
	Monday, Tuesday, Wednessday, Thursday, Friday, Saturday, Sunday
}