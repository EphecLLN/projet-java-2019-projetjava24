/**
 * 
 */
package multijoueur;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author florent janssens
 *
 */
public class Serveur {

	
	public static void main(String args) {
		
		System.out.println("Je suis le serveur");
		
		
		
		
		try {
			
			InetAddress add = InetAddress.getLocalHost();
			System.out.println(add);//affiche l'addresse ip de la machine	
			
		} catch(UnknownHostException e) {
			e.printStackTrace();	
		}
		
		
		try {
			
			ServerSocket sS = new ServerSocket(4242); //creation d'un nouveau Serveur socket
			System.out.println(sS.getLocalPort());//pour récupérer le port en console 
			sS.setSoTimeout(10000);
			
			Socket s = sS.accept();
			
			PrintWriter out = new PrintWriter(s.getOutputStream());//pour passer le message du serveur au client
			out.println("message");
			out.flush();
			
			
			sS.close();
			s.close();
			
		}  catch(IOException e) {
			
		}
	}
	
}
