/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

/**
 * @author Florent Janssens
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
		assertEquals(0, joueurA.getSolde());
		assertEquals(0, joueurB.getSolde());
		assertEquals(0, joueurA.getReserve().size());
	}
	

	
	/**
	 * Test method for {@link model.Joueur#acheter(model.Unite)}
	 */
	@Test
	void testAcheter() {
		Joueur joueurA = new Joueur("Amaury", Color.BLUE);
		joueurA.setSolde(1000);
		joueurA.acheterUnite(Unite.BOMBE);
		assertEquals(900, joueurA.getSolde());
		assertEquals(Unite.BOMBE, joueurA.getReserve().get(0).getUnite());
		joueurA.setSolde(10);
		joueurA.acheterUnite(Unite.BOMBE);
		assertEquals(-90, joueurA.getSolde());
		assertEquals(2, joueurA.getReserve().size());
		
	}
	
	
	@Test
	void testGenererSoldeParTour() {
		Joueur joueurA = new Joueur("Florent", Color.BLUE);
		joueurA.genererSoldeParTour();
		assertEquals(25, joueurA.getSolde());
		joueurA.genererSoldeParTour();
		assertEquals(50, joueurA.getSolde());
		
	}
	
	@Test
	void TestEstPret() {
		Joueur joueurA = new Joueur("Florent", Color.BLUE);
		//joueurA.setReserve();;
		assertEquals(true, joueurA.estPret());
		joueurA.initReserveDepart();
		assertEquals(false, joueurA.estPret());
	}
	
	
	@Test
	void TestInitReserveDepart() {
		Joueur joueurA = new Joueur("Florent",Color.BLUE);
		joueurA.initReserveDepart();
		assertEquals(Unite.DRAPEAU, joueurA.getReserve().get(0).getUnite());
		assertEquals(21, joueurA.getReserve().size());
	}
	
	
	
	
	/**
	 * Test method for {@link model.Joueur#payer(model.Unite)}.
	 */
	@Test
	void compteurReserve() {
		Joueur joueurA = new Joueur("Amaury", Color.BLUE);
		joueurA.initReserveDepart();
		int compteur = joueurA.compteurReserve(joueurA.getReserve(), "Bombe");
		assertEquals(3, compteur);
		
	
	}
	

	
}
