package unite;

public class Banque {
	
	private int solde;
	private Joueur player;
	
	public Banque(Joueur player) 
	{
		
		this.solde = player.getSolde();
		this.player = player;
		
	}
	
	public void addSolde(int solde) {
		this.solde += solde;
		this.player.setSolde(this.solde);
	}
	
	public void subSolde(int solde) {
		this.solde -= solde;
		this.player.setSolde(this.solde);
	}
	
	public int getSolde() {
		return solde;
	}
	
	public String getPropriétaire() {
		return player.getPseudo();
	}
	
	public Pion acheter(Unite nom) {
		
		subSolde(nom.getPrice());
		return new Pion(nom);
	}
	
	public void generer() {addSolde(200);}


}
