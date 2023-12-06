package hari_krishna.multithread;

public class AnonymousRunner {

	public static void main(String[] args) {

		new Thread(new Runnable() {
			
			@Override
			public void run() {

				System.out.println("Inline/Anonymous Runner Thread");
			}
		}).start();
	}
}
