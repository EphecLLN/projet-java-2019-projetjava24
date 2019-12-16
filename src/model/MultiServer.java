package model;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

	public static final int port = 13999;
	public static InetAddress host;
	public static Socket socketS;
	public static Socket socketC;
	public static ServerSocket server;
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
	public static String reception;
	
	public static void newServer(String courrier) throws IOException, ClassNotFoundException, InterruptedException {	
		
		server = new ServerSocket(port);
		
		System.out.println("SERVEUR START");
		//server.setSoTimeout(30000);	
		
		while(true){
			System.out.println("Waiting for the client request");
			socketS = server.accept();
			ois = new ObjectInputStream(socketS.getInputStream());
			receive();
			oos = new ObjectOutputStream(socketS.getOutputStream());
			send(courrier);
			try {
				ois.readObject();
			}
			catch (EOFException ex) {
				break;
			}
			ois.close();
			oos.close();
			socketS.close();
		}
		System.out.println("Shutting down Socket server!!");
		server.close();
	}
	
	public static void send(String courrier) throws IOException {
		oos.writeObject(courrier);
		System.out.print("envoyé: " + courrier);
	}
	
	public static void receive() throws ClassNotFoundException, IOException {
		reception = (String) ois.readObject();
		System.out.print("recu: " + reception);
	}
}
