package unite;


public class Pion {

private Unite soldat;
private Plateau position;
private Case cases;

	/**Constructeur  de la class Pion
	 * @param nom un pion qui doit �tre d�fini dans l'enum Unite pou y r�cup�rer l'ensemble des donn�es
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
	
	/**getters de l'unit� correspondante au pion 
	 * @return unit� du pion
	 */
	public Unite getUnite() {return this.soldat;}

	/**m�thode bool�ene renvoyant le r�sultat d'un combat entre deux pion
	 * @param ennemi pion cibl� par l'attaque
	 * @return true si le combat est gagn� et false si il est perdu
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
	
	/**m�thode de d�placement des pions 
	 * @param d un composant de l'enum direction HAUT,BAS,GAUCHE,DROITE
	 * @param nom unit� d'un pion
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
	
	
	/**m�thode d�finissant une case d'arriv�e � partir de la case d'origne, de la direction et du d�placement effectu�
	 * @param caseOrigine case ou se trouve le pion 
	 * @param d direction voule 
	 * @param deplace nombre de pas a� effectuer
	 * @return la case d'arriv�e qui n'est autre que la case d'origine modifier par la m�thode
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
	
	
	


