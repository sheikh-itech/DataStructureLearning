package ds.hk.inner_class;

public class AnonymousClassRunnable {

	public static void main(String[] args) {

		A1 a = new A1();
		
		a.m1(new Runnable() {
			
			{
				System.out.println("Non Static Block");
			}
			
			@Override
			public void run() {

				System.out.println("Runnable anonymous class");
			}
		});

	}

}

class A1 {
	
	void m1(Runnable r) {
		r.run();
	}
}