/**
 * 
 */
package view;

import java.awt.Color;
import java.util.Scanner;

/**
 * @author Crenier Amaury
 *
 */
public class StrategoConsole {
	
	public StrategoConsole() {
	}
	
	public void demarrerJeu() {
		System.out.println("STRATEGO REMASTERED");
		System.out.println("------------------------------");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Lancer une nouvelle partie ? y/n  ");
		String yn = scan.nextLine();
		switch (yn) {
		case "y": System.out.println("Nouvelle partie"); break;
		case "n": System.out.println("Aurevoir"); break;
		default: System.out.println("Entrée non valide"); break;
		}
	}
	
	public void nouveauJoueur(int x) {
		System.out.println("Création du joueur " + x);
	}
	
	public String demanderNom() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Quel est votre nom ?");
		String yn = scan.nextLine();
		return yn;
	}
	public Color demanderCouleur() {
		Color couleur = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("Choisissez une couleur: rouge ou bleu");
		String yn = scan.nextLine();
		switch (yn) {
		case "rouge": couleur = Color.RED; break;
		case "bleu": couleur = Color.BLUE; break;
		default: System.out.println("Entrée non valide");
		}
		return couleur;
	}
	
	public void affichageJoueurs(String joueur1, String joueur2) {
		System.out.println("JOUEUR 1: " + joueur1);
		System.out.println("JOUEUR 2: " + joueur2);
	}
	
	
	public void introAffichageReserve() {
		System.out.println(" ---- Réserve du joueur ----");
	}
	
	public void afficherReservePion(String unite, int compteur) {
		System.out.println(unite + ": " + compteur);
	}
	
	public  int demanderPositionX() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Placer le pion sur quelle colonne ?");
		return scan.nextInt();
	}
	public  int demanderPositionY() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Placer le pion sur quelle ligne ?");
		return scan.nextInt();
	}
	
	public int demanderPionX() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Sur quelle colonne est le pion à déplacer ?");
		return scan.nextInt();
	}
	
	public int demanderPionY() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Sur quelle ligne est le pion à déplacer ?");
		return scan.nextInt();
	}
	
	public String achatOuDeplacement() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Voulez vous acheter une unité ou vous déplacer ?");
		return scan.nextLine();
	}
	
	public String acheterPion() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Quelle unité voulez vous acheter ?");
		return scan.nextLine();
	}
}