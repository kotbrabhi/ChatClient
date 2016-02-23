package ma.ensao.chat.client.communication;

import java.io.BufferedReader;
import java.io.IOException;

public class Reception implements Runnable {

	private BufferedReader in ; 
	private String message ;
	
	public Reception(BufferedReader i) {
		in = i;
	}

	@Override
	public void run() {
		while(true){
			try{
				message = in.readLine();
				System.out.println("Le serveur vous dit :"+message);
			}catch(IOException e ){
				e.printStackTrace();
			}
		}
		
	}

}
