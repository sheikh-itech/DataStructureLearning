package core.thread.executor;

import java.util.concurrent.CompletableFuture;

/*	First task returns 10, next task multiplies by 2, final task adds 5
 * 	Each step executes asynchronously
 */
public class CompletableFutureChaining {

	public static void main(String[] args) {

		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(num -> num * 2)
                .thenApply(num -> num + 5);

        System.out.println("Final result: " + future.join());
	}
}
