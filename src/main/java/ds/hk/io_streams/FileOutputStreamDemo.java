package ds.hk.io_streams;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws Exception {

		FileOutputStream stream = new FileOutputStream(new File("files/DataInputOutputStream.txt"), true);
		
		stream.write(97);
		stream.write(98);
		stream.write(99);
		stream.write('a');
		stream.write('z');
		
		stream.close();
	}
}
