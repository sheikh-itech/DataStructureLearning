package core.thread.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureUse {

	public static void main(String[] args) {

		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
			
			try {
				Thread.sleep(2000);
				System.out.println("Worker thread 1");
			} catch(Exception ex) {
				System.err.println("Error: "+ex.getMessage());
			}
			return "done1";
		});
		
		System.out.println("Main thread");
		
		try {
			System.out.println("Worker output: "+future1.get());
		} catch (InterruptedException | ExecutionException e) {
			System.err.println("Error: "+e.getMessage());
		}
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
			
			try {
				Thread.sleep(2000);
				System.out.println("Worker thread 2");
			} catch(Exception ex) {
				System.err.println("Error: "+ex.getMessage());
			}
			return "done2";
		});
		
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(()->{
			
			try {
				Thread.sleep(2000);
				System.out.println("Worker thread 3");
			} catch(Exception ex) {
				System.err.println("Error: "+ex.getMessage());
			}
			return "done3";
		}).orTimeout(50, TimeUnit.MILLISECONDS).exceptionally(s-> "Timeout occurred");
		
		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
		
		combinedFuture.join(); // joins main thread
		try {
			combinedFuture.get();
		} catch (InterruptedException | ExecutionException ex) {
			System.err.println("Error: "+ex.getMessage());
		}
		
		CompletableFuture<Object> future4 = future2.thenApply(x-> x+x);
		
		try {
			System.out.println("Future2 with lambda: "+future4.get());
			
			System.out.println("Future3 with lambda: "+future3.get());
		} catch(Exception ex) {
			System.err.println("Error: "+ex.getMessage());
		}
	}
}
