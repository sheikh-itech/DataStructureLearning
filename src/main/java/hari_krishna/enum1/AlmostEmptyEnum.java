package hari_krishna.enum1;

/**
 * If we don't want Named Constant then we must start with ';' 
 * OR with constructor
 */

public enum AlmostEmptyEnum {

	;	//This is for Empty/No Named Constant
	int num = 10;
	
	//Illegal modifier for the enum constructor; only private is permitted.
	/*public AlmostEmptyEnum() {
		
	}*/
	
	//Illegal modifier for the enum constructor; only private is permitted.
	/*protected AlmostEmptyEnum() {
		
	}*/
}
