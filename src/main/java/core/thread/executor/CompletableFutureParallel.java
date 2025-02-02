package core.thread.executor;

import java.util.concurrent.CompletableFuture;

/*	Runs future1 and future2 in parallel and combines the results
 * 
 * 	Useful for parallel data fetching (e.g., fetching from multiple APIs)
 */
public class CompletableFutureParallel {

	public static void main(String[] args) {

		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, Integer::sum);

        System.out.println("Sum: " + combinedFuture.join());
	}
}
