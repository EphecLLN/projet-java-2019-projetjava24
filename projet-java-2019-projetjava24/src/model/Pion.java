package model;

import javafx.scene.paint.Color;

public class Pion {

private Unite unite;
private Case position;
private Color couleur;

	
	/**
	 * Constructeur avec param
	 * @param unite
	 * @param couleur
	 */
	public Pion(Unite unite, Color couleur) {
		this.unite = unite;
		this.position = new Case();
		this.couleur = couleur;
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
	 * Combat entre deux pions. L'attaquant est le pion qui se d�place et le d�fenseur
	 * est le pion d�j� pr�sent sur la case.
	 * @param defenseur
	 * @return pionGagnant
	 */
	public Pion combattre(Pion defenseur) {
		Pion pionGagnant = null;
		
		switch(defenseur.unite) {
		case DRAPEAU: return defenseur;
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
			//si le Pion ne correspond pas au caract�ristique ci-dessus
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

	public Color getCouleur() {
		return couleur;
	}
}
	
	
	


