
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import framework.mbox;


public class main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		mbox test = new mbox();
		
		test.read_file("Testtest.mailcl");
		
		System.out.println(test.msg.size());

	}

}
