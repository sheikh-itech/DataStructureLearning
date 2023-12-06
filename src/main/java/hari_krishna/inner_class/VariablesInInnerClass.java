package hari_krishna.inner_class;

public class VariablesInInnerClass {

	int num = 10; //final int num = 10; 
	//Final & Non Final Accessible from Inner Method Class
	
	Temp m1() {
		
		System.out.println("num: "+num);
		
		int num = 20; //final int num = 20; //Both Statement are same
		
		System.out.println("num: "+ num);
		System.out.println("this.num: "+ this.num);
		
		class A implements Temp {
			
			int num = 30;
			
			public void m1() {
				
				System.out.println("num: "+this.num);
				
				int num = 40;
				
				System.out.println("num: "+num);
				System.out.println("this.num: "+this.num);
			}
			
		}
		
		return new A();
	}
	public static void main(String[] args) {

		VariablesInInnerClass cls = new VariablesInInnerClass();
		Temp t = cls.m1();
		t.m1();

	}

}

interface Temp {
	
	void m1();
}