/**
 * 
 */
package unite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tp.Fraction;

/**
 * @author florent Janssens
 *
 */
class PlateauTest {

	@Test
	void testplacerUnPion() {
		Plateau p = new Plateau();
		p.placerUnPion("bombe", 6, 2);
		p.setCoordX(6);
		assertEquals(p.getCoordX(),6);
		p.setCoordY(2);
		assertEquals(p.getCoordY(), 2);
		p.setPionPresent("bombe");
		assertEquals(p.getPionPresent(), "bombe");
		
	}
	
	/*@Test
	void testdeplacerUnPion() {
		Plateau p = new Plateau();
		p.deplacerUnPion(map[6][2], map[8][9]);
		p.setCoordX(6);
		assertEquals(p.getCoordX(),6);
		p.setCoordY(2);
		assertEquals(p.getCoordY(), 2);
		p.setPionPresent("bombe");
		assertEquals(p.getPionPresent(), "bombe");
		
	}*/
	
	@Test
	void testRetirerUnPion() {
		Case c = new Case(6, 2, "caseTerrain");
		c.setPionPresent("null");
		assertEquals(c.getPionPresent(), "null");
	}
	
	
	@Test
	void testgetCase() {
		Plateau p = new Plateau();
		p.getCase(3,6);
		p.setCoordX(3);
		assertEquals(p.getCoordX(),3);
		p.setCoordY(6);
		assertEquals(p.getCoordY(), 6);
		
	}
}



