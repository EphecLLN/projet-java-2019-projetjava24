package unite;

public interface Bank {
	
	public default int addSolde(int solde,int terme) 
	{
		return solde + terme;
	}
	
	public default int subSolde(int solde,int terme) 
	{
		return solde - terme;	
	}
	

}
