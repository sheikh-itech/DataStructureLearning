package core.thread;

/**	Starvation occurs in multithreading when a thread is unable to gain access to required
 * 	resources (like CPU, locks, etc.) because other threads with higher priority or 
 * 	resource-hogging behavior prevent it from proceeding.
 * 	As a result, the "starved" thread remains indefinitely waiting
 */
public class StarvationDemo {

	public static void main(String[] args) {

		Thread highPriority = new Thread(() -> {
            while (true) {
                System.out.println("High-priority thread running...");
            }
        });

        Thread lowPriority = new Thread(() -> {
            while (true) {
                System.out.println("Low-priority thread running...");
            }
        });

        highPriority.setPriority(Thread.MAX_PRIORITY); // Highest priority
        lowPriority.setPriority(Thread.MIN_PRIORITY);  // Lowest priority

        highPriority.start();
        lowPriority.start();
	}
}
