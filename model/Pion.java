package model;

import java.util.UUID;

public class Pion {

private Unite unite;
private Case position;
private UUID id;

	public Pion(Unite unite) {
		this.unite = unite;
		this.position = new Case();
		this.id = UUID.randomUUID();	
	}
	
	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}
	
	public Case getPosition() {
		return position;
	}
	
	public void setPosition(Case endroit) {
		this.position = endroit;
	}
	
	public UUID getId() {
		return id;
	}

	/**
	 * Combat entre deux pions. L'attaquant est le pion qui se déplace et le défenseur
	 * est le pion déjà présent sur la case.
	 * @param defenseur
	 * @return pionGagnant
	 */
	public Pion combattre(Pion defenseur) {
		Pion pionGagnant = null;
		
		switch(defenseur.unite) {
		case DRAPEAU: this.aGagne();
			break;
		case BOMBE:
			if (this.unite == Unite.DEMINEUR) {
				pionGagnant = this;
			}
			else {
				pionGagnant =  defenseur;
			}
			
		case TANK:
			if (this.unite == Unite.SABOTEUR) {
				pionGagnant =  this;
			}
			else {
				pionGagnant =  defenseur;
			}
			
		case GENERAL:
			if (this.unite == Unite.ESPION) {
				pionGagnant = this;
			}
			else {
				pionGagnant =  defenseur;
			}
			//si le Pion ne correspond pas au caractéristique ci-dessus
			default:
				if (this.unite.getGrade() >= defenseur.unite.getGrade()) {
					pionGagnant = this;
			}
			else {
				pionGagnant = defenseur;
			}
				
		}
		return pionGagnant;
		
	}
	
	public void aGagne() {}
	
	/**
	 * Déplace un pion d'une case à une autre selon sa capacité de déplacement.
	 * @param caseDepart
	 * @param caseArrivee
	 */
	public void deplacer(int x, int y) {
		int distance;
		if (this.position.getCoordX() == x) {
			distance = y - this.position.getCoordY();
		}
		if (this.position.getCoordY() == y) {
			distance = x - this.position.getCoordX();
		}
		else {
			distance = 0;
		}
		
		if(distance <= this.unite.getDeplace()) {
			
		}
		else {
			//ERROR
		}
	}	
	
	
	/**
	 * @param caseOrigine
	 * @param d
	 * @param deplace
	 * @return
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
	
	
	


