package unite;

public interface Bank {
	//mauvais car on impléménte pas une interface
	public default int addSolde(int solde,int terme) 
	{
		return solde + terme;
	}
	
	public default int subSolde(int solde,int terme) 
	{
		return solde - terme;	
	}
	
	//Création de méthode abtraite
	

}
