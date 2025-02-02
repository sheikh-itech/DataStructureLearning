package core.thread;

/**	A deadlock occurs when two or more threads are waiting for each other to release locks on 
 * 	resources, causing an infinite waiting loop.
 * 	This blocks the threads indefinitely
 * 
 * 	When 2 or more threads having circular dependency, deadlock may occur
 * 
 * 	4 Possible Reasons Of Deadlock
 * 
 * 	1. Mutual Exclusion (Exclusive Access)
 * 		=>At least one resource must be held in a non-shareable mode
 * 		  (only one thread can use it at a time)
 * 		=>If another thread requests this resource, it must wait until it is released
 * 
 * 	2. Hold and Wait
 * 		=>A thread holds at least one resource and is waiting to acquire additional resources 
 * 			held by other threads
 * 		=>It does not release the resource while waiting
 * 
 * 	3. No Preemption (No Forced Release)
 * 		=>A resource cannot be forcibly taken from a thread
 * 		=>It is released only when the thread voluntarily releases it after finishing its execution
 * 
 * 	4. Circular Wait
 * 		=>Two or more threads form a circular chain, where each thread is waiting for a resource 
 * 			held by the next thread in the cycle
 */
public class DeadLockExample {

	private final Object resource1 = new Object();
    private final Object resource2 = new Object();

    void method1() {
        synchronized (resource1) {
            System.out.println(Thread.currentThread().getName() + " locked resource1");
            try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (resource2) { // Waiting for resource2
                System.out.println(Thread.currentThread().getName() + " locked resource2");
            }
        }
    }

    void method2() {
        synchronized (resource2) {
            System.out.println(Thread.currentThread().getName() + " locked resource2");
            try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (resource1) { // Waiting for resource1
                System.out.println(Thread.currentThread().getName() + " locked resource1");
            }
        }
    }
    
	public static void main(String[] args) {

		// 4. Circular Wait (Circular Dependency)
		
		DeadLockExample obj = new DeadLockExample();
        Thread t1 = new Thread(obj::method1, "Thread-1");
        Thread t2 = new Thread(obj::method2, "Thread-2");

        t1.start();
        t2.start();
	}
}


/* 3. No Preemption (No Forced Release)

	synchronized (resource1) {
    	// Thread must complete this block before releasing resource1
	}
*/

// 2. Hold and Wait (Holding While Requesting)
class Task implements Runnable {
	
    private final Object resource1;
    private final Object resource2;

    Task(Object resource1, Object resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    public void run() {
        synchronized (resource1) {  // Holds resource1
            System.out.println(Thread.currentThread().getName() + " locked resource1");
            try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (resource2) { // Waiting for resource2
                System.out.println(Thread.currentThread().getName() + " locked resource2");
            }
        }
    }
}

class Resource1 {
    void use() {
        synchronized (this) { // Only one thread can use it
            System.out.println(Thread.currentThread().getName() + " is using the resource.");
        }
    }
}

/*
1. Mutual Exclusion
	void use() {
		// Only one thread can use it
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is using the resource.");
        }
    }
    
*/