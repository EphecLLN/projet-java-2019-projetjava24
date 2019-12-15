package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CaseTest {

	@Test
	void testCaseConstructeurParam() {
		Case c = new Case(2,4,"terrain");
		assertEquals(2, c.getCoordX());
		assertEquals(4, c.getCoordY());
		assertEquals("terrain", c.getTypeCase());
		assertEquals(false, c.getPionPresent());
		
	}
	
	@Test
	void testCaseConstructeur() {
		Case c = new Case();
		assertEquals(-1, c.getCoordX());
		assertEquals(-1, c.getCoordY());
		assertEquals("Default Case", c.getTypeCase());
		assertEquals(false, c.getPionPresent());
		
	}


}
