package unite;

import java.awt.Color;

/**
 * 
 * @author Crenier Amaury
 *
 */

public class Joueur {
	
	private String pseudo;
	private Color couleur;
	private int id;
	private int reserve;
	
	/**
	 * @param pseudo
	 * @param id 1 ou 2
	 * 
	 */
	public Joueur(String pseudo, int id) {
		this.pseudo = pseudo;
		this.id = id;
		this.reserve = 20;
		if(id == 1) {
			this.couleur = Color.BLUE;
		}
		else {
			this.couleur = Color.RED;
		}
	}
	
	public String getPseudo() {
		return this.pseudo;
	}
	public Color getCouleur() {
		return this.couleur;
	}
	public int getReserve() {
		return this.reserve;
	}
	public int getId() {
		return this.id;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Le joueur choisi un type d'unité à acheter et un nouveau Pion est créé.
	 * @param soldat, le type d'unité
	 * @return newSoldat, le Pion créé de type soldat
	 */
	public Pion acheter(Unite soldat) {
		Pion newSoldat = new Pion(soldat);
		reserve = reserve + 1;
		return newSoldat;
	}
	
	/**
	 * Renvoie le coût d'une Unite.
	 * @param soldat, l'Unite
	 * @return le coût
	 */
	public int payer(Unite soldat) {
		return soldat.getPrice();
	}
	
	/**
	 * Permet de savoir si le joeur est prêt à jouer car il n'a pas de pions en réserve.
	 * @return true, si la réserve est égale à zéro (vide)
	 */
	public boolean estPret() {
		return reserve == 0;
	}
	
	/**
	 * Permet de diminuer la réserve de une unité.
	 */
	public void retirerReserve() {
		reserve = reserve - 1;
	}
}
