package hari_krishna.exception;

public class ExceptionDeclaration {

}

// First Way

class MyEx1 extends Error {
	
	private static final long serialVersionUID = 1L;
	
}


//	Second Way
class MyEx2 extends Throwable {
	
	private static final long serialVersionUID = 1L;
	
}


//	Third Way
class MyEx3 extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
}
