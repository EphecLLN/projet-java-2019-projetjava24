package model;

public class Case {
		
		private int coordX;
		private int coordY;
		private boolean pionPresent;
		private String typeCase;
		
		/**
		 * Constructeur
		 * @param coordX, coordonnée X de la case sur le plateau de jeu
		 * @param coordY, coordonnée Y de la case sur le plateau de jeu
		 * @param typeCase, type de la Case: terrain ou eau
		 */
		public Case(int coordX, int coordY, String typeCase) {
			
			this.coordX = coordX;
			this.coordY = coordY;
			this.typeCase = typeCase;
			this.pionPresent = false;
		}
		
		public Case() {
			this.coordX = -1;
			this.coordY = -1;
			this.typeCase = "Default Case";
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
			
		public String getTypeCase() {
			return typeCase;
		}		
}