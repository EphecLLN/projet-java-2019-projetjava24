package model;


/**
 * @author florent janssens
 *
 */   

public class Plateau extends Case  {
	/**
	 * Gestion du plateau de jeu
	 */


		public Case map[][];
		private Case caseSelectionnee;
		private String typeCase;

		/**
		 * constante d�finissant les cases Eau
		 */
		public static final String caseEau = "caseEau";
		/**
		 * constante d�finissant les cases Terrain
		 */
		public static final String caseTerrain = "caseTerrain";
		
		/**
		 * Constructeur
		 */
		public Plateau() {
			
			map = new Case[10][10];
			
			// cr�e les cases terrains
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++) 
					map[i][j] = new Case(i, j, caseTerrain);

			// cr�e les cases eau
			map[2][4] = new Case(2, 4, caseEau);
			map[3][4] = new Case(3, 4, caseEau);
			map[2][5] = new Case(2, 5, caseEau);
			map[3][5] = new Case(3, 5, caseEau);
			
			map[6][4] = new Case(6, 4, caseEau);
			map[7][4] = new Case(7, 4, caseEau);
			map[6][5] = new Case(6, 5, caseEau);
			map[7][5] = new Case(7, 5, caseEau);
				
			
		}

		
	
		
		/**
		 * place un pion sur une case mise en param�tre
		 * @param name pion � placer
		 * @param coordXCase coordonn�e X de la case sur laquelle sera plac� le pion
		 * @param coordYCase coordonn�e Y de la case sur laquelle sera plac� le pion
		 */
		public void placerUnPion(Pion nom, int coordXCase, int coordYCase) {
			
			this.map[coordXCase][coordYCase].setPionPresent(nom);
			
		}
		
		/**
		 * pose le pion de la caseOrigine sur la caseArrivee et retire le pion de la caseOrigine
		 * @param caseOrigine case d'origine
		 * @param caseArrivee case d'arriv�e
		 */
		public void deplacerUnPion(Case caseOrigine, Case caseArrivee) {
			
			this.map[caseArrivee.getCoordX()][caseArrivee.getCoordY()].setPionPresent(caseOrigine.getPionPresent());
			this.retirerUnPion(caseOrigine.getCoordX(), caseOrigine.getCoordY());		
		}
		
		/**
		 * Retire le pion d'une case
		 * @param coordXCase coordonn�e X de la case de laquelle sera retir� le pion
		 * @param coordYCase coordonn�e Y de la case de laquelle sera retir� le pion
		 */
		public void retirerUnPion(int coordXCase, int coordYCase) {
			
			this.map[coordXCase][coordYCase].setPionPresent(null);
		}
		
		/**
		 * Retire le pion d'une case
		 * @param uneCase case de laquelle est retir� le pion
		 */
		public void retirerUnPion(Case uneCase){
			
			this.map[uneCase.getCoordX()][uneCase.getCoordY()].setPionPresent(null);
		}
		
		/**
		 * retourne la case en position [i][j]
		 * @param i 
		 * @param j
		 * @return une case ou null
		 */
		public Case getCase(int i, int j) {
			
			return this.map[i][j];
		}
		
		public Case getCaseSelectionnee() {
			
			return this.caseSelectionnee;
		}
		
		public void setCaseSelectionnee(int coordX, int coordY) {
			caseSelectionnee = map[coordX][coordY];
		}
		
		public Case[][] getPlateauDeJeu() {
			return map;
		}
		
		
		
	}

