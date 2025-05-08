package hari_krishna.exception;

import java.io.IOException;

public class ChainedException {

	public static void main(String[] args) {

		try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	static void method1() throws Exception {
        try {
            method2();
        } catch (IOException ioe) {
            throw new Exception("Failed in method1", ioe); // Chained Exception
        }
    }

    static void method2() throws IOException {
        throw new IOException("Disk not found");
    }
}
