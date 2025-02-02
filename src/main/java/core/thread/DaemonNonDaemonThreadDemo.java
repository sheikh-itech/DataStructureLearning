package core.thread;

/**	Daemon Thread: runs in background, JVM don't wait for their completion
 * 
 *	Non-Daemon Thread: Foreground threads, Main thread waits for their completion
 *
 *	By default custom thread is Non-Daemon
 */
public class DaemonNonDaemonThreadDemo {

	public static void main(String[] args) {
		
		System.out.println("Main thread started");
		
		NonDaemon nonDaemon = new NonDaemon();
		
		Daemon daemon = new Daemon();
		daemon.setDaemon(true);			// Daemon thread, No Guarantee of Execution
		
		
/* If Deamon started before Non-Deamon then it will have more chance of execution 
 * Uncomment below line to check difference [Only Chance not surety] */
		
		//daemon.start();
		
		nonDaemon.start();
		
		daemon.start();
		
		
		System.out.println("Main thread ended");
	}
}

class Daemon extends Thread {
	
	@Override
	public void run() {
		
		for(int i=1; i<6; i++)
			System.out.println("Hello Daemon thread!");
	}
}

class NonDaemon extends Thread {
	
	@Override
	public void run() {
		
		for(int i=1; i<6; i++)
			System.out.println("Hello Non-Daemon thread!");
	}
}