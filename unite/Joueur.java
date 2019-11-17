package unite;

import java.awt.Color;

/**
 * 
 * @author Crenier Amaury
 *
 */

/**
*La classe Joueur contient tous les attributs propres à un joueur :
*	- son nom (ou pseudo),
*	- sa couleur,
*	- son id
*	- sa réserve de pion
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
		listePionsPris = new int[9];//nous avons 9 Unités différentes
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
	
	/**
	 * Remplie la liste des pions que doit placer le joueur sur le plateau de jeu.
	 il faudra faire ca pour les 40 a placer au debut de la partie !!
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
	
	/**
	 * Place les pions du joueur aléatoirement sur le plateau
	 * @param plateauDeJeu le plateau de jeu
	 */
	public void placerPionsAleatoirement(Plateau map) {
		/*
		 * en fonction de la couleur du joueur, on place les pions sur les case du plateau (en haut ou en bas)
		 * et jamais deux pions sur une même case
		 */
		int nbAleatoire;
		Random generateurRdm = new Random();
		
		if (this.couleur.equals(Color.BLUE))	
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 4; y++) {
					do {
						nbAleatoire = generateurRdm.nextInt(40);
					}
					while (listePionsAPlacer[nbAleatoire] == null);
				
					map.placerUnPion(listePionsAPlacer[nbAleatoire],x , y);
					listePionsAPlacer[nbAleatoire] = null;
				}
			}
		else if (this.couleur.equals(Color.RED))
			for (int x = 0; x < 10; x++) {
				for (int y = 6; y < 10; y++) {
					do {
						nbAleatoire = generateurRdm.nextInt(40);
					}
					while (listePionsAPlacer[nbAleatoire] == null);
				
					map.placerUnPion(listePionsAPlacer[nbAleatoire],x , y);
					listePionsAPlacer[nbAleatoire] = null;
				}
			}
		
		
	}
	
}
