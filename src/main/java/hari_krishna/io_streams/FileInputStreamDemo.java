package hari_krishna.io_streams;

import java.io.File;
import java.io.FileInputStream;

public class FileInputStreamDemo {

	public static void main(String[] args) throws Exception {

		FileInputStream stream = new FileInputStream(new File("files/FileInputOutputStream.txt"));
		
		int val=0;
		while((val = stream.read())!=-1) {
			System.out.print((char)val);
		}
		
		stream.close();
	}
}
