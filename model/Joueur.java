package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * 
 * @author Crenier Amaury
 *
 */

public class Joueur {
	
	private String pseudo;
	private Color couleur;
	private int solde;
	private ArrayList<Pion> enJeu;
	private ArrayList<Pion> reserve;
	private ArrayList<Pion> cimetiere;
	
	//constructeur
	public Joueur(String pseudo, Color couleur) {
		this.pseudo = pseudo;
		reserve = new ArrayList<Pion>();
		solde = 0;
		this.couleur = couleur;
		cimetiere = new ArrayList<Pion>();
	}
	
	//getters
	public String getPseudo() {
		return this.pseudo;
	}
	public Color getCouleur() {
		return this.couleur;
	}
	public ArrayList<Pion> getReserve() {
		return this.reserve;
	}
	public int getSolde() {
		return this.solde;
	}
	public ArrayList<Pion> getCimetiere(){
		return this.cimetiere;
	}
	public ArrayList<Pion> getEnJeu(){
		return this.enJeu;
	}
	
	//setters
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	public void setReserve(ArrayList<Pion> reserve) {
		this.reserve = reserve;
	}
	public void setSolde(int solde) {
		this.solde = solde;
	}
	public void setCimetiere(ArrayList<Pion> cimetiere) {
		this.cimetiere = cimetiere;
	}
	public void setEnJeu(ArrayList<Pion> enJeu) {
		this.enJeu = enJeu;
	}
	
	public String toString() {
		String couleurStr = "";
		if (couleur == Color.RED) {
			couleurStr = "rouge";
		}
		else couleurStr = "bleu";
		return pseudo + ", " + couleurStr + ", solde en banque: " + solde + " pi�ces.";
	}
	
	//m�thodes
	/**
	 * Le joueur choisi un type d'unit� � acheter et un nouveau Pion est cr�� et ajou� � la r�serve.
	 * le solde est diminu� du prix de l'unit�.
	 * @param unite, le type d'unit�
	 */
	public void acheterUnite(Unite unite) {
		if (solde >= unite.getDeplace()) {
		Pion newPion = new Pion(unite);
		reserve.add(newPion);
		solde -= unite.getPrice();
		}
		else {
			System.out.println("Solde insuffisant!");
		}
	}
	
	/**
	 * Augmentation du solde de 25.
	 */
	public void genererSoldeParTour() {
		solde += 25;
	}
	
	/**
	 * Permet de savoir si le joeur est pr�t � jouer car il n'a pas de pions en r�serve.
	 * @return true, si la r�serve est �gale � z�ro (vide)
	 */
	public boolean estPret() {
		return reserve.size() == 0;
	}
	
	/**
	 * Ajoute les 20 pions de d�part � la r�serve.
	 */
	public void initReserveDepart() {
		reserve.add(new Pion(Unite.DRAPEAU));
		for(int i = 1; i <= 3; i ++) {
			reserve.add(new Pion(Unite.BOMBE));
		}
		reserve.add(new Pion(Unite.SABOTEUR));
		reserve.add(new Pion(Unite.GENERAL));
		reserve.add(new Pion(Unite.TANK));
		reserve.add(new Pion(Unite.ESPION));
		for(int i = 1; i <= 3; i ++) {
			reserve.add(new Pion(Unite.DEMINEUR));
		}
		for(int i = 1; i <= 5; i ++) {
			reserve.add(new Pion(Unite.ECLAIREUR));
		}
		for(int i = 1; i <= 5; i ++) {
			reserve.add(new Pion(Unite.CAPORAL));
		}
	}
	
	public int compteurReserve(ArrayList<Pion> reserve, String unite) {
		int compteur = 0;
		for (int i = 0; i < reserve.size(); i++) {
			if (reserve.get(i).getUnite().getName() == unite) {
				compteur++;
			}
		}
		return compteur;
	}
}
