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
class BanqueTest {

	/**
	 * Test method for {@link model.Banque#Banque()}.
	 */
	@Test
	void testBanque() {
		Banque banque = new Banque();
		assertEquals(0, banque.getSolde1().getValeur());
		assertEquals(0, banque.getSolde2().getValeur());
		assertEquals(0, banque.getSolde2().getJoueurId());
		assertEquals(0, banque.getSolde2().getJoueurId());
	}
	
	/**
	 * Test method for {@link model.Banque#initBanque(model.Joueur, model.Joueur)}.
	 */
	@Test
	void testInitBanque() {
		Joueur joueur1 = new Joueur("Amaury", 1);
		Joueur joueur2 = new Joueur("Florent", 2);
		Banque banque = new Banque();
		banque.initBanque(joueur1, joueur2);
		assertEquals(1, banque.getSolde1().getJoueurId());
		assertEquals(2, banque.getSolde2().getJoueurId());
	}
	

}
