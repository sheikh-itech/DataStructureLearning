package hari_krishna.io_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.SequenceInputStream;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws Exception {

		FileInputStream stream1 = new FileInputStream(new File("files/SequenceInputStream1.txt"));

		FileInputStream stream2 = new FileInputStream(new File("files/SequenceInputStream2.txt"));
		
		SequenceInputStream sequence = new SequenceInputStream(stream1, stream2);
		
		int val=0;
		while((val = sequence.read())!=-1) {
			System.out.print((char)val);
		}
		
		sequence.close();
		stream1.close();
		stream2.close();
	}
}
