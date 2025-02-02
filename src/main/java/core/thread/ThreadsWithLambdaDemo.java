package core.thread;

public class ThreadsWithLambdaDemo {

	public static void main(String[] args) {

		// Lambda Runnable thread
		
		Runnable run = ()-> {
			System.out.println("Thread with lambda");
		};
		
		Thread th1 = new Thread(run);
		th1.start();
		
		Thread th2 = new Thread(() -> System.out.println("Thread with lambda"));
		th2.start();
		
		
		Student stu1 = (name) -> {
			return name+" is software engineer!";
		};
		System.out.println(stu1.getBio("Hapheej"));
		
		
		Student stu2 = name -> {
			return name + " is software engineer!";
		};
		System.out.println(stu2.getBio("Hapheej"));
		
		
		// No return needed without curly brackets
		Student stu3 = name -> name + " is software engineer!";
		
		System.out.println(stu3.getBio("Hapheej"));
		
	}
}

interface Student {
	
	public String getBio(String name);	
}
