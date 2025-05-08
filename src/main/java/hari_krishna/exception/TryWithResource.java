package hari_krishna.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {

	public static void main(String[] args) {

		try (MyResource res = new MyResource()) {
            System.out.println("Inside try block");
            throw new Exception("Exception in try block");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());

            // Can read Auto-Closable Exception using Suppressed Errors
            
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
		
		// Just Example no sample data- data.txt
		
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // br is automatically closed here

	}
}

class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing resource...");
        throw new Exception("Exception in close()");
    }
}