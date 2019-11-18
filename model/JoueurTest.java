/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

/**
 * @author Crenier Amaury
 * 
 */
class JoueurTest {

	/**
	 * Test method for {@link model.Joueur#Joueur(String, int)}.
	 */
	@Test
	void testJoueur() {
		Joueur joueurA = new Joueur("Amaury", 1);
		assertEquals("Amaury", joueurA.getPseudo());
		assertEquals(1, joueurA.getId());
		assertEquals(Color.BLUE, joueurA.getCouleur());
		assertEquals(20, joueurA.getReserve());
	}
	
	/**
	 * Test method for {@link model.Joueur#getCouleur()}.
	 */
	@Test
	void testGetCouleur() {
		Joueur joueurA = new Joueur("Amaury", 1);
		Joueur joueurB = new Joueur("Amaury", 2);
		assertEquals(Color.BLUE, joueurA.getCouleur());
		assertEquals(Color.RED, joueurB.getCouleur());
	}
	
	/**
	 * Test method for {@link model.Joueur#acheter(model.Unite)}
	 */
	@Test
	void testAcheter() {
		Joueur joueurA = new Joueur("Amaury", 1);
		Pion newSoldat = joueurA.acheter(Unite.BOMBE);
		assertEquals(21, joueurA.getReserve());
		assertEquals(Unite.BOMBE, newSoldat);
	}
	
	/**
	 * Test method for {@link model.Joueur#payer(model.Unite)}.
	 */
	@Test
	void testPayer() {
		Joueur joueurA = new Joueur("Amaury", 1);
		assertEquals(Unite.BOMBE.getPrice(), joueurA.payer(Unite.BOMBE));
	}
	
	/**
	 * Test method for {@link model.Joueur#estPret()}.
	 */
	@Test
	void testEstPret() {
		Joueur joueurA = new Joueur("Amaury", 1);
		joueurA.setReserve(0);
		assertEquals(true, joueurA.estPret());
	}
	
	/**
	 * Test method for {@link model.Joueur#retirerReserve()}.
	 */
	@Test
	void testRetirerReserve() {
		Joueur joueurA = new Joueur("Amaury", 1);
		joueurA.retirerReserve();
		assertEquals(19, joueurA.getReserve());
	}
}
