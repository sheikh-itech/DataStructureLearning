package core.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/**	Timer is a utility class used to schedule tasks for one-time execution or 
 * 	repeated execution at a fixed interval.
 * 	It works with TimerTask, which represents the task to be executed
 *
 *	Less efficient compared to ScheduledExecutorService
 *
 *	Easy to Use: Simple API for scheduling tasks
 *	Fixed Delay & Fixed Rate Execution: Supports both scheduling modes
 *	Single-threaded Execution: Good for simple periodic tasks
 *	Lightweight: Useful for non-intensive background tasks
 *
 *	Limitations:
 *		Single-threaded: If a task takes too long, it delays all other scheduled tasks
 *		No Thread Pooling: It doesn't use multiple threads
 *		Exception Handling Issue: If a TimerTask throws an exception, the entire Timer stops
 */
public class TimerBasic {

	public static void main(String[] args) {

		Timer timer = new Timer(); // Create a Timer instance

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task executed at: " + System.currentTimeMillis());
            }
        };

        // Schedule the task to run after 3 seconds (3000 ms) once
        timer.schedule(task, 3000);
	}
}
