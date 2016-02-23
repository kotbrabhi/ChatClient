package ma.ensao.chat.client.main;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import ma.ensao.chat.client.communication.Connexion;

public class Client {

	public static Socket socket = null ;
	public static Thread t1 ; 

	public static void main(String[] args) {

		try{
			System.out.println("Demande de connexion");
			socket = new Socket("127.0.0.1",2009);
			System.out.println("Connexion �tablie avec me serveur , authentification :");
			t1 = new Thread(new Connexion(socket));
			t1.start();
		}catch(UnknownHostException e){
			System.err.println("Impossible de se connecter � "+socket.getLocalAddress());
			}
		catch(IOException e){
			System.err.println("Aucun serveur � l'ecoute du port :"+socket.getLocalPort());
		}

	}

}
