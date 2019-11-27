package model;

import java.util.HashMap;

/**
 * @author florent janssens
 *
 */   

public class Plateau {
	
		public Case[][] map;
		public HashMap<Case,Pion> pionsEnJeu;

		public Plateau() {
			pionsEnJeu = new HashMap<Case, Pion>();
			map = new Case[10][10];
			
			// cr�er les cases terrain
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++) 
					map[i][j] = new Case(i, j, "terrain");

			// cr�er les cases eau
			map[2][4] = new Case(2, 4, "eau");
			map[3][4] = new Case(3, 4, "eau");
			map[2][5] = new Case(2, 5, "eau");
			map[3][5] = new Case(3, 5, "eau");
			
			map[6][4] = new Case(6, 4, "eau");
			map[7][4] = new Case(7, 4, "eau");
			map[6][5] = new Case(6, 5, "eau");
			map[7][5] = new Case(7, 5, "eau");		
		}
		
		/**
		 * D�finir la case occup�e par un pion.
		 * @param endroit, la case � occuper
		 */
		public void occuperLaCase(Case endroit) {
			this.map[endroit.getCoordX()][endroit.getCoordY()].setPionPresent(true);
		}
			
		/**
		 * D�finir la case libre.
		 * @param endroit, la case � lib�rer
		 */
		public void lib�rerLaCase(Case endroit) {
			this.map[endroit.getCoordX()][endroit.getCoordY()].setPionPresent(false);
		}	
		
		
		public int calculerDistance(Case caseOrigine, int x, int y) {
			int distance;
			if (caseOrigine.getCoordX() == x) {
				distance = y - caseOrigine.getCoordY();
			}
			else if (caseOrigine.getCoordY() == y) {
				distance = x - caseOrigine.getCoordX();
			}
			else {
				distance = 0; // gestion erreur d�placement non lin�aire
			}
			return distance;
		}
		
		public void placerPion(Pion pion, Case endroit) {
			pionsEnJeu.remove(pion.getPosition());
			pion.setPosition(endroit);
			pionsEnJeu.put(endroit, pion);
		}
		
		/**
		 * D�place un pion d'une case � une autre selon sa capacit� de d�placement.
		 * @param caseDepart
		 * @param caseArrivee
		 */
		public void deplacer(Pion pion,int x, int y) {
			int distance = this.calculerDistance(pion.getPosition(), x, y);
			if (distance == 0) {
				//ERROR
				System.err.println("Vous �tes d�j� sur cette case");
			}
			else if (distance <= pion.getUnite().getDeplace()) {
				if (map[x][y].getPionPresent()) {
					pion.combattre(pionsEnJeu.get(map[x][y]));
				}
				else {
					this.placerPion(pion, map[x][y]);
				}
			}
			else {
				//ERROR
				System.err.println("d�placement non autoris�");
			}
		}
		
		public void terminerCombat(Pion perdant, Pion gagnant, Joueur joueur, Case endroit) {
			pionsEnJeu.remove(perdant.getPosition());
			joueur.getCimetiere().add(perdant);
			this.placerPion(gagnant, endroit);
		}
}