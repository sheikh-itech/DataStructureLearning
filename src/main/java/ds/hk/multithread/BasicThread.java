package ds.hk.multithread;

public class BasicThread extends Thread {

	public BasicThread(String threadName) {
		super(threadName);
	}
	
	@Override
	public void run() {
		
		System.out.println("Sub thread run method");
	}
	public static void main(String[] args) {

		BasicThread t = new BasicThread("Dummy");
		
		t.setPriority(11);
		t.setName("First Thread");
		t.setDaemon(true);
		
		Thread t1 = currentThread();
		
		System.out.println("ThreadGroup(): "+t1.getThreadGroup().getName());
		System.out.println(t1);
	}
}
