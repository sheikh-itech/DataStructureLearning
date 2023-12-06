package hari_krishna.io_streams;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**		Check File Size In File Properties	<br/><br/>
 * 
 * 		int -> 4 bytes		<br/>
 * 		float -> 4 bytes		<br/>
 * 		String ->	2 bytes for double-quotes "" + 1 byte per character of string value		<br/><br/>
 * 
 * 		writeInt('A') + writeFloat(10.2f) + writeUTF("Hapheej Sheikh Mansoori")		<br/>
 * 		==> 4 + 4 + 2 (string default) + 23 	<br/>
 * 		==> 33 bytes
 */

public class DataOutputStreamDemo {

	public static void main(String[] args) throws Exception {

		FileOutputStream stream = new FileOutputStream(new File("files/DataInputOutputStream.txt"));
		
		DataOutputStream out = new DataOutputStream(stream);
		
		out.writeInt('A');
		out.writeFloat(10.2f);
		out.writeUTF("Hapheej Sheikh Mansoori");
		
		out.close();
	}
}
