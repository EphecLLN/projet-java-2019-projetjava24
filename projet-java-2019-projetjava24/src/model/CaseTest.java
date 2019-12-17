package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * @author Florent Janssens
 * 
 */
class CaseTest {

	@Test
	void testCaseConstructeurParam() {
		Case c = new Case(2,4);
		assertEquals(2, c.getCoordX());
		assertEquals(4, c.getCoordY());
		assertEquals(false, c.getPionPresent());
		
	}
	
	@Test
	void testCaseConstructeur() {
		Case c = new Case();
		assertEquals(-1, c.getCoordX());
		assertEquals(-1, c.getCoordY());
		assertEquals(false, c.getPionPresent());
		
	}


}
