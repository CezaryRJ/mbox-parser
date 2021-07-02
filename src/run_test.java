import java.io.IOException;
import tester.test;
import tester.vs_python;

public class run_test {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		print_res(new vs_python());
		
		
	}
	
	public static void print_res(test a) throws IOException, InterruptedException {
		
		if (a.run_test()) {
			System.out.println("Test |  " + a.name + " result = PASS");
		}
		else {
			System.out.println("Test |  " + a.name + " result = FAIL");
		}
		
	}
	
}
