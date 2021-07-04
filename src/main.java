
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import framework.mbox;


public class main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		String a = "multipart/related; boundary=\"----MIME delimiter for sendEmail-339477.5390625\"";
		
		String tmp = a;
		String[] tmplist = null;
		if(tmp != null){
			tmplist = tmp.split(";");
		}
		for(int i = 0;i<tmplist.length;i++) {
			tmplist[i] = tmplist[i].trim();
		}
		
		HashMap<String,String> out = new HashMap<String,String>();
		
		String[] split2 = null;
		String name = null;
		String value = null;
		
		for(int i = 1;i<tmplist.length;i++) {
			split2 = tmplist[i].split("=");
			
			name = split2[0].trim();
			value = split2[1].trim();
			
			//System.out.println(value.charAt(0));
			
			if(value.charAt(0) == '\"') {//quoted string
				//System.out.println(value.substring(1,value.length()-2));
				out.put(name,value.substring(1,value.length()-2));
			}else {//token
				out.put(name, value);
			}
			
		
		}
	}

}
