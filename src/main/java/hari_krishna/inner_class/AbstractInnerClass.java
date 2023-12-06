package hari_krishna.inner_class;

public class AbstractInnerClass {

	static Runnable m1(ResultNotification type) {
		
		abstract class ResultDetail implements Runnable {
			
			public void run() {
				System.out.println("Run method fo ResultDetail class");
			}
			
			abstract public void publishResult();
		}
		
		switch(type) {
		
			case MAIL:
				new ResultDetail() {

					@Override
					public void publishResult() {
						System.out.println("Result published via mail");
					}
					
				}.publishResult();
				
				break;
				
			case SMS:
				new ResultDetail() {

					@Override
					public void publishResult() {
						System.out.println("Result published via sms");
					}
					
				}.publishResult();
		}
		
		return new ResultDetail() {

			@Override
			public void publishResult() {
				
			}
			
			public void run() {
				System.out.println("Running from anonymous class");
			}
		};
	}
	
	public static void main(String[] args) {

		AbstractInnerClass.m1(ResultNotification.MAIL);
		Runnable r = AbstractInnerClass.m1(ResultNotification.SMS);
		r.run();
	}

}

enum ResultNotification {
	MAIL, SMS
}