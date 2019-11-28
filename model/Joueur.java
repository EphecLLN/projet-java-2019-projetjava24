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
	
	//m�thodes
	/**
	 * Le joueur choisi un type d'unit� � acheter et un nouveau Pion est cr�� et ajou� � la r�serve.
	 * le solde est diminu� du prix de l'unit�.
	 * @param unite, le type d'unit�
	 */
	public void acheterUnite(Unite unite) {
		Pion newPion = new Pion(unite);
		reserve.add(newPion);
		solde -= unite.getPrice();
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
}
