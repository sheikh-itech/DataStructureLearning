package core.thread.executor;

import java.util.concurrent.CompletableFuture;

//Handles errors gracefully without crashing the program

public class CompletableFutureErrorHandling {

	public static void main(String[] args) {

		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Oops! Error occurred.");
            return 42;
        }).exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return 0; // Fallback value
        });

        System.out.println("Final result: " + future.join());
	}
}
