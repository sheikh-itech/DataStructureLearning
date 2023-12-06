package hari_krishna.io_streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {

		FileReader reader = new FileReader(new File("files/BufferedWriter.txt"));
		
		BufferedReader buffer = new BufferedReader(reader);
		
		String str;
		while( (str=buffer.readLine()) != null) {
			System.out.println(str);
		}
		buffer.close();
	}
}
