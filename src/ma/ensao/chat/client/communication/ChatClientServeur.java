package ma.ensao.chat.client.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientServeur implements Runnable {

	private Socket socket ;
	private PrintWriter out = null;
	private BufferedReader in = null ;
	
	public ChatClientServeur(Socket s) {
		socket = s;
	}

	@Override
	public void run() {
		try{
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Thread t4 = new Thread(new Emission(out));
			t4.start();
			Thread t3 = new Thread(new Reception(in));
			t3.start();
		}catch(IOException e){
			System.err.println("Le serveur distant s'est deconnecté");
		}
	}

}
