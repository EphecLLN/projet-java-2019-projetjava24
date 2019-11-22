/**
 * 
 */
package multijoueur;

import java.io.IOException;
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
			sS.close();
			s.close();
			
		}  catch(IOException e) {
			
		}
	}
	
}
