package unite;
import java.io.IOException;

/**
 * @author florent janssens
 *
 */   

public class Case {



	/**
	* La classe Case contient tous les attributs propres à une case :
	 *	- ses coordonées,
	*	- le pion présent dessus (null s'il n'y en a pas),
	*	- son type.
	*/

		
		private int coordX;
		private int coordY;
		protected String pionPresent;
		/**
		* Cette variable prend la valeur  Plateau.caseTerrain ou Plateau.caseEau.
		*/
		private String typeCase;
		
		/**
		 * Constructeur
		 * @param coordX coordonnée X de la case sur le plateau de jeu
		 * @param coordY coordonnée Y de la case sur le plateau de jeu
		 * @param typeCase type de la Case Plateau.caseTerrain ou Plateau.caseEau
		 */
		public Case(int coordX, int coordY, String typeCase) {
			
			this.coordX = coordX;
			this.coordY = coordY;
			this.typeCase = typeCase;
			this.pionPresent = null;
		}
		
		/**
		 * Constructeur sans paramètre
		 */
		public Case() {
			
		}
		
		
			
			public int getCoordX()
			{
				return coordX;
			}

			public void setCoordX(int coordX)
			{
				this.coordX = coordX;
			}
			
			public int getCoordY()
			{
				return coordY;
			}
			
			public void setCoordY(int coordY)
			{
				this.coordY = coordY;
			}
			
			public String getPionPresent()
			{
				return pionPresent;
			}
			
			public void setPionPresent(String nom)
			{
				this.pionPresent = nom;
			}
			
			public String getTypeCase()
			{
				return typeCase;
			}

			

		
		}