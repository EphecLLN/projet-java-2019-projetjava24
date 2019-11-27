package model;


public class Pion {

private Unite unite;
private Case position;

	public Pion(Unite unite) {
		this.unite = unite;
		this.position = new Case();	
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
	
	
	public void aGagne() {
		
	}
}
	
	
	


