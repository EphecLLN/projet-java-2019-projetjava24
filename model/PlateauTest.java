/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

/**
 * @author flore
 *
 */
class PlateauTest {

	
	
	@Test
	void testOccuperLaCase() {
		Plateau p = new Plateau();
		p.occuperLaCase(new Case(2,2,"Terrain"));
		
		
	}
	
	@Test
	void testLibererLaCase() {
		Plateau p = new Plateau();
		p.libererLaCase(new Case(2,2,"Terrain"));
		
		
	}
	
	@Test
	void testCalculerDistance() {
		Plateau p = new Plateau();
		p.calculerDistance(new Case(2,2,"Terrain"),4,4);
		
		
	}
	
	
	@Test
	void testPlacerUnPion() {
		Plateau p = new Plateau();
		p.placerPion(new Pion(Unite.BOMBE),new Case(2,2,"Terrain"));
		//assertEquals(Unite.BOMBE,p.)
		
	}
	
	@Test
	void testDeplacer() {
		Plateau p = new Plateau();
		p.deplacer(new Pion(Unite.SABOTEUR),2,2);
		
		
		
	}
	
	@Test
	void TestTerminerCombat() {
		Plateau p = new Plateau();
		p.terminerCombat(new Pion(Unite.SABOTEUR),new Pion(Unite.TANK),new Joueur("Florent",Color.BLUE),new Case(2,2,"Terrain"));
		
		
		
	}
	
	

}
