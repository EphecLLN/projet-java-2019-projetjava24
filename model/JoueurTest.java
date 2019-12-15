/**
 * 
 */
package model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;

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
	void testJoueurConstructeur() {
		Joueur joueurA = new Joueur("Amaury",Color.BLUE);
		Joueur joueurB = new Joueur("Florent", Color.RED);
		assertEquals("Amaury", joueurA.getPseudo());
		assertEquals("Florent", joueurB.getPseudo());
		assertEquals(Color.BLUE, joueurA.getCouleur());
		assertEquals(Color.RED, joueurB.getCouleur());
		//assertEquals(20, joueurA.getReserve());
	}
	

	
	/**
	 * Test method for {@link model.Joueur#acheter(model.Unite)}
	 */
	@Test
	void testAcheter() {
		Joueur joueurA = new Joueur("Amaury", Color.BLUE);
		joueurA.acheterUnite(Unite.BOMBE);
		assertEquals(21, joueurA.getReserve());
	}
	
	
	@Test
	void testGenererSoldeParTour() {
		Joueur joueurA = new Joueur("Florent", Color.BLUE);
		joueurA.genererSoldeParTour();
		assertEquals(25, joueurA.getSolde());
	}
	
	@Test
	void TestEstPret() {
		Joueur joueurA = new Joueur("Florent", Color.BLUE);
		//joueurA.setReserve();;
		assertEquals(true, joueurA.estPret());
	}
	
	
	@Test
	void TestInitReserveDepart() {
		Joueur joueurA = new Joueur("Florent",Color.BLUE);
		joueurA.initReserveDepart();
	}
	
	
	
	
	/**
	 * Test method for {@link model.Joueur#payer(model.Unite)}.
	 */
	@Test
	void compteurReserve() {
		Joueur joueurA = new Joueur("Amaury", Color.BLUE);
		//assertEquals(Unite.BOMBE.getPrice(), "Bombe");
	}
	

	
}
