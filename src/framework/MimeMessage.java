package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MimeMessage extends Message{
	
	
	ArrayList<part> parts;
	
	MimeMessage(HashMap<String, String> headers) {
		super(headers);
		// TODO Auto-generated constructor stub
	}
	
	
	public void read_content(Scanner scanner){
		
		if(isMultipart()) {
			
		}else {
			
		}
		
	}
	
	public boolean isMultipart() {
		
		if(headers.get("Content-Type") != null) {
			if(headers.get("Content-Type").split("/")[0].equals("multipart")) {
				return true;
			}
		}
		return false;
	}

	private class part{
		
		HashMap<String, String> part_headers;
		
	}
	
	
	
	}
