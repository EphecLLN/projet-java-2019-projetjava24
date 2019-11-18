package model;

/**
 * 
 * @author Crenier Amaury
 *
 */

public class Banque {
	
	private Solde solde1;
	private Solde solde2;
	
	public Banque() {
		this.solde1 = new Solde();
		this.solde2 = new Solde();
	}
	
	public void setSolde1(Solde solde) {
		this.solde1 = solde;
	}
	public void setSolde2(Solde solde) {
		this.solde2 = solde;
	}
	
	public Solde getSolde1() {
		return solde1;
	}
	public Solde getSolde2() {
		return solde2;
	}
	
	/**
	 * Créer une banque pour deux joueur avec chacun leur solde.
	 * @param joueur1
	 * @param joueur2
	 */
	public void initBanque(Joueur joueur1,Joueur joueur2) {
		this.solde1.attribuerJoueur(joueur1);
		this.solde2.attribuerJoueur(joueur2);
	}
}
