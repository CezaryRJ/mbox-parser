package framework;
import java.util.HashMap;

public class message {

	HashMap<String, String> headers = new HashMap<String, String>();
	
	
	
	void add_header(String name, String data) {
		
		headers.put(name,data);
		
	}
	
	public String get_header(String name) {
		return headers.get(name);
	}
	
	
	public void print_headers() {
		
		for (String name: headers.keySet()) {
			if(name != "Content") {
				 String key = name.toString();
			    String value = headers.get(name).toString();
			    System.out.println(key + " " + value);
			}
		   
		}
		
	}
	
	public HashMap<String, String> parse_content_type(){
		
		String tmp = get_header("Content-Type");
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
		
		return out;
	}
	
}
