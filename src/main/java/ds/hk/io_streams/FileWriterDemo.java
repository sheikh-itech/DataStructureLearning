package ds.hk.io_streams;

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
