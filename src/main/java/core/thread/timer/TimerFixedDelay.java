package core.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/* Runs a task every 2 seconds, but waits for previous task to finish before starting the next 
 * 
 * 	Next task starts after previous task finishes + 2 seconds delay
 */
public class TimerFixedDelay {

	public static void main(String[] args) {

		Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task started at: " + System.currentTimeMillis());
                try {
                    Thread.sleep(3000); // Simulating long-running task
                } catch (InterruptedException ignored) {}
            }
        };

        // Runs every 2 seconds, starting after 1 second
        timer.schedule(task, 1000, 2000);
	}
}
