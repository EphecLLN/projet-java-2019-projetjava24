package controler;

import view.PlateauConsole;
import view.StrategoConsole;

import java.awt.Color;

public class StrategoController {
	
	private StrategoConsole console = new StrategoConsole();
	private PlateauConsole plateauConsole = new PlateauConsole(10, 10);
	private model.Plateau plateau = new model.Plateau();
	private model.Joueur joueur1;
	private model.Joueur joueur2;
	
	
	public void lancerJeu() {
		console.demarrerJeu();
		console.nouveauJoueur(1);
		String nom = console.demanderNom();
		Color couleur = console.demanderCouleur();
		joueur1 = new model.Joueur(nom, couleur);
		joueur1.initReserveDepart();
		console.nouveauJoueur(2);
		String nom2 = console.demanderNom();
		Color couleur2 = console.demanderCouleur();
		joueur2 = new model.Joueur(nom2, couleur2);
		joueur2.initReserveDepart();
		console.affichageJoueurs(joueur1.toString(), joueur2.toString());
	}
	
	public void affichagePlateauDepart() {
		plateauConsole.dessinerPlateau();
		console.introAffichageReserve();
		console.afficherReservePion("Drapeau", joueur1.compteurReserve(joueur1.getReserve(), "Drapeau"));
		console.afficherReservePion("Bombe", joueur1.compteurReserve(joueur1.getReserve(), "Bombe"));
		console.afficherReservePion("Espion", joueur1.compteurReserve(joueur1.getReserve(), "Espion"));
		console.afficherReservePion("Saboteur", joueur1.compteurReserve(joueur1.getReserve(), "Saboteur"));
		console.afficherReservePion("G�n�ral", joueur1.compteurReserve(joueur1.getReserve(), "G�n�ral"));
		console.afficherReservePion("Char d'assaut", joueur1.compteurReserve(joueur1.getReserve(), "Char d'assaut"));
		console.afficherReservePion("D�mineur", joueur1.compteurReserve(joueur1.getReserve(), "D�mineur"));
		console.afficherReservePion("Caporal", joueur1.compteurReserve(joueur1.getReserve(), "Caporal"));
		console.afficherReservePion("Eclaireur", joueur1.compteurReserve(joueur1.getReserve(), "Eclaireur"));
	}
	
	public void placerPions() {
		System.out.println("placement du pion: " + joueur1.getReserve().get(0).getUnite().getName());
		int x = console.demanderPositionX();
		int y = console.demanderPositionY();
		plateau.placerPion(joueur1.getReserve().get(0), plateau.map[x][y]);
		plateauConsole.placerPion(x, y, joueur1.getReserve().get(0).getUnite().getGrade());
		joueur1.getReserve().remove(0);
		plateauConsole.dessinerPlateau();
	}
	
	public void nouveauTour() {
		if (joueur1.estPret()) {
			String reponse = console.achatOuDeplacement();
			if (reponse == "deplacer") {
				deplacerPion();
			}
			else {
				joueur1.acheterUnite(model.Unite.convertirStrUnite(console.acheterPion()));
			}
			joueur1.genererSoldeParTour();
		}
		else placerPions();
	}
	
	public void deplacerPion() {
		int xDepart = console.demanderPionX();
		int yDepart = console.demanderPionY();
		int xArrivee = console.demanderPositionX();
		int yArrivee = console.demanderPositionY();
		plateau.deplacer(plateau.pionsEnJeu.get(plateau.map[xDepart][yDepart]), xArrivee, yArrivee);
	}
}