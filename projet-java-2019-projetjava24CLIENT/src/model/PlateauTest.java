/**
 * 
 */
package model;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

/**
 * @author florent janssens
 *
 */
class PlateauTest {

	
	
	@Test
	void testOccuperLaCase() {
		Plateau p = new Plateau();
		p.occuperLaCase(new Case(2,2));
		
		
	}
	
	@Test
	void testLibererLaCase() {
		Plateau p = new Plateau();
		p.libererLaCase(new Case(2,2));
		
		
	}
	
	@Test
	void testCalculerDistance() {
		Plateau p = new Plateau();
		p.calculerDistance(new Case(2,2),4,4);
		
		
	}
	
	
	@Test
	void testPlacerUnPion() {
		Plateau p = new Plateau();
		p.placerPion(new Pion(Unite.BOMBE,Color.BLUE),new Case(2,2));
		//assertEquals(Unite.BOMBE,p.)
		
	}
	
	@Test
	void testDeplacer() {
		Plateau p = new Plateau();
		p.deplacer(new Pion(Unite.SABOTEUR, Color.BLUE),2,2);
		
		
		
	}
	
	@Test
	void TestTerminerCombat() {
		Plateau p = new Plateau();
		p.terminerCombat(new Pion(Unite.SABOTEUR,Color.BLUE),new Pion(Unite.TANK,Color.RED),new Joueur("Florent",Color.BLUE),new Case(2,2));
		
		
		
	}
	
	

}
