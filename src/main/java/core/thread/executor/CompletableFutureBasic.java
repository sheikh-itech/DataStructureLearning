package core.thread.executor;

import java.util.concurrent.CompletableFuture;

/*	Main thread is not blocked while the async task runs
 * 	join() waits for the task to finish before exiting
 */
public class CompletableFutureBasic {

	public static void main(String[] args) {

		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running async task in: " + Thread.currentThread().getName());
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        });

        System.out.println("Main thread continues...");

        future.join(); // Wait for async task to complete
	}
}
