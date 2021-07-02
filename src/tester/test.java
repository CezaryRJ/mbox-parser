package tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class test {


	 HashMap<String,String> settings = new  HashMap<String,String>();
	 
	 File[] data;
	 
	 public String name;
	 
	 String python_prog_location;
	 
	 public test(String name, String python_prog_location) throws IOException {
		 read_settings();
		 this.data = scan_dir();
		 this.name = name;
		 this.python_prog_location = python_prog_location;
		 
	 }
		
	
	public void read_settings() throws FileNotFoundException{
		
		
		 File file = new File("Settings.txt");
	     Scanner scanner = new Scanner(file);
	     
	     
	     String[] tmp;
	     while(scanner.hasNextLine()) {
	    	 tmp = scanner.nextLine().split(" = ");
	    	 settings.put(tmp[0],tmp[1]);
	    	 
	     }
	     
	}
	
	
	public File[] scan_dir() throws IOException {
		
		 File[] fileList = new File(settings.get(data)).listFiles(new FilenameFilter() {
		        public boolean accept(File arg0, String name) {
		            return name.endsWith(".mailcl");
		        }
		    });
		 
	    return fileList;
	}
	
	public String get(String inn) {
		
		return settings.get(inn);
	}
	
	public abstract boolean run_test() throws IOException, InterruptedException ;

	
}