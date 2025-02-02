package core.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**	Vector Since Java 1 [Legacy class, means old version or before java 2]
 * 	Dynamic Array
 * 		Like ArrayList it is also dynamic array, grows automatically like list
 * 	Synchronized
 * 		All methods are synchronized which makes thread safe but this features reduces performance
 * 	Legacy Class
 * 		Vector is part of java initial release
 * 	Resizing Mechanism
 * 		When capacity gets full, it doubles itself
 * 
 * 	Random Access - supports random access or index based access
 */
public class VectorDemo {

	public static void main(String[] args) {

		Vector<Integer> nums = new Vector<>(5); // 10 default initial capacity
		Vector<Integer> nums1 = new Vector<>(20, 10); // capacity: 10, increase by: 20
		
		nums.add(1); nums.add(2); nums.add(3); nums.add(4); nums.add(5);
		
		System.out.println("Capacity: "+nums.capacity());
		
		nums.add(6);
		System.out.println("Capacity: "+nums.capacity()); // Doubles capacity
		
		nums.size();
		
		nums.clear();
		
		Thread t1 = new Thread(()->{
			for(int i=0; i<1000; i++)
				nums.add(i);
		});
		
		Thread t2 = new Thread(()->{
			for(int i=0; i<1000; i++)
				nums.add(i);
		});
		
		t1.start(); t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		List<Integer> nums3 = new ArrayList<>();
		
		Thread t3 = new Thread(()->{
			for(int i=0; i<1000; i++)
				nums3.add(i);
		});
		
		Thread t4 = new Thread(()->{
			for(int i=0; i<1000; i++)
				nums3.add(i);
		});
		
		t3.start(); t4.start();
		
		try {
			t3.join();
			t4.join();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		/*	Since Vector is synchronized it locks add method and adds each element
		 * 	But since list is not thread safe, 2 threads may try to add element in same time
		 * 	and only 1 element will get added instead of 2 in parallel thread
		 * */
		
		System.out.println("Vector size with thread: "+nums.size());
		System.out.println("List size with thread: "+nums3.size());
	}
}
