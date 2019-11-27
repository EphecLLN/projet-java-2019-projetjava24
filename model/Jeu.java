package model;

import java.awt.Color;

public class Jeu {
	
		Plateau plateau;
		Joueur joueur1;
		Joueur joueur2;
	
	public Jeu(){
		plateau = new Plateau();
	}
	
	public static void main(String[] args) {
		Jeu stratego =new Jeu();
		Color couleur1;
		Color couleur2;
		if (args[2] == "bleu") {
			couleur1 = Color.BLUE;
			couleur2 = Color.RED;
		}
		else {
			couleur1 = Color.RED;
			couleur2 = Color.BLUE;
		}
		stratego.initialiserJoueur1(args[1], couleur1);
		stratego.initialiserJoueur2(args[3], couleur2);
	}
	
	public void initialiserJoueur1(String pseudo, Color couleur) {
		joueur1 = new Joueur(pseudo, couleur);
		joueur1.initReserveDepart();
	}
	
	public void initialiserJoueur2(String pseudo, Color couleur) {
		joueur2 = new Joueur(pseudo, couleur);
		joueur2.initReserveDepart();
	}
}
