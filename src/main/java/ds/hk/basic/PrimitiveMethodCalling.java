package ds.hk.basic;

public class PrimitiveMethodCalling {

	public static void main(String[] args) {
		
		primitiveMethod((byte)10);
		primitiveMethod(20);
		primitiveMethod('c');
		primitiveMethod(50L);
		
		//The method primitiveMethod(long) in the type PrimitiveMethodCalling 
		//is not applicable for the arguments (double)
		//primitiveMethod(40.0);
		
		//The method primitiveMethod(long) in the type PrimitiveMethodCalling 
		//is not applicable for the arguments (float)
		//primitiveMethod(40.0f);
		
		primitiveMethod(Byte.valueOf((byte)10));
		primitiveMethod(Short.valueOf((short)20));
		primitiveMethod(new Character('a'));
		primitiveMethod(new Long(10L));
		
		//The method primitiveMethod(long) in the type PrimitiveMethodCalling 
		//is not applicable for the arguments (Float)
		//primitiveMethod(new Float(10.0f));
		
		//The method primitiveMethod(long) in the type PrimitiveMethodCalling 
		//is not applicable for the arguments (Double)
		//primitiveMethod(new Double(10.0d));
		
		
		
	}
	
	static void primitiveMethod(long value) {
		System.out.println("value: "+value);
	}

}
