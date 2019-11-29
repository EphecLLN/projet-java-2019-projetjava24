/**
 * 
 */
package Main;

import java.util.*;

import view.PlateauConsole;

/**
 * @author Crenier Amaury
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Stratego remastered");
		System.out.println("------------------------------");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Lancer une nouvelle partie ? y/n  ");
		String yn = scan.nextLine();
		
		switch (yn) {
		case "y": System.out.println("Nouvelle partie");
		case "n": System.out.println("Aurevoir");
		default: System.out.println("Entrée non valide");
		}
		
		PlateauConsole plateau = new PlateauConsole(10, 10);
		plateau.dessinerPlateau();
		plateau.placerPion(3, 3, 5);
		plateau.dessinerPlateau();
	}
}
