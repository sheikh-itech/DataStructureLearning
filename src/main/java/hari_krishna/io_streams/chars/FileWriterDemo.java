package hari_krishna.io_streams.chars;

import java.io.File;
import java.io.FileWriter;

public class FileWriterDemo {

	public static void main(String[] args) throws Exception {

		FileWriter writer = new FileWriter(new File("files/FileWriter.txt"));
		
		writer.write("Java is Object Oriented Programming Language");
		writer.flush();
		writer.close();
	}
}
