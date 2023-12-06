package hari_krishna.multithread;

public class ThreadGroupDemo {

	public static void main(String[] args) throws InterruptedException {

		ThreadGroup group1 = new ThreadGroup("Group-A");
		ThreadGroup group2 = new ThreadGroup("Group-B");
		
		NewThreadGroup th1 = new NewThreadGroup(group1, "Thread1");
		NewThreadGroup th2 = new NewThreadGroup(group1, "Thread2");
		
		NewThreadGroup th3 = new NewThreadGroup(group2, "Thread3");
		NewThreadGroup th4 = new NewThreadGroup(group2, "Thread4");
		
		group1.list();
		group2.list();
		
		System.out.println("Suspending Group-A");
		group1.suspend();
		Thread.sleep(100);
		group1.resume();
	}
}

class NewThreadGroup implements Runnable {
	
	private String name;
	
	NewThreadGroup(ThreadGroup th, String name){
		this.name = name;
		new Thread(th, this).start();
	}

	@Override
	public void run() {
		System.out.println("Thread Group: "+ this.name);
	}
}