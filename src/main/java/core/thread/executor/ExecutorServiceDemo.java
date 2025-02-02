package core.thread.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**	invokeAll(Collection<? extends Callable<T>>):
 * 		Used when required to execute multiple Callable tasks concurrently and 
 * 		collect their results.
 * 		It blocks [joins main thread] until all tasks finish execution
 * 
 * 	invokeAll(Collection<? extends Callable<T>>, Timeout, TimeUnit):
 * 		Executes multiple Callable tasks concurrently withing given time
 * 		It cancel's task execution if given time exceeds
 * 
 * 	invokeAny(Collection<? extends Callable<T>>):
 * 		Returns result of task that completes first others are auto cancelled
 * 		Upon normal or exceptional return, tasks that have not completed are cancelled.
 * 
 * 	invokeAny(Collection<? extends Callable<T>>, timeout, TimeUnit)
 * 		Returns first executed task within time limit otherwise cancel's all tasks
 */
public class ExecutorServiceDemo {

	public static void main(String[] args) {

// ExecutorService with Runnable

		ExecutorService service = Executors.newFixedThreadPool(5);
		
		Runnable run = () -> {
			for(int i=1; i<6; i++)
				System.out.print(i+", ");
		};
		
		Future<?> future1 = service.submit(run);	// Pooled thread works here
		
		System.out.println("Future1 is done: "+future1.isDone());
		
		// submit-> will return 'Number print' on successful execution 
		Future<String> future2 = service.submit(run, "Number print");
		
		System.out.println("Future2 is done: "+future2.isDone());
		try {
			// Main thread gets value here, waits max time 2 seconds
			System.out.println("Future2 value: "+future2.get(2, TimeUnit.SECONDS));
			
		} catch (InterruptedException | ExecutionException | TimeoutException ex) {
			System.err.println("Error: timed out");
		}
		
		
// ExecutorService with Callable
		
		// Create a list of Callable tasks
        List<Callable<Integer>> taskList = new ArrayList<>();
        taskList.add(new FactorialTask(4));
        taskList.add(new FactorialTask(5));
        taskList.add(new FactorialTask(6));
		
     // 1. invokeAll waits for all tasks to complete
        try {
        	
			List<Future<Integer>> results = service.invokeAll(taskList);
			
			// Retrieving results from each Future
	        for (Future<Integer> f : results) {
	            System.out.println("Factorial result: " + f.get());
	        }
		} catch (InterruptedException | ExecutionException e) {	}
		
        List<Callable<String>> tasks = Arrays.asList(
                new DelayedTask("Task-1", 1000),
                new DelayedTask("Task-2", 2000),
                new DelayedTask("Task-3", 4000) // Will exceed timeout
            );
        
     // 2. invokeAll with timeout of 3 seconds
        
        try {
			List<Future<String>> results = service.invokeAll(tasks, 3, TimeUnit.SECONDS);
			
			for (Future<String> future : results) {
				System.out.println(future.get()); // If task completed
			}
		} catch (InterruptedException | ExecutionException | CancellationException ex) {
			
			if(ex instanceof CancellationException)
				System.out.println("A task was canceled due to timeout");
		}
        
    // 3. invokeAny()-> returns only the first completed result and cancels all others
        
        List<Callable<String>> tasks1 = Arrays.asList(
                new FastTask("Task-1", 3000), // Slower
                new FastTask("Task-2", 1000), // Fastest
                new FastTask("Task-3", 2000)  // Slower
            );
            
			try {
				
				// Returns the first completed task result and cancels others
				
				String result = service.invokeAny(tasks1);
				
				System.out.println("First completed task: " + result);
				
			} catch (InterruptedException | ExecutionException e) {	}
			
			
		// invokeAny()
			
			List<Callable<Integer>> tasks2 = Arrays.asList(
	                ()->2,
	                ()->3,
	                ()->4
	            );
	            
				try {
					
					// Returns the first completed task result and cancels others
					
					Integer result = service.invokeAny(tasks2, 1, TimeUnit.MICROSECONDS);
					
					System.out.println("First completed task: " + result);
					
				} catch (InterruptedException | ExecutionException | TimeoutException ex) {
					
					if(ex instanceof TimeoutException)
						System.err.println("Error: tasks timed out");
				}
            
        
		service.shutdown();
	}
}

class FastTask implements Callable<String> {
	
    private final String name;
    private final int delay;

    FastTask(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(delay);
        return name + " completed in " + delay + "ms";
    }
}

class DelayedTask implements Callable<String> {
	
    private final String name;
    private final int delay;

    DelayedTask(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(delay);
        return name + " completed in " + delay + "ms";
    }
}

class FactorialTask implements Callable<Integer> {
    
	private final int number;

    FactorialTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= number; i++) {
            fact *= i;
            Thread.sleep(500); // Simulating computation
        }
        return fact;
    }
}