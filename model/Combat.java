package model;

public class Combat {
	
	private Unite soldat,ennemi;
	
	
	public Combat(Pion  soldat, Pion ennemi) 
	{
		this.soldat = soldat.getUnite();
		this.ennemi = ennemi.getUnite();
	}
	
	public boolean estDetruit() 
	{
		switch(soldat.getName()) 
		{
		case "Démineur": return ennemi.getName()=="Bombe";
		
		case "Espion": return ennemi.getName()=="Générale";
		
		case "saboteur": return ennemi.getName()=="Char d'assaut";
		
		default: return false;
		}
	
	}
	
	public boolean gagne() 
	{
		
		if(estDetruit()) 
		{
			System.out.println(soldat.getName()+" a éliminé "+ennemi.getName());
			return true;
		}
		else 
		{
			if(soldat.getGrade() <= ennemi.getGrade()) 
			{
				System.out.println(soldat.getName()+" est mort au combat");
				return false;
			}
			else 
			{
				System.out.println("Grâce à votre "+soldat.getName()+" vous gagnez du terrain");
				return true;
			}
		}
	}

}
