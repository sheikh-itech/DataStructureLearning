package hari_krishna.multithread;

public class AnonymousThread {

	public static void main(String[] args) {

		(new Thread() {
			
			public void run() {
				
				System.out.println("Inline/Anonymous Thread");
			}
			
		}).start();
	}
}
