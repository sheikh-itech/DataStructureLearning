package hari_krishna.io_streams;

import java.io.FileOutputStream;
import java.io.BufferedOutputStream;

public class BufferedOutputStreamDemo {

	public static void main(String[] args) throws Exception {

		FileOutputStream fos = new FileOutputStream("files/BufferedOutputStream.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		bos.write("Hello Buffered Stream".getBytes());

		bos.flush(); // force write remaining bytes
		bos.close();
		fos.close();

	}
}
