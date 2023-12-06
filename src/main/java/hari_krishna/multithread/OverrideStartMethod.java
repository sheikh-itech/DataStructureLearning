package hari_krishna.multithread;

public class OverrideStartMethod {

	public static void main(String[] args) {

		new CustomStartThread().start();
	}
}

class CustomStartThread extends Thread {
	
	@Override
	public void start() {
		System.out.println("Custom start method");
		super.start();
	}
	
	@Override
	public void run() {
		System.out.println("Subclass run method");
	}
}