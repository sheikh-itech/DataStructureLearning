package ds.hk.io_streams;

import java.io.File;
import java.io.FileOutputStream;

public class SequenceOutputStreamDemo {

	public static void main(String[] args) throws Exception {

		FileOutputStream stream1 = new FileOutputStream(new File("files/SequenceInputStream1.txt"), true);
		FileOutputStream stream2 = new FileOutputStream(new File("files/SequenceInputStream2.txt"), true);
		
		stream1.write(97);
		stream1.write(98);
		stream1.write(99);
		stream1.write('a');
		stream1.write('z');
		
		stream2.write(97);
		stream2.write(98);
		stream2.write(99);
		stream2.write('a');
		stream2.write('z');
		
		stream1.close();
		stream2.close();
	}
}
