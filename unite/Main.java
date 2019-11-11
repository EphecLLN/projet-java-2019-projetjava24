package unite;

public class Main {

	public static void main(String[] args) {
		//à implémenter
		
	
	
	}
	
	public Joueur setJoueur(String pseudo1) 
	{
		return new Joueur(pseudo1);
	}
	
	public Banque setBanque(Joueur player) 
	{
		return new Banque(player);
	}
	
	public Pion setBataillon(Unite[] set) 
	{
		for(Unite unite: set) 
		{
			return new Pion(unite);
		}
		return new Pion(Unite.DRAPEAU);
		
	}

}
