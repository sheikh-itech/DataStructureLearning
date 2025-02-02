package core.thread.executor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*	Executes tasks in parallel and waits for all to finish
 * 	
 * 	Useful for batch processing (e.g., multiple database queries)
 */
public class CompletableFutureMultipleTask {

	public static void main(String[] args) {

		List<CompletableFuture<Integer>> futures = IntStream.range(1, 6)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> i * i))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = 
        		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        // Retrieve results after all tasks complete
        List<Integer> results = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println("All results: " + results);
	}
}
