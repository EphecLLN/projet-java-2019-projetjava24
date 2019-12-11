package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Pion {

private ObjectProperty<Unite> unite = new SimpleObjectProperty<Unite>();
private ObjectProperty<Case> position =new SimpleObjectProperty<Case>();

	public Pion(Unite unite) {
		this.unite.set(unite);
		this.position.set(new Case());
	}
	
	public Unite getUnite() {
		return unite.getValue();
	}

	public void setUnite(Unite unite) {
		this.unite.set(unite);;
	}
	
	public Case getPosition() {
		return position.getValue();
	}
	
	public void setPosition(Case endroit) {
		this.position.set(endroit);
	}

	/**
	 * Combat entre deux pions. L'attaquant est le pion qui se déplace et le défenseur
	 * est le pion déjà présent sur la case.
	 * @param defenseur
	 * @return pionGagnant
	 */
	public Pion combattre(Pion defenseur) {
		Pion pionGagnant = null;
		
		switch(defenseur.unite.getValue()) {
		case DRAPEAU: this.aGagne();
			break;
		case BOMBE:
			if (this.unite.getValue() == Unite.DEMINEUR) {
				pionGagnant = this;
			}
			else {
				pionGagnant =  defenseur;
			}
			
		case TANK:
			if (this.unite.getValue() == Unite.SABOTEUR) {
				pionGagnant =  this;
			}
			else {
				pionGagnant =  defenseur;
			}
			
		case GENERAL:
			if (this.unite.getValue() == Unite.ESPION) {
				pionGagnant = this;
			}
			else {
				pionGagnant =  defenseur;
			}
			//si le Pion ne correspond pas au caractéristique ci-dessus
			default:
				if (this.unite.getValue().getGrade() >= defenseur.unite.getValue().getGrade()) {
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
	
	
	


