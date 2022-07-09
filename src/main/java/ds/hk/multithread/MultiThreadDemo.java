package ds.hk.multithread;


public class MultiThreadDemo {

	static long time;
	
	public static void main(String[] args) throws InterruptedException {

		long time1 = System.currentTimeMillis();
		SigleThread st = new SigleThread();
		st.run();
		long time2 = System.currentTimeMillis();
		long singleTime = time2-time1;
		
	//*****************************************//
		
		time = time1 = System.currentTimeMillis();
		
		MultiThread mt1 = new MultiThread();
		MultiThread mt2 = new MultiThread();
		MultiThread mt3 = new MultiThread();
		MultiThread mt4 = new MultiThread();
		MultiThread mt5 = new MultiThread();
		
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
		mt5.start();
		
		mt1.join();
		mt2.join();
		mt3.join();
		mt4.join();
		mt5.join();
		
		time2 = System.currentTimeMillis();
		time1 = time2-time1;
		System.out.println("Total Time In Single Thread: "+singleTime/1000+" sec");
		System.out.println("Total Time In Multi Thread: "+time1/1000+" sec");
		System.gc();
	}
	
	@Override
	public void finalize() {
		System.out.println("finalize() Total Time In Multi Thread: "+((System.currentTimeMillis()-time)/1000)+" sec");
	}
}

class SigleThread {
	
	private static int MaxNum = 9999999;
	private static int Counter = 0;
	
	void run() {
		
		System.out.println("SigleThread: "+Thread.currentThread());
		System.out.println("SigleThread Start: "+SigleThread.Counter);
		for(; Counter<SigleThread.MaxNum; SigleThread.Counter++) {
			
			System.out.print(Counter+", ");
			if(Counter % 100==0)
				System.out.println();
		}
		System.out.println("SigleThread End: "+SigleThread.MaxNum);
	}
}

class MultiThread extends Thread {
	
	private int MaxNum = 1999999;
	private int Counter = 0;
	
	@Override
	public void run() {
		
		thread();
	}
	
	public synchronized void thread() {
		
		System.out.println("MultiThread: "+Thread.currentThread());
		System.out.println("MultiThread Start: "+Counter);
		for(; Counter<=MaxNum; Counter++) {
			
			System.out.print(Counter+", ");
			if(Counter % 100==0)
				System.out.println();
		}
		System.out.println("MultiThread End: "+Counter);
	}
}