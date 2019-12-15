package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Pion;
import model.Unite;
class PionTest {

	
	@Test
	void testPionConstructeur() {
		Pion p = new Pion(Unite.BOMBE);
		assertEquals(Unite.BOMBE, p.getUnite());
		assertEquals(-1, p.getPosition().getCoordX());
		assertEquals(-1, p.getPosition().getCoordY());
		p.setPosition(new Case(0,0,"Terrain"));
		assertEquals(0, p.getPosition().getCoordX());
		assertEquals(0, p.getPosition().getCoordY());
		
		
	}
	
	
	@Test
	void testCombattre() {
		Pion p1 = new Pion(Unite.CAPORAL);
		assertEquals(Unite.CAPORAL, p1.combattre(new Pion(Unite.DEMINEUR)));
	}

}
