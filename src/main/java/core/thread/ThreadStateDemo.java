package core.thread;

public class ThreadStateDemo {

	public static void main(String[] args) {

		Thread3 t3 = new Thread3();
		
		System.out.println("Thread3 state: "+t3.getState());
		
		t3.start();
		
		System.out.println("Thread3 state: "+t3.getState());
		
		try {
			t3.join();	// Main thread waits to terminate Thread3
			Thread3.sleep(100);
			System.out.println("Thread3 state: "+t3.getState());
		} catch (InterruptedException e) {
			System.out.println("Thread "+t3.getName()+" interrupted");
		}
	}
}

class Thread3 extends Thread {

	@Override
	public void run() {
		
		for(int i=0; i<1000; i++)
			i+=i;
		
		//Runnable since Java don't have Running defined
		System.out.println("1Thread3 state: "+ this.getState());
		
		try {
			Thread3.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int fact(int num) {
		
		if(num==0 || num==1)
			return 1;
		
		return num*fact(num-1);
	}
}