package ds.hk.enum1;

/**
 * Semicolon required after OR before Constructor, if Named Constants Not Defined
 */

public enum EnumWithConstructor {

	;
	EnumWithConstructor() {
		
	}
	// Above and this both constructor will work
	/*EnumWithConstructor() {
		
	};*/
	
	int num = 10;
	static int NUM = 20;
}

enum EnumWithConstructorAndNamedConstant {

	DEF1, DEF2;
	
	EnumWithConstructorAndNamedConstant() {
		
	}
	
	int num = 10;
	static int NUM = 20;
}