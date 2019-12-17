package model;

public class Case {
		
		private int coordX;
		private int coordY;
		private boolean pionPresent;
		
		/**
		 * Constructeur
		 * @param coordX, coordonnée X de la case sur le plateau de jeu
		 * @param coordY, coordonnée Y de la case sur le plateau de jeu
		 */
		public Case(int coordX, int coordY) {
			
			this.coordX = coordX;
			this.coordY = coordY;
			this.pionPresent = false;
		}
		/**
		 * Constructeur sans param
		 */
		public Case() {
			this.coordX = -1;
			this.coordY = -1;
			this.pionPresent = false;
		}
		
		
			
		public int getCoordX() {
			return coordX;
		}

		public void setCoordX(int coordX) {
			this.coordX = coordX;
		}
			
		public int getCoordY() {
			return coordY;
		}
			
		public void setCoordY(int coordY) {
			this.coordY = coordY;
		}
			
		public boolean getPionPresent() {
			return pionPresent;
		}
			
		public void setPionPresent(boolean presence) {
			this.pionPresent = presence;
		}
}