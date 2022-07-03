package ds.hk.inner_class;

public class AccessMethodLocalInnerClass {

	public AA m1() {
		
		System.out.println("Outer Class Method");
		class A implements AA {
			
			public void m1() {
				System.out.println("Method Loacl Inner Class");
			}
		}
		return new A();
	}
	
	void m2(AA a) {
		
		System.out.println("Inner Class Reference In Outer Class Method, Inner hashcode:: "+a);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Main Method");
		AccessMethodLocalInnerClass am = new AccessMethodLocalInnerClass();
		AA aa = am.m1();
		aa.m1();
		am.m2(aa);
	}

}

interface AA {
	void m1();
}