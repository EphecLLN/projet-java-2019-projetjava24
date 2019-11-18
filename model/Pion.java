package model;

import model.Case;
import model.Direction;
import model.Pion;
import model.Plateau;
import model.Unite;

public class Pion {

private Unite soldat;
private Plateau position;
private Case cases;

	/**Constructeur  de la class Pion
	 * @param nom un pion qui doit être défini dans l'enum Unite pou y récupérer l'ensemble des données
	 */
	public Pion(Unite nom) 
	{
		soldat =nom;
		position.placerUnPion(this, 0, 0);
		cases = position.getCaseSelectionnee();
		
	}
	
	
	/**
	 * @return
	 */
	public String getNom() {return soldat.getName();}
	
	/**
	 * @return
	 */
	public Unite getUnite() {return this.soldat;}

	/**
	 * @param ennemi
	 * @return
	 */
	public boolean combat( Pion ennemi) 
	{
		final Unite allie = this.getUnite();
		final Unite adversaire = ennemi.getUnite();
		
		if(allie.estDetruit(adversaire)) 
		{
			return false;
		}
		else 
		{
			if(allie.getStrength() <= adversaire.getStrength()) 
			{
				return false;
			}
			else 
			{
				return true;
			}
		}
		
	}
	
	/**
	 * @param d
	 * @param nom
	 */
	public void deplacer(Direction d, Unite nom)
	{
		
		final Case caseSelect = this.cardinal(cases,d, nom.getDeplace());
		
		if(caseSelect.getPionPresent() != null) 
		{
			if(this.combat(caseSelect.getPionPresent())) 
			{
				position.deplacerUnPion(cases, caseSelect);
			}
			else
			{
				position.retirerUnPion(cases);
			}
		}
		else
		{
			position.deplacerUnPion(cases, caseSelect);
		}
	}	
	
	
	/**
	 * @param caseOrigine
	 * @param d
	 * @param deplace
	 * @return
	 */
	public Case cardinal(Case caseOrigine,Direction d,int deplace) 
	{
		switch(d) 
		{
		case HAUT: caseOrigine.setCoordY(caseOrigine.getCoordY()+deplace);
			break;
		case BAS: caseOrigine.setCoordY(caseOrigine.getCoordY()-deplace);
			break;
		case GAUCHE: caseOrigine.setCoordX(caseOrigine.getCoordX()+deplace);
			break;
		case DROITE: caseOrigine.setCoordX(caseOrigine.getCoordX()+deplace);
			break;
			
		}
		
		return caseOrigine;
	}

}
	
	
	


