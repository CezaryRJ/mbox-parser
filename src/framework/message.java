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
	
}
