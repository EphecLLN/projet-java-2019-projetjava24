package unite;

public class Main {

	public static void main(String[] args) {
		//à implémenter
	
	
	}
	
	public Joueur setJoueur(String pseudo1) 
	{
		return new Joueur(pseudo1);
	}
	
	
	public Pion setBataillon(Unite[] set, int cases) 
	{
		for(Unite unite: set) 
		{
			return new Pion(unite,cases++);
		}
		return new Pion(Unite.DRAPEAU,cases);
		
	}

}
