package core.lambda;

public class LambdaThreadDemo {

	public static void main(String []args) {
		
		Runnable lambdaRunnable = () -> System.out.println("Running from Lambda Runnable");
		new Thread(lambdaRunnable).start();
		
		new Thread(() -> System.out.println("Hello thread from lambda")).start();
		
	}
}
