package tester;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;

import framework.Mbox;
import framework.Message;

public class vs_python extends test{

	public vs_python() throws IOException {
		super("vs_python","C:\\Users\\Cezary\\Documents\\GitHub\\Mbox-parser\\Python\\read_Mbox.py");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean run_test() throws IOException, InterruptedException {

		Iterator<String> it = data.iterator();
		
		String tmp;
		while(it.hasNext()) {
			
			Mbox s = new Mbox();
			
			tmp = it.next();
			System.out.println(tmp);
			s.read_file(tmp);
			
			//System.out.println(s.msg.size());
			
			Process p = Runtime.getRuntime().exec("python " + python_prog_location + " " + tmp);
			
			p.waitFor();
			  
			ArrayList<String> p_report = read_file(settings.get("results") + "\\p");
			
			
			Iterator<Message> java = s.msg.iterator();
			
			Iterator<String> python = p_report.iterator();
			
			
			//System.out.println(s.msg.get(0).get_header("Content"));
			
			//System.exit(0);
			int index = 0;
			int error_count = 0;
			while(java.hasNext()) {
				
				Message tmp1 = java.next();
				
				int ja = tmp1.get_header("Content").length();
				
				int py = Integer.parseInt(python.next());
				
				//System.out.println("\n" + tmp1.get_header("Content"));
				
				//System.out.println(tmp1.get_header("Content"));
				
				if(ja != py) {
					error_count += 1;
					
					if(error_count == 3 || index == 12) {
					
					System.out.println(s.msg.size());
						
					System.out.println(index + "  " + ja + "  " + py);
					
					System.out.println(tmp1.get_header("Content"));
					
					System.out.println("\n\n\n\n\n\n------headers");
					
					tmp1.print_headers();
					
					try {
					System.out.println(tmp1.parse_content_type().get("boundary"));
					}
					catch(NullPointerException e) {
						
					}
						System.exit(py);
					}
					
				//	System.exit(py);
				}
				
				index += 1;
			}
			
			
		}
		
		return true;
	}



}
