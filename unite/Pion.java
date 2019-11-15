package unite;


public class Pion {

private Unite soldat;
private Plateau position;
private Case cases;

	/**Constructeur  de la class Pion
	 * @param nom un pion qui doit être défini dans l'enum Unite pou y récupérer l'ensemble des données
	 */
	public Pion(Unite nom) 
	{
		soldat =nom;
		position.placerUnPion(this, 0, 0);
		cases = position.getCaseSelectionnee();
		
	}
	
	
	/**getters renvoyant une string correspondant au nom du pion
	 * @return string nom du pion
	 */
	public String getNom() {return soldat.getName();}
	
	/**getters de l'unité correspondante au pion 
	 * @return unité du pion
	 */
	public Unite getUnite() {return this.soldat;}

	/**méthode booléene renvoyant le résultat d'un combat entre deux pion
	 * @param ennemi pion ciblé par l'attaque
	 * @return true si le combat est gagné et false si il est perdu
	 */
	public boolean combat( Pion ennemi) 
	{
		final Unite allie = this.getUnite();
		final Unite adversaire = ennemi.getUnite();
		
		if(allie.estDetruit(adversaire)) 
		{
			return false;
		}
		else 
		{
			if(allie.getStrength() <= adversaire.getStrength()) 
			{
				return false;
			}
			else 
			{
				return true;
			}
		}
		
	}
	
	/**méthode de déplacement des pions 
	 * @param d un composant de l'enum direction HAUT,BAS,GAUCHE,DROITE
	 * @param nom unité d'un pion
	 */
	public void deplacer(Direction d, Unite nom)
	{
		
		final Case caseSelect = this.cardinal(cases,d, nom.getDeplace());
		
		if(caseSelect.getPionPresent() != null) 
		{
			if(this.combat(caseSelect.getPionPresent())) 
			{
				position.deplacerUnPion(cases, caseSelect);
			}
			else
			{
				position.retirerUnPion(cases);
			}
		}
		else
		{
			position.deplacerUnPion(cases, caseSelect);
		}
	}	
	
	
	/**méthode définissant une case d'arrivée à partir de la case d'origne, de la direction et du déplacement effectué
	 * @param caseOrigine case ou se trouve le pion 
	 * @param d direction voule 
	 * @param deplace nombre de pas aà effectuer
	 * @return la case d'arrivée qui n'est autre que la case d'origine modifier par la méthode
	 */
	public Case cardinal(Case caseOrigine,Direction d,int deplace) 
	{
		switch(d) 
		{
		case HAUT: caseOrigine.setCoordY(caseOrigine.getCoordY()+deplace);
			break;
		case BAS: caseOrigine.setCoordY(caseOrigine.getCoordY()-deplace);
			break;
		case GAUCHE: caseOrigine.setCoordX(caseOrigine.getCoordX()+deplace);
			break;
		case DROITE: caseOrigine.setCoordX(caseOrigine.getCoordX()+deplace);
			break;
			
		}
		
		return caseOrigine;
	}

}
	
	
	


