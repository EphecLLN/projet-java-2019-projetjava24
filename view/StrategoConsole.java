/**
 * 
 */
package view;

import model.Pion;
import model.Plateau;

/**
 * @author amaur
 *
 */
public class StrategoConsole {
	
	public StrategoConsole() {
		
	}
	
	public void testVueConsole(String string) {
		System.out.println("Création du jeu" + string);
	}
	
	public void montrerPlateau(Plateau plateau) {
		String ligne = "";
		for (int i = 0; i < 10; i++) {//définir cahque ligne
			for (int j = 0; j < 10; j++) {//définir chaque case
				ligne += "|";
				if(plateau.map[i][j].getPionPresent()) {
					Pion pion = plateau.pionsEnJeu.get(plateau.map[i][j]); 
					//faut retrouver le joueur!!!
					ligne += pion.getUnite().getName();//à remplacer par un getJoueur ou autre;
				}
				else {
					ligne += "...";
				}
			}
			System.out.println(i +"  "+ligne+"|");
			ligne ="";
		}
	}
	
	public void narrateur(String signal) {//pas ceratin de ca
		switch(signal) {
		case "deplace":
			break;
		case "combat":
			break;
		}
	}
}
