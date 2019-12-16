/**
 * 
 */
package main;

import controller.StrategoController;

/**
 * @author Crenier Amaury
 *
 */
public class Stratego {
	
	public static void main(String [] args) {
		String partie = "";
		StrategoController controller = new StrategoController();
		controller.lancerJeu();
		controller.affichagePlateauDepart();
		for (int i = 0; i < 20; i++) {
			controller.placerPions();
		}
		do {
			controller.nouveauTour();
		}
		while (partie != "fin");
	}	
}
