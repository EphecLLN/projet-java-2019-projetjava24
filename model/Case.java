 package model;

import javafx.beans.property.IntegerProperty;

public class Case {
		
		private IntegerProperty coordX;
		private IntegerProperty coordY;
		private boolean pionPresent;
		private String typeCase;
		
		/**
		 * Constructeur
		 * @param coordX, coordonnée X de la case sur le plateau de jeu
		 * @param coordY, coordonnée Y de la case sur le plateau de jeu
		 * @param typeCase, type de la Case: terrain ou eau
		 */
		public Case(int coordX, int coordY, String typeCase) {
			
			this.coordX.set(coordX);
			this.coordY.set(coordY);
			this.typeCase = typeCase;
			this.pionPresent = false;
		}
		
		public Case() {
			this.coordX.set(-1);
			this.coordY.set(-1);
			this.typeCase = "Default Case";
			this.pionPresent = false;
		}
		
		
			
		public int getCoordX() {
			return coordX.getValue();
		}

		public void setCoordX(int coordX) {
			this.coordX.set(coordX);
		}
			
		public int getCoordY() {
			return coordY.getValue();
		}
			
		public void setCoordY(int coordY) {
			this.coordY.set(coordY);;
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
		
		public IntegerProperty coordXProperty() {
			return coordX;
		}
		
		public IntegerProperty coordYProperty() {
			return coordY;
		}
		
		
		/**
		 * Copie les attributs de la case dans le flux de sortie
		 * @param outputStream le flux de sortie
		 */
		public void write(DataOutputStream outputStream) {
			try {
				//si le pion présent n'est pas true, on écrit vrai suivi des informations du pion
				//sinon on écrit false
				if(pionPresent != false) {
					outputStream.writeBoolean(true);
				}
				else
					outputStream.writeBoolean(false);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Lit la case et récupère tous ses attributs à partir d'un flux d'entrée
		 * @param inputStream le flux d'entrée
		 */
		public void read(DataInputStream inputStream) {
			//lit et récupère le pion présent (s'il y en a un)
			try {
				boolean bool = inputStream.readBoolean();

				if (bool) {
					pionPresent = true;
					//pionPresent.read(inputStream);
				}
				else 
					pionPresent = false;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
}
