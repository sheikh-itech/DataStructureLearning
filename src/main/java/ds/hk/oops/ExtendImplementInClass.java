package ds.hk.oops;

/**
 * 1. Class can implement multiple interfaces
 * 2. Interface can extend multiple interfaces
 * 3. Class can extend 1 class and implement multiple interfaces
 * 
 * Can Not
 * 1. Class cann't extend 2 classes
 * 2. Class cann't implement interface followed by extending another class
 */

public class ExtendImplementInClass {

	public static void main(String[] args) {

	}
}

interface I1 {
	
}

interface I2 {
	
}

class AA {
	
}

class AB {
	
}

class BB implements I1, I2 {
	
}

class CC extends AA implements I1, I2 {
	
}

interface DD extends I1, I2 {
	
}

//Syntax error on token ",", . expected

/*class EE extends AA, AB {
	
}*/

//Syntax error on token "extends", . expected

/*class FF implements I1 extends AA {
	
}*/