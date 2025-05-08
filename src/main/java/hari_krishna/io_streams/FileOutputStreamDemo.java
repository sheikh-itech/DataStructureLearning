package hari_krishna.io_streams;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws Exception {

		FileOutputStream stream = new FileOutputStream(new File("files/FileInputOutputStream.txt"), true);
		
		stream.write(97); // Writes in ASCII characters
		stream.write(98);
		stream.write(99);
		stream.write('a');
		stream.write('z');
		
		stream.close();
	}
}
