package core.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/*	Runs a task every 2 seconds, regardless of the execution time
 *	
 *	Tasks try to stick to the fixed schedule, even if the previous task is still running 
 */
public class TimerFixedRate {

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
        timer.scheduleAtFixedRate(task, 1000, 2000);
	}
}
