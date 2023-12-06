package hari_krishna.basic;

/**
 * @author Hapheej
 * 
 *	This class having different examples related to identifiers
 *	identifiers --> class name, method name, variable names
 *
 */
public class Identifiers {

	//Defining identifiers --> Must start with Character, '$' OR '_'
	// Identifiers can have --> [a-z], [A-Z], $, _
	
	int __ = 10;
	int $$ = 10;
	int __$$ = 10;
	int $$__ = 10;
	int $_$ = 10;
	int _$_ = 10;
	
	final int finalNum = 10;
	static int staticNum = 10;
	
	//int static num1; CE::Syntax Error
	static int num1;
	
	// Invalid character constant
	//char ch = '';
	char ch = ' ';
	
	String str = "";
	
	//Below defined all identifiers are invalid [Compilation error]
	
	//int 12sdt;
	//int sg adt;
	//int dght#hgf;
	
	long lon = 50;
	long lon1 = 'c';
	//Type mismatch: cannot convert from int to Long
	//Long lon1 = 50;
	Long lon2 = 50L;
	
	int i1 = 10;
	int i2 = 'a';
	Integer i3 = 50;
	
	byte b1 = 10;
	//Type mismatch: cannot convert from int to byte
	//byte b2 =128;
	byte b2 = 127;
	byte b3 = 'Z';
	
	short s1 = 10;
	//Type mismatch: cannot convert from int to short
	//short s2 = 32768;
	short s3 = 32767;
	short s4 = 'Z';
	
	 
	
	
	void reassign() {
		
		staticNum = 11;
		
		//Final variable can not be re-assigned, CE::Error
		//finalNum = 11;
		
		System.out.println("staticNum: " + staticNum);
		System.out.println("finalNum: " + finalNum);
	}
	public static void main(String[] args) {
		
		Identifiers i = new Identifiers();
		i.reassign();
		
		System.err.println("------------");
		System.out.println("__ =" + i.__);
		System.out.println("$$ =" + i.$$);
		System.out.println("__$$ =" + i.__$$);
		System.out.println("$$__ =" + i.$$__);
		System.out.println("$_$ =" + i.$_$);
		System.out.println("_$_ =" + i._$_);
		
		/**
		 * 	Very Important Point To Remember
		 * 
		 * Wrapper class object with same values within byte range
		 * always refers to same Object (Single object for 2 wrapper reference)
		 * 
		 *  But if values assigned beyond byte range then separate objects are created
		 *  
		 *  Refer below examples
		 */
		Integer i1 = 50;
		Integer i2 = 50;
		System.out.println("i1==i2: " +(i1 == i2));
		
		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println("i3==i4: " +(i3 == i4));
	}

}
