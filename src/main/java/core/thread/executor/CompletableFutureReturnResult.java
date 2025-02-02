package core.thread.executor;

import java.util.concurrent.CompletableFuture;

/*	Runs in a separate thread and returns a result asynchronously
 */
public class CompletableFutureReturnResult {

	public static void main(String[] args) {

		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating square in: " + Thread.currentThread().getName());
            return 5 * 5;
        });

        int result = future.join(); // Blocks and retrieves the result
        System.out.println("Computed result: " + result);
	}
}
