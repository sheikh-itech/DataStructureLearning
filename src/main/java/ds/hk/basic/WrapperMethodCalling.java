package ds.hk.basic;

public class WrapperMethodCalling {

	
	/**
	 * Wrapper class objects are not compatible with each others
	 * All are siblings [Byte, Short, Character, Integer, Long, Float, Double]
	 */
	public static void main(String[] args) {

		//The method primitiveMethod(Long) in the type WrapperMethodCalling 
		//is not applicable for the arguments (byte)
		//primitiveMethod((byte)10);
		
		//The method primitiveMethod(Long) in the type WrapperMethodCalling 
		//is not applicable for the arguments (int)
		//primitiveMethod(20);
		
		//The method primitiveMethod(Long) in the type WrapperMethodCalling 
		//is not applicable for the arguments (char)
		//primitiveMethod('c');
		
		primitiveMethod(50L);
		
		//The method primitiveMethod(Long) in the type WrapperMethodCalling 
		//is not applicable for the arguments (double)
		//primitiveMethod(40.0);
		
		//The method primitiveMethod(Long) in the type WrapperMethodCalling 
		//is not applicable for the arguments (float)
		//primitiveMethod(40.0f);
		
		//Siblings classes not allowed
		//primitiveMethod(new Byte((byte)10));
		
		//Siblings classes not allowed
		//primitiveMethod(new Short((short)20));
		
		//Siblings classes not allowed
		//primitiveMethod(new Character('a'));
		
		primitiveMethod(new Long(10L));
		
		//Siblings classes not allowed 
		//primitiveMethod(new Float(10.0f));
		
		//Siblings classes not allowed
		//primitiveMethod(new Double(10.0d));
		

	}
	
	static void primitiveMethod(Long value) {
		System.out.println("value: "+value);
	}

}
