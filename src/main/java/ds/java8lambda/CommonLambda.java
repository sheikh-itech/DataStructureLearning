package ds.java8lambda;

public class CommonLambda {

	public static void main(String[] args) {
		
		lambdaAndThread();

		//Without Lambda [With Java-7]
		
		HelloWorld hello = new HelloWorld();
		
		greeting(hello);

		
	//With Lambda
		
		Greet myLambda = () -> System.out.println("Hello Urdu");
		
		greeting(myLambda);
		
		greeting(() -> System.out.println("Hello Urdu"));
		
		
	//Anonymous Implementation [Anonymous & Lambda-> both are diff concept]
		
		Greeting anonymousGreet = new Greeting() {
			
			public void greet1() {
				System.out.println("Hello Anonymous2");
			}
			
			public void greet2() {
				System.out.println("Hello Anonymous1");
			}
			
		};
		anonymousGreet.greet1();
		anonymousGreet.greet2();
		
	}
	
	private static void lambdaAndThread() {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Runnable-Anonymous");
			}
		});
		t1.start();
		
		Thread t2 = new Thread(()->System.out.println("Inside Runnable-Lambda"));
		t2.start();
	}

	public static void greeting(Greet greet) {
		
		greet.greet();
	}
	
	public static void greeting1(String greet) {
		
	}
}

interface Greet {
	
	public void greet();
}

class HelloWorld implements Greet {

	@Override
	public void greet() {
		System.out.println("Hello World!");
	}
}

class UrduWorld implements Greet {

	@Override
	public void greet() {
		System.out.println("Khushamdeed!");
	}
}

interface Greeting {
	public void greet1();
	public void greet2();
}