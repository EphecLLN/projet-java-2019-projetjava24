package model;


public class Pion {

private Unite soldat;
private Plateau position;


private int PM;//point de Mouvement
	/* Les points Mouvement serviront a d�termin� la limite de d�placements
	 * possibles par tour */

	

	public Pion(Unite nom) 
	{
		soldat =nom;
		PM = soldat.getDeplace();
	}
	
	
	public String getNom() {return soldat.getName();}
	

	
	public void combat(Unite ennemi) 
	{
		if(!soldat.estDetruit(ennemi)) 
		{
			if(soldat.getStrength() >= ennemi.getStrength()) 
			{
				//si soldat a une force inf�rieur ou �gale � son ennemi il meurt
			}
			else 
			{
				//si sa force est plus grande il gagne
			}
		}
		else 
		{
			//Une unit� sp�ciale est morte 
		}
	}	
	
	/*public void deplacer(Direction d, int choixDeplacer) 
	{
		
		if(choixDeplacer <= PM)
		{
			switch(d) {
			case HAUT:position.monte(choixDeplacer,getNom(), position.getPosition(this.getNom()));
			
				break;
			case BAS:position.descend(choixDeplacer,getNom(), position.getPosition(this.getNom()));
			
				break;
			case DROITE:position.tourneDroite(choixDeplacer,getNom(), position.getPosition(this.getNom()));
			
				break;
			case GAUCHE:position.tourneGauche(choixDeplacer,getNom(), position.getPosition(this.getNom()));
			
				break;
			}
		}
		
	}
	
	
	public void fatigue(int choixDeplacer) 
	{
		PM -= choixDeplacer;
		
		if(PM == 0) {System.out.println(soldat.getName()+" ne peut plus bouger.");} 
		else {System.out.println("Il ne vous reste plus que "+ PM +" Point de Mouvement");}
	}
	
	public void reset() {this.PM = soldat.getDeplace();}*/
	
	
}
	
	
	


