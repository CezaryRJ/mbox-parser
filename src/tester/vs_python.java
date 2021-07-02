package tester;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;

import framework.mbox;

public class vs_python extends test{

	public vs_python() throws IOException {
		super("vs_python","C:\\Users\\Cezary\\Documents\\GitHub\\mbox-parser\\Python\\read_mbox.py");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean run_test() throws IOException, InterruptedException {
		
		
		
		Iterator<String> it = data.iterator();
		
		String tmp;
		while(it.hasNext()) {
			
			mbox s = new mbox();
			
			tmp = it.next();
			System.out.println(tmp);
			s.read_file(tmp);
			
			//System.out.println(s.msg.size());
			
			Process p = Runtime.getRuntime().exec("python " + python_prog_location + " " + tmp);
			
			p.waitFor();
			  
			Scanner scan = new Scanner(new File(settings.get("results") + "\\p"));
			
			int p_num = Integer.parseInt(scan.nextLine());
			
			if (s.msg.size() != p_num) {
				System.out.println("Java = " + s.msg.size());
				System.out.println("Python = " + p_num);
				//System.out.println("python " + python_prog_location + " " + tmp);
				System.out.println(tmp);
				//System.exit(p_num);
				//return false;
			}
			
		}
		
		return true;
	}



}
