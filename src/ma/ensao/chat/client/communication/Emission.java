package ma.ensao.chat.client.communication;

import java.io.PrintWriter;
import java.util.Scanner;

public class Emission implements Runnable {

	private PrintWriter out ; 
	private String message ;
	private Scanner in ; 
	
	public Emission(PrintWriter o) {
		out = o;
	}

	@Override
	public void run() {
		in = new Scanner(System.in);
		
		while(true){
			System.out.println("Vote message :");
			message = in.nextLine();
			out.println(message);
			out.flush();
		}
		
	}

}
