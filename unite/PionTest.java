package unite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unite.Pion;

class PionTest {

	
	@Test
	void testPion() {
		Pion c = new Pion(Unite.CAPORAL);
		
		
			
		assertEquals("a","a");
		
		
	}
	@Test
	void testCombat() 
	{
		Pion e = new Pion(Unite.ESPION);
		Pion g = new Pion(Unite.GENERAL);
		Pion c = new Pion(Unite.CAPORAL);
		
		assertEquals(e.combat(g), false);
	}

}
