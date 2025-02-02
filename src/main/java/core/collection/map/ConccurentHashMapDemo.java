package core.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**				Java 7
 * 	Segment based locking, default segment size is 16
 * 	Single Segment contains portion of bucket [Group of buckets]
 * 	Only accessed segment only locked
 * 	No lock required in reading operation
 *
 *				Java 8
 *	Compare-and-swap approach
 *	No locking except-> Resizing or Collision [Lock to bucket only]
 *	It checks current values with previous if finds different then try to update it
 *	by acquiring lock if fails then again try to update it once lock open
 *
 *	Allows multiple threads to read and write without explicit locks-> Thread Safety
 *	Does not allow null keys or values to avoid ambiguity during concurrent operations
 *	Do not throw ConcurrentModificationException
 */
public class ConccurentHashMapDemo {

	public static void main(String[] args) {

		Map<Integer, Integer> nums = new ConcurrentHashMap<>();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				super.run();
				for(int i=1; i<=1000; i++)
					nums.put(i, i);
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				super.run();
				for(int i=1001; i<=2000; i++)
					nums.put(i, i);
			}
		};
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(Exception ex) {
			
		}
		
		System.out.println("Map size should be 2000: "+nums.size());
		
		//No Concurrent Modification Error
		
		for(int i=0; i<=nums.size(); i++)
			nums.replace(i, i+1);
		
		System.out.println(nums);
	}
}
