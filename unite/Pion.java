package unite;

public class Pion {

private Unite soldat;

private int PM;//point de Mouvement
	/* Les points Mouvement serviront a déterminé la limite de déplacements
	 * possibles par tour */



	

	public Pion(Unite nom) 
	{
		this.soldat =nom;
		this.PM = soldat.getDeplace();
	}
	
	
	
	
	
	
	public String getNom() {return soldat.getName();}

	/*public int getDeplace() {return soldat.getDeplace();}

	public int getStrength() {return soldat.getStrength();}

	public int getPrice() {return soldat.getPrice();}
	
	public int getLimit() {return soldat.getLimit();}*/
	
	public void combat(Unite ennemi) 
	{
		if(!soldat.estDetruit(ennemi)) 
		{
			if(soldat.getStrength() >= ennemi.getStrength()) 
			{
				//si soldat a une force inférieur ou égale à son ennemi il meurt
			}
			else 
			{
				//si sa force est plus grande il gagne
			}
		}
		else 
		{
			//Une unité spéciale est morte 
		}
	}	
	
	public void deplacer(Direction d, int choixDeplacer) 
	{
		
		if(choixDeplacer <= PM)
		{
			switch(d) {
			case HAUT:soldat.monte(choixDeplacer);
			fatigue(choixDeplacer);
				break;
			case BAS:soldat.descend(choixDeplacer);
			fatigue(choixDeplacer);
				break;
			case DROITE:soldat.tourneDroite(choixDeplacer);
			fatigue(choixDeplacer);
				break;
			case GAUCHE:soldat.tourneGauche(choixDeplacer);
			fatigue(choixDeplacer);
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
}
	
	
	


