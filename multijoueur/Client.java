/**
 * 
 */
package multijoueur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author florent janssens
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Je suis le client");
		
		try {
			Socket s = new Socket ("192.168.1.33", 4242);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));// pour recevoir le message du serveur
			System.out.println(in.readLine());
			in.close();
			s.close();
	
		} catch(IOException e) {
			e.printStackTrace();
			
		}


	}

}
