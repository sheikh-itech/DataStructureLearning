package hari_krishna.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SuperSubException {

	public static void main(String[] args) {
		
	}
}

class Super {
	
    void readFile() throws IOException, RuntimeException {
    	
    }
}

class Sub extends Super {
	
    @Override
    void readFile() throws FileNotFoundException, IllegalArgumentException {
    	
    }
}