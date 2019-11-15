/**
 * 
 */
package unite;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

/**
 * @author amaur
 *
 */
class JoueurTest {

	@Test
	void testJoueur() {
		Joueur joueurA = new Joueur("Amaury", 1);
		assertEquals("Amaury", joueurA.getPseudo());
		assertEquals(1, joueurA.getId());
		assertEquals(Color.BLUE, joueurA.getCouleur());
		assertEquals(20, joueurA.getReserve());
	}
	
	void testGetCouleur() {
		Joueur joueurA = new Joueur("Amaury", 1);
		Joueur joueurB = new Joueur("Amaury", 2);
		assertEquals(Color.BLUE, joueurA.getCouleur());
		assertEquals(Color.RED, joueurB.getCouleur());
	}
	
	void acheter() {
		Joueur joueurA = new Joueur("Amaury", 1);
		Pion newSoldat = joueurA.acheter(Unite.BOMBE);
		assertEquals(21, joueurA.getReserve());
		assertEquals(Unite.BOMBE, newSoldat);
	}
	
	void testPayer() {
		Joueur joueurA = new Joueur("Amaury", 1);
		assertEquals(Unite.BOMBE.getPrice(), joueurA.payer(Unite.BOMBE));
	}
	
	void testEstPret() {
		Joueur joueurA = new Joueur("Amaury", 1);
		joueurA.setReserve(0);
		assertEquals(true, joueurA.estPret());
	}
	
	void testRetirerReserve() {
		Joueur joueurA = new Joueur("Amaury", 1);
		joueurA.retirerReserve();
		assertEquals(19, joueurA.getReserve());
	}
	
	
	
}
