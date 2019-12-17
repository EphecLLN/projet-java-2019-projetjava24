package model;

import java.util.HashMap;

/**
 * @author florent janssens
 *
 */   

public class Plateau {
	
		public static Unite win = Unite.ECLAIREUR;
		public Case[][] map;
		public HashMap<Case,Pion> pionsEnJeu;

		public Plateau() {
			pionsEnJeu = new HashMap<Case,Pion>();
			map = new Case[10][10];
			
			// cr�er les cases terrain
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++) 
					map[i][j] = new Case(i, j);	
		}
		
		public static Unite getWin() {
			return win;
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
		public void libererLaCase(Case endroit) {
			this.map[endroit.getCoordX()][endroit.getCoordY()].setPionPresent(false);
		}	
		
		/**
		 * calcule la distance entre la case d'origine du pion
		 * a la case d'arrive souhaite
		 * @param caseOrigine
		 * @param x
		 * @param y
		 * @return
		 */
		public int calculerDistance(Case caseOrigine, int x, int y) {
			System.out.println("caseX: " + caseOrigine.getCoordX());
			System.out.println("caseY: " + caseOrigine.getCoordY());
			System.out.println("X: " + x);
			System.out.println("Y: " + y);
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
			pion.setPosition(endroit);
			pionsEnJeu.remove(pion.getPosition());
			endroit.setPionPresent(true);
			pionsEnJeu.put(endroit, pion);
		}
		
		/**
		 * Deplace un pion d'une case a une autre selon sa capacite de deplacement.
		 * @param caseDepart
		 * @param caseArrivee
		 */
		public void deplacer(Pion pion,int x, int y) {
			int distance = calculerDistance(pion.getPosition(), x, y);
			System.out.println(distance);
			if (distance == 0) {
				//ERROR
				System.err.println("Vous �tes d�j� sur cette case");
			}
			else if (distance <= pion.getUnite().getDeplace()) {
				System.out.println(x + "" + y + map[x][y] + map[y][x].getPionPresent());
				System.out.println(map[x][y].getPionPresent());
				if (map[x][y].getPionPresent()) {
					win = (pion.combattre(pionsEnJeu.get(map[x][y]))).getUnite();
					System.out.println(win + "if");
					System.out.println(pionsEnJeu.get(map[x][y]).getUnite());
					System.out.println(pion.getUnite());
				}
				else {
					this.placerPion(pion, map[x][y]);
					System.out.println(win + "else");
				}
				System.out.println("d�placement");
				System.out.println(win);
			}
			else {
				//ERROR
				System.err.println("d�placement non autoris�");
			}
		}
		/**
		 * retire le pion perdant du plateau
		 * place le pion gagnant de l'adversaire sur la case
		 * @param perdant
		 * @param gagnant
		 * @param joueur
		 * @param endroit
		 */
		public void terminerCombat(Pion perdant, Pion gagnant, Joueur joueur, Case endroit) {
			pionsEnJeu.remove(perdant.getPosition());
			this.placerPion(gagnant, endroit);
		}
}