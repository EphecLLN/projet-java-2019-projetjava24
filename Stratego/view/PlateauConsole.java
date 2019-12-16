/**
 * 
 */
package view;

/**
 * @author Crenier Amaury
 *
 */
public class PlateauConsole {

	private int nbRow;
	private int nbCol;
	private int [][] grille;
	
	public PlateauConsole (int nbRow, int nbCol) {
		this.nbRow = nbRow;
		this.nbCol = nbCol;
		this.grille = new int [nbRow][nbCol];
		
		for (int i=0; i < nbRow; i++) {
			for (int j=0; j < nbCol; j++) {
				grille[i][j] = 0;
			}
		}
	}
	
	public void dessinerPlateau() {
		System.out.println();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(" | " + grille[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
	
	public void placerPion(int x, int y, int unite) {
		if ( x < 0 || y < 0 || x > nbRow || y > nbCol) {
			System.out.print("Position non valide!");
			return;
		}
		if (grille[x][y] == 0) {
			grille[x][y] = unite;
		}
		else {
			System.out.print("Case occupée!");
		}
	}
}
