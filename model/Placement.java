package model;

public class Placement {
	
	private Pion soldat;
	private Direction d;
	private Case c1;
	private Case c2;
	private Plateau p;
	
	
	public Placement(Pion soldat) 
	{
		this.soldat = soldat;
	}
	
	public void setDirection (Direction d) 
	{
		this.d = d;
	}
	
	public void placer(int coordX, int coordY) 
	{
		c1 = p.getCase(coordX,coordY);
		
	}
	
	public Case guetter(int distance) 
	{
		switch(d) 
		{
		case HAUT: c1.setCoordY(c1.getCoordY()+distance);
			break;
		case BAS: c1.setCoordY(c1.getCoordY()-distance);
			break;
		case DROITE: c1.setCoordX(c1.getCoordX()+distance);
			break;
		case GAUCHE: c1.setCoordX(c1.getCoordX()-distance);
			break;
		}
		return c1;
	}
	
	public void deplacer(int distance) 
	{
		c2 = guetter(distance);
		if(c2.getPionPresent()!= null) 
		{
			if(new Combat(soldat,c2.getPionPresent()).gagne()) 
			{
				p.retirerUnPion(c2);
				p.deplacerUnPion(c1, c2);
			}
			else 
			{
				p.retirerUnPion(c1);
			}
		}
		else 
		{
			p.deplacerUnPion(c1, c2);
			System.out.println("est en "+p.map);
		}
	}

}
