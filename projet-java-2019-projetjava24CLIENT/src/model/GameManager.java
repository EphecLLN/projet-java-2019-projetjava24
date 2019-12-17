package model;

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.paint.Color;

public class GameManager {
	
	public static final int port = 13999;
	static Joueur joueur1;
	static Joueur joueur2;
	static Plateau plateau;
	static Pion pionSelectionne;
	static Pion pionSelectionneReserve;
	public static String message = "";
	static String [] elements;
	
	/**
	 * 
	 * @param courrier
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void connexion(String courrier) throws ClassNotFoundException, IOException, InterruptedException {
		MultiClient.newClient(courrier);
	}
	
	/**
	 * 
	 * @param courrier
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void connexionServer(String courrier) throws ClassNotFoundException, IOException, InterruptedException {
		MultiServer.newServer(courrier);
	}
	
	/**
	 * 
	 */
	public static void recupJoueur() {
		elements = MultiClient.reception.split(" ");
		joueur2 = new Joueur(elements[0], Color.web(elements[1]));
		System.out.println(joueur2.toString());
	}
	
	/**
	 * 
	 */
	public static void recupPion() {
		elements = MultiClient.reception.split(" ");
		ArrayList<String> sousElements = new ArrayList<String>();
		String [] instancesPion;
		for (int i = 0; i < elements.length; i++) {
			sousElements.add(elements[i]);
		}
		for (int i = 0; i < sousElements.size(); i++) {
			instancesPion = sousElements.get(i).split(":");
			Unite unite = null;
			switch (instancesPion[0]) {
			case "Drapeau": unite = Unite.DRAPEAU;
			case "Bombe": unite = Unite.BOMBE;
			case "Démineur": unite = Unite.DEMINEUR;
			case "Eclaireur": unite = Unite.ECLAIREUR;
			case "Général": unite = Unite.GENERAL;
			case "Espion": unite = Unite.ESPION;
			case "Caporal": unite = Unite.CAPORAL;
			case "Saboteur": unite = Unite.SABOTEUR;
			case "Tank": unite = Unite.TANK;
			}
			Case endroit = plateau.map[Integer.parseInt(instancesPion[1].split(",")[0])][Integer.parseInt(instancesPion[1].split(",")[1])];
			endroit.setPionPresent(true);
			Color couleur = Color.web(instancesPion[2]);
			Pion pion = new Pion(unite, couleur);
			pion.setPosition(endroit);
			plateau.pionsEnJeu.put(endroit, pion);
		}
		
	}
	
	/**
	 * 
	 * @param pion
	 * @return
	 */
	public static String traiterPion(Pion pion) {
		String unite = pion.getUnite().getName();
		String endroit = Integer.toString(pion.getPosition().getCoordX()) + "," + Integer.toString(pion.getPosition().getCoordY());
		String couleur = joueur1.getCouleur().toString();
		return unite + ":" + endroit + ":" + couleur + " ";
	}
	
	/**
	 * 
	 * @param pseudo
	 * @param couleur
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InterruptedException
	 */
	public static void demarrer(String pseudo, Color couleur) throws IOException, ClassNotFoundException, InterruptedException {
		plateau = new Plateau();
		joueur1 = new Joueur(pseudo, couleur);
		joueur1.initReserveDepart();
		connexion(pseudo + " " + couleur.toString());
		System.out.println(pseudo + couleur.toString());
		System.out.println(joueur1.toString());
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void deplacer(int x, int y) throws ClassNotFoundException, IOException, InterruptedException {
		plateau.deplacer(pionSelectionne, x, y);
		connexion(message);
		joueur1.genererSoldeParTour();
		//recupPion();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public static void selectionner(int x, int y) {
		pionSelectionne = plateau.pionsEnJeu.get(plateau.map[x][y]);
	}
	
	/**
	 * 
	 * @param index
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void selectionnerReserve(int index) throws ClassNotFoundException, IOException, InterruptedException {
		if(model.GameManager.getJoueur1().getReserve().size() != 0){
			pionSelectionneReserve = joueur1.getReserve().get(index);
			System.out.println(pionSelectionneReserve.toString());
		}
		else {
			connexion(message);
			recupPion();
		}
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public static void placerPion(int x, int y) {
		if (plateau.map[x][y].getPionPresent()) {
			System.err.println("Case déjà occupée!");
		}
		else {
			plateau.placerPion(pionSelectionneReserve , plateau.map[x][y]);
			joueur1.getReserve().remove(pionSelectionneReserve);
			System.out.println("pion placé: " + plateau.pionsEnJeu.get(plateau.map[x][y]).toString());
		}
	}

	public static Joueur getJoueur1() {
		return joueur1;
	}
	public static Joueur getJoueur2() {
		return joueur2;
	}
	public static Pion getPionSelectionneReserve() {
		return pionSelectionneReserve;
	}
	public static Plateau getPlateau() {
		return plateau;
	}
	public static String getMessage() {
		return message;
	}

	public static Pion getPionSelectionne() {
		return pionSelectionne;
	}
}
