package framework;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class mbox {
	
	public ArrayList<message> msg = new ArrayList<message>();
	
	
	public void read_file(String filename) throws FileNotFoundException {
		
		  File mboxfile = new File(filename);
		  
	   
		  Scanner scanner = new Scanner(mboxfile);
		  
		  if(!scanner.hasNextLine()) {
			  return;
		  }
		  
		  String line = scanner.nextLine();
		  
		  if(line.length() == 0) {
			  line = scanner.nextLine();
		  }
		  
		  try {
			
			if(!line.substring(0,4).equals("From")) {
				System.out.println("Line is not envelope - ERROR");
				return;
			}
		  
		  }
		  catch(StringIndexOutOfBoundsException e){
			  return;
		  }
		  
			while(scanner.hasNextLine()) {

				  message new_msg = new message();
				  
				  read_headers(new_msg,scanner);
				  
				  read_content(new_msg,scanner);
				  
				  msg.add(new_msg);
				  
				  //new_msg.print_headers();
				  
				  //System.exit(0);
				  
			}
		
	}
		
		 
	void read_headers(message msg,Scanner scanner) {

		
		String[] tmp;
		String name = "";
		String data = "";
		while(scanner.hasNextLine()) {
			
			tmp = scanner.nextLine().split(": ",2);
			
			if(tmp[0].equals("")) {
				break;
			}
			
		
			if(tmp.length == 1) {
				data += "\n" + tmp[0];
				while(scanner.hasNextLine()) {
					tmp = scanner.nextLine().split(": ",2);
					
					if(tmp.length > 1) {
						break;
					}
					
					data += "\n" + tmp[0];
					//System.out.println(data);
				}
				msg.add_header(name, data);
				
				name = tmp[0];
				data = tmp[1];
				msg.add_header(name, data);

				
			}else{
				name = tmp[0];
				data = tmp[1];
				msg.add_header(name, data);
			}

			
		}
		
		
	}
	
	void read_content(message msg,Scanner scanner) {
		
		String line1 = "";
		String line2 = "";
		
		String data = "";
		
		while(scanner.hasNextLine()) {
			
		
			line1 = line2;
			
			line2 = scanner.nextLine();
			
			data += "\n" + line2;
			
			if(line2.length() > 3 && line1.equals("") && line2.substring(0,4).equals("From")) {
			
				break;
			}
			
			
			//System.out.println(data);
			
		}
		
		msg.add_header("Content", data);
		
	}
		
		  
	
}
