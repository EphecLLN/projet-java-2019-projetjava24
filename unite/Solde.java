/**
 * 
 */
package unite;

/**
 * @author Crenier Amaury
 *
 */
public class Solde {
	
	private int valeur;
	private int joueurId;
	
	public Solde() {
		valeur = 0;
		joueurId = 0;
	}
	
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	public void setJoueurId(int joueurId) {
		this.joueurId = joueurId;
	}
	
	public int getValeur() {
		return this.valeur;
	}
	public int getJoueurId() {
		return this.joueurId;
	}
	
	/**
	 * Lier un solde avec son joueur.
	 * @param joueur
	 */
	public void attribuerJoueur(Joueur joueur) {
		joueurId = joueur.getId();
	}
	
	/**
	 * Ajouter une valeur au solde actuel.
	 * @param valeur 
	 * @return le nouveau solde
	 */
	public int augmenter(int valeur) {
		return this.valeur + valeur;
	}
	
	/**
	 * Retirer une valeur au solde actuel.
	 * @param valeur
	 * @return le nouveau solde
	 */
	public int diminuer(int valeur) {
		return this.valeur - valeur;
	}

}
