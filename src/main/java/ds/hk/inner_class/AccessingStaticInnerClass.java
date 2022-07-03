package ds.hk.inner_class;

public class AccessingStaticInnerClass {

	static class StaticClass {
		
		void m1(String msg) {
			System.out.println(msg);
		}
		
		static void m2(String msg) {
			System.out.println(msg);
		}
		
		private void m3() {
			System.out.println("Inner Private Method");
		}
	}
	
	public static void main(String [] args) {
		
		StaticClass.m2("Static Inner Class/Method");
		
		StaticClass cls = new StaticClass();
		cls.m1("Non Static Inner Class/Method\n");
		cls.m3();
		
		StaticInnerClassTest.main();
	}
}

class StaticInnerClassTest {
	
	public static void main() {
		
		AccessingStaticInnerClass.StaticClass.m2("Static Inner Class/Method::Outside Class");
		
		AccessingStaticInnerClass.StaticClass cls = 
				new AccessingStaticInnerClass.StaticClass();
		
		cls.m1("Non Static Inner Class/Method::Outside Class");
	}
}