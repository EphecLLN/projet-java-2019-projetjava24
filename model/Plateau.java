package model;

/**
 * @author florent janssens
 *
 */   

public class Plateau {
	
		public Case map[][];

		public Plateau() {
			
			map = new Case[10][10];
			
			// créer les cases terrain
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++) 
					map[i][j] = new Case(i, j, "terrain");

			// créer les cases eau
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
		 * Définir la case occupée par un pion.
		 * @param endroit, la case à occuper
		 */
		public void placerUnPion(Case endroit) {
			this.map[endroit.getCoordX()][endroit.getCoordY()].setPionPresent(true);
		}
			
		/**
		 * Définir la case libre.
		 * @param endroit, la case à libérer
		 */
		public void retirerUnPion(Case endroit) {
			this.map[endroit.getCoordX()][endroit.getCoordY()].setPionPresent(false);
		}	
	}

