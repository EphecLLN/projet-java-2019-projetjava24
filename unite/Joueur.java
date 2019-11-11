package unite;

import java.awt.Color;

public class Joueur implements Bank{
	
	private String pseudo;
	private int solde;
	
	private Color couleur;
	
	public  Joueur(String pseudo) 
	{
		this.pseudo = pseudo;
		this.solde = 0;
		this.setCouleur(Color.BLUE);
	}

	public int getSolde() {
		return solde;
	}
	
	public void setSolde(int solde) {
		this.solde =  solde;
	}

	
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getPseudo() {
		return pseudo;
	}
	
	public Pion acheter(Unite nom) 
	{
		this.subSolde(solde, nom.getPrice());
		return new Pion(nom);
	}
	
	public void generer() 
	{
		this.addSolde(solde, 100);
	}



}
