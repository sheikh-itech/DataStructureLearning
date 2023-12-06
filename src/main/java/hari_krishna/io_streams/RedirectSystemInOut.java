package hari_krishna.io_streams;

import java.io.PrintStream;

public class RedirectSystemInOut {

	public static void main(String[] args) throws Exception {

		PrintStream out = new PrintStream("files/output.txt");
		
		System.setOut(out);
		
		System.out.print("Writing/Reading to/from File");
	}
}
