package unite;

public class Pion {

private Unite soldat;



	

	public Pion(Unite nom) 
	{
		this.soldat =nom;
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
}
	
	
	


