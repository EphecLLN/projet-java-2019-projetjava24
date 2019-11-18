/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Crenier Amaury
 *
 */
class SoldeTest {

	/**
	 * Test method for {@link model.Solde#Solde()}.
	 */
	@Test
	void testSolde() {
		Solde solde = new Solde();
		assertEquals(0, solde.getValeur());
		assertEquals(0, solde.getJoueurId());
	}
	
	/**
	 * Test method for {@link model.Solde#attribuerJoueur(model.Joueur)}.
	 */
	@Test
	void testAttribuerJoueur() {
		Joueur joueur = new Joueur("Amaury", 1);
		Solde solde = new Solde();
		solde.attribuerJoueur(joueur);
		assertEquals(1, solde.getJoueurId());
	}
	
	/**
	 * Test method for {@link model.Solde#augmenter(int)}.
	 */
	@Test
	void testAugmenter() {
		Solde solde = new Solde();
		solde.augmenter(20);
		assertEquals(20, solde.getValeur());
	}
	
	/**
	 * Test method for {@link model.Solde#diminuer(int)}.
	 */
	@Test
	void testDiminuer() {
		Solde solde = new Solde();
		solde.diminuer(20);
		assertEquals(-20, solde.getValeur());
	}
	
	

}
