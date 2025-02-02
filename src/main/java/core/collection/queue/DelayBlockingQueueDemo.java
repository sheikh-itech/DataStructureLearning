package core.collection.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**	Thread safe, unbounded blocking queue
 * 	Elements can only be taken out from queue when their delay time has expired
 * 	Useful for scheduled task to be executed after certain time
 * 	
 * 	**Internally uses Priority Queue
 */
public class DelayBlockingQueueDemo {

	public static void main(String[] args) {

		BlockingQueue<DelayTask> queue = new DelayQueue<>();
		
		try {
			queue.put(new DelayTask("Task-1", 15, TimeUnit.SECONDS));
			queue.put(new DelayTask("Task-2", 12, TimeUnit.SECONDS));
			queue.put(new DelayTask("Task-3", 5, TimeUnit.SECONDS));
			
			System.out.println("All tasks are ready to executed");
			
			while(!queue.isEmpty()) {
				DelayTask task = queue.take();
				System.out.println("Task name: "+task.getTaskName());
			}
			
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted...");
		}
	}
}

class DelayTask implements Delayed {

	private final String taskName;
	private final long startTime;
	
	public DelayTask(String taskName, long delay, TimeUnit unit) {
		this.taskName = taskName;
		this.startTime = System.currentTimeMillis() + unit.toMillis(delay);
	}
	
	@Override
	public int compareTo(Delayed o) {
		
		 if(this.startTime < ((DelayTask)o).startTime )
			 return -1;
		 
		 if(this.startTime > ((DelayTask)o).startTime )
			 return 1;
		
		 return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		
		long remainingTime = startTime - System.currentTimeMillis();
		return unit.convert(remainingTime, TimeUnit.MILLISECONDS);
	}
	
	public String getTaskName() {
		
		return this.taskName;
	}
}