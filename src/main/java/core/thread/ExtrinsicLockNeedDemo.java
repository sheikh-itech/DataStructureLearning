package core.thread;

public class ExtrinsicLockNeedDemo {

	public static void main(String[] args) {

		Bank bank = new Bank();
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				
				bank.withdraw(50);
			}
		};
		
		new Thread(runnable, "Thread-1").start();	// Thread 1
		new Thread(runnable, "Thread-2").start();	// Thread 2
	}
}

class Bank {
	
	private float balance=100;
	
	// Other thread waits here for i/o, db operation for entire function completion
	public synchronized void withdraw(int amount) {
		
		System.out.println(Thread.currentThread().getName()+" trying to withdraw");
		
		if(amount > balance)
			System.err.println(Thread.currentThread().getName()+" Insufficient balance");
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException ex) {
			System.err.println("Error: "+ex.getMessage());
		}
		
		balance = balance - amount;
		
		System.out.println(Thread.currentThread().getName()+" Amount "+amount +" withdraw completed...");
	}
}