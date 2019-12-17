package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClient {

	public static final int port = 13999;
	public static InetAddress host;
	public static Socket socketS;
	public static Socket socketC;
	public static ServerSocket server;
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
	public static String reception;
	
	public static void newClient(String courrier) throws IOException, ClassNotFoundException, InterruptedException {
		
		System.out.println("CLIENT START");

        socketC = null;
        oos = null;
        ois = null;
        
        socketC = new Socket(host.getHostName(), port);
        oos = new ObjectOutputStream(socketC.getOutputStream());
        System.out.println("Sending request to Socket Server");
        send(courrier);
        ois = new ObjectInputStream(socketC.getInputStream());
        receive();
        ois.close();
        oos.close();
        socketC.close();
        //Thread.sleep(100);
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
