package ds.hk.collection.map;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 	Hash table based implementation, with week keys
 * 	An entry in a WeakHashMap will automatically be removed when its key is no longer in ordinary use
 * 	Both Null keys & values are supported
 * 	Performance similar to HashMap
 *  Not synchronized
 *  
 *  If key don't have reference, then Week Map will reset itself
 */

public class WeekHashMapExample {

	public static void main(String[] args) throws InterruptedException {

		Map<String, String> pair1 = new WeakHashMap<String, String>();
		pair1.put(null, null);
		pair1.put(new String("abc"), "abc");
		String s1 = "abc1";
		String s2 = new String("abc2");
		pair1.put(s1, "abc1");
		pair1.put(s2, "abc2");
		s1=null;
		s2=null;
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				while(pair1.containsKey("abc")) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("custom thread");
					System.gc();
				}
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		t.join();//Main joined to 't' thread
		System.out.println("main thread");
		System.out.println(pair1);
	}
}
