package hari_krishna.inner_class;

public class AnonymousClassImpl {

	private static int num = 10;
	
	final static int num1;
	
	static {
		num1 = 20;
	}
	
	private static String m1() {
		
		 return "Outer Class Private Method";
	}
	
	public static void main(String[] args) {
		
		new Thread() {
			
			//Logic Not Allowed @Class Level
			//System.out.println("Test");

			@Override
			public void run() {
				
				super.run();
				
				System.out.println("num: "+num);
				System.out.println("final num1: "+num1);
				System.out.println(m1());
			}
			//Logic Not Allowed @Class Level
			//System.out.println("Test");
		}.start();
	}
}
