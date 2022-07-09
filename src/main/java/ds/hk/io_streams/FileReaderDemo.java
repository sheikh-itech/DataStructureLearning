package ds.hk.io_streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		FileReader reader = new FileReader(new File("files/FileWriter.txt"));
		
		int val;
		while( (val = reader.read()) != -1) {
			
			System.out.print((char)val);
		}
		
		reader.close();
	}
}
