package model;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Florent Janssens
 * 
 */



import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;
import model.Pion;
import model.Unite;
class PionTest {

	
	@Test
	void testPionConstructeur() {
		Pion p = new Pion(Unite.BOMBE,Color.BLUE);
		assertEquals(Unite.BOMBE, p.getUnite());
		assertEquals(-1, p.getPosition().getCoordX());
		assertEquals(-1, p.getPosition().getCoordY());
		p.setPosition(new Case(0,0));
		assertEquals(0, p.getPosition().getCoordX());
		assertEquals(0, p.getPosition().getCoordY());
		
		
	}
	
	
	@Test
	void testCombattre() {
		Pion p1 = new Pion(Unite.CAPORAL,Color.BLUE);
		Pion p2 = new Pion(Unite.GENERAL,Color.RED);
		Pion gagnant = p1.combattre(p2);
		assertEquals(gagnant, p2);
	}

}
