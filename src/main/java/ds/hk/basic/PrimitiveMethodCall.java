package ds.hk.basic;

/**
 * 
 * If we pass primitive values to method parameter, and if that parameter's
 * value changed then it won't affect Original Values
 *
 */
public class PrimitiveMethodCall {

	static int value1 = 10;
	static String name = "hapheej";
	
	PrimitiveMethodCall(){
		
		//WE can not call Constructor from another one
		//PrimitiveMethodCall(10);
	}
	
	PrimitiveMethodCall(int a){
		
	}
	
	public static void main(String[] args) {

		System.out.println("Original value: "+value1);
		System.out.println("Modified By Parameter value: "+method1(value1));
		System.out.println("Again Original value: "+value1);
		
		System.out.println();
		
		System.out.println("Original name: "+name);
		System.out.println("Modified By Parameter name: "+method2(name));
		System.out.println("Again Original name: "+name);

	}
	
	static int method1(int value) {
		
		return value+5;
	}
	
	static String method2(String name) {
		
		return "sheikh "+name;
	}

}
