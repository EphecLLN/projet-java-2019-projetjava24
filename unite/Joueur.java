package unite;

import java.awt.Color;

/**
 * 
 * @author Crenier Amaury
 *
 */

/**
*La classe Joueur contient tous les attributs propres � un joueur :
*	- son nom (ou pseudo),
*	- sa couleur,
*	- son id
*	- sa r�serve de pion
*	- la liste des pions qu'il a pris,
*	- la liste des pions qu'il doit placer.
*/

public class Joueur {
	
	private String pseudo;
	private Color couleur;
	private int id;
	private int reserve;
	protected int[] listePionsPris;
	protected Pion[] listePionsAPlacer;
	
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
		//un joueur a au maximum 40 pions
		listePionsPris = new int[9];//nous avons 9 Unit�s diff�rentes
		listePionsAPlacer = new Pion[40];
	    //remplirListePionsAPlacer();
		
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
	 * Retourne la liste des pions pris par le joueur
	 * @return un tableau d'entier : l'indice  correspond au grade du pion - 1 et l'entier
	 * correspondant au nombre de pions de ce grade pris par le joueur
	 */
	public int[] getListePionsPris() {
		return listePionsPris;
	}

	public void setListePionsPris(int[] listePionsPris) {
		this.listePionsPris = listePionsPris;
	}

	public Pion[] getListePionsAPlacer() {
		return listePionsAPlacer;
	}

	public void setListePionsAPlacer(Pion[] listePionsAPlacer) {
		this.listePionsAPlacer = listePionsAPlacer;
	}
	
	/**
	 * Le joueur choisi un type d'unit� � acheter et un nouveau Pion est cr��.
	 * @param soldat, le type d'unit�
	 * @return newSoldat, le Pion cr�� de type soldat
	 */
	public Pion acheter(Unite soldat) {
		Pion newSoldat = new Pion(soldat);
		reserve = reserve + 1;
		return newSoldat;
	}
	
	/**
	 * Renvoie le co�t d'une Unite.
	 * @param soldat, l'Unite
	 * @return le co�t
	 */
	public int payer(Unite soldat) {
		return soldat.getPrice();
	}
	
	/**
	 * Permet de savoir si le joeur est pr�t � jouer car il n'a pas de pions en r�serve.
	 * @return true, si la r�serve est �gale � z�ro (vide)
	 */
	public boolean estPret() {
		return reserve == 0;
	}
	
	/**
	 * Permet de diminuer la r�serve de une unit�.
	 */
	public void retirerReserve() {
		reserve = reserve - 1;
	}
	
	/**
	 * Remplie la liste des pions que doit placer le joueur sur le plateau de jeu.
	 */
	
	/*private void remplirListePionsAPlacer() {
		listePionsAPlacer[0] = new Pion();
		
		listePionsAPlacer[1] = new Pion();
		
		listePionsAPlacer[2] = new Pion();
		
		listePionsAPlacer[3] = new Pion();
		
		listePionsAPlacer[4] = new Pion();
		
		listePionsAPlacer[5] = new Pion();
		
		listePionsAPlacer[6] = new Pion();
		
		listePionsAPlacer[7] = new Pion();
		
		listePionsAPlacer[8] = new Pion();
		
		
	}*/
	
}
