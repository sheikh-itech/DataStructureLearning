package hari_krishna.io_streams.chars;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

	public static void main(String[] args) throws IOException {
		
		FileWriter out = new FileWriter(new File("files/BufferedWriter.txt"));
		BufferedWriter writer = new BufferedWriter(out);
		writer.write("Java is object oriented programming\n");
		writer.write("I am learning it");
		
		writer.flush();
		writer.close();
	}
}
