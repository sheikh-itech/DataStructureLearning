package core.thread;

/**	A deadlock occurs when two or more threads are waiting for each other to release locks on 
 * 	resources, causing an infinite waiting loop.
 * 	This blocks the threads indefinitely
 * 
 * 	When 2 or more threads having circular dependency, deadlock may occur
 */
public class DeadLockDemo {

	public static void main(String[] args) {

		Resource resource1 = new Resource();
        Resource resource2 = new Resource();

        Thread t1 = new Thread(() -> resource1.methodA(resource2), "Thread-1");
        Thread t2 = new Thread(() -> resource2.methodA(resource1), "Thread-2");

        t1.start();
        t2.start();
	}
}

class Resource {
    public void methodA(Resource r) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " locked this resource");
            synchronized (r) {
                System.out.println(Thread.currentThread().getName() + " locked other resource");
            }
        }
    }
}