package controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import model.GameManager;
import model.Unite;

public class ControllerGUI implements Initializable {
	
	private static  Node actif;
	private  Unite win;
	@FXML
	private  GridPane plateau;
	@FXML
	private TextField pseudo;
	@FXML
	private ColorPicker couleur;
	@FXML
	private TextArea fenetre;
	@FXML
	private TextField x;
	@FXML
	private TextField y;
	@FXML
	private TextField ligne;
	@FXML
	private TextField colonne;
	@FXML
	private ListView<String> reserve;
	@FXML
	private Button demarrer;
	@FXML
	private  Button pret;
	@FXML
	private Button deplace;
	@FXML
	private ChoiceBox<Unite> box;
	@FXML
	private TextField ip;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		agir();
		box.getItems().add(model.Unite.BOMBE);
		box.getItems().add(model.Unite.CAPORAL);
		box.getItems().add(model.Unite.DEMINEUR);
		box.getItems().add(model.Unite.ECLAIREUR);
		box.getItems().add(model.Unite.ESPION);
		box.getItems().add(model.Unite.GENERAL);
		box.getItems().add(model.Unite.SABOTEUR);
		box.getItems().add(model.Unite.TANK);
	}
	
	public void ip() throws UnknownHostException {
		model.MultiClient.host = InetAddress.getByName(ip.getText());
		model.MultiServer.host = InetAddress.getByName(ip.getText());
	}
		
	public void updatePlateau() {
		plateau.getChildren().clear();
		plateau.setGridLinesVisible(true);
		model.GameManager.getPlateau().pionsEnJeu.forEach((c, p) -> {
			Circle pion = new Circle(16.0, p.getCouleur());
			pion.setOnMouseClicked(event -> {
				selectionner(event);              //clear plateau au début
			});
			pion.setStroke(Color.BLACK);
			pion.setStrokeType(StrokeType.INSIDE);
			pion.setId(p.getCouleur() + p.getUnite().getName());
			//Image im = new Image(p.getUnite().getUrl());
			//pion.setFill(new ImagePattern(im));
			plateau.add(pion, c.getCoordY(), c.getCoordX());
			GridPane.setHalignment(pion, HPos.CENTER);
			GridPane.setValignment(pion, VPos.CENTER);
			System.out.println("case: " + c + ", pion: " + p);
			win = model.Plateau.getWin();
		});
		if (win == Unite.DRAPEAU) {
			fenetre.setText("Partie terminée");
			plateau.getChildren().clear();
		}
	}
	
	public void agir() {
		pret.setDisable(true);
	}
	public void dormir() {
		pret.setDisable(false);
	}
	
	@FXML
	public void pret(ActionEvent e) throws ClassNotFoundException, IOException, InterruptedException {
		agir();
		GameManager.connexion("attente");
		model.GameManager.recupPion();
		updatePlateau();
		fenetre.setText("Partie en cours\nvotre solde:" + model.GameManager.getJoueur1().getSolde() + " pièces\\nle pion selectionne:\n" + model.GameManager.getPionSelectionne().getUnite().getName());
	}
	
	@FXML
	public void deplacer(ActionEvent e) throws NumberFormatException, ClassNotFoundException, IOException, InterruptedException {
		model.GameManager.message = "";
		model.GameManager.message += model.GameManager.traiterPion(model.GameManager.getPionSelectionne());
		model.GameManager.deplacer(Integer.parseInt(ligne.getText()), Integer.parseInt(colonne.getText()));
		GridPane.setRowIndex(actif, Integer.parseInt(ligne.getText()));
		GridPane.setColumnIndex(actif, Integer.parseInt(colonne.getText()));
		plateau.getChildren().remove(plateau.getChildren().indexOf(actif));
		updatePlateau();
		dormir();
		deplace.setDisable(true);
		fenetre.setText("Partie en cours\nvotre solde:" + model.GameManager.getJoueur1().getSolde() + " pièces\nle pion selectionne:\n" + model.GameManager.getPionSelectionne().getUnite().getName());
	}
	
	@FXML
	public void placerPion(ActionEvent e) {	
		model.GameManager.placerPion(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
		//if (model.GameManager.getPlateau().map[Integer.parseInt(x.getText())][Integer.parseInt(y.getText())].getPionPresent()) {	
			//fenetre.setText("Case déjà occupée!");
		//}
		//else {if() {
		if(model.GameManager.getPlateau().map[Integer.parseInt(x.getText())][Integer.parseInt(y.getText())].getPionPresent()) {
			Circle pion = new Circle(16.0, model.GameManager.getJoueur1().getCouleur());
			pion.setOnMouseClicked(event -> {
				selectionner(event);
			});
			pion.setStroke(Color.BLACK);
			pion.setStrokeType(StrokeType.INSIDE);
			pion.setId(model.GameManager.getJoueur1().getCouleur() + model.GameManager.getPionSelectionneReserve().getUnite().getName());
			plateau.add(pion, Integer.parseInt(y.getText()), Integer.parseInt(x.getText()));
			GridPane.setHalignment(pion, HPos.CENTER);
			GridPane.setValignment(pion, VPos.CENTER);
			reserve.getItems().remove(model.GameManager.getPionSelectionneReserve().getUnite().getName());
			System.out.println("ID du pion: " + pion.getId());
			model.GameManager.message += model.GameManager.traiterPion(model.GameManager.getPionSelectionneReserve());
		}	//}
	}
	
	@FXML
	public void demarrer(ActionEvent e) throws InterruptedException, ClassNotFoundException, IOException {
		model.GameManager.demarrer(pseudo.getText(), couleur.getValue());
		model.GameManager.recupJoueur();
		fenetre.setText("Bienvenue " + pseudo.getText() + "\n" + "votre adversaire est :\n" + model.GameManager.getJoueur2().getPseudo());
		reserve.getItems().clear();
		for (int i = 0; i < model.GameManager.getJoueur1().getReserve().size(); i++) {
			reserve.getItems().add(model.GameManager.getJoueur1().getReserve().get(i).getUnite().getName());
		}
		demarrer.setDisable(true);
		//faire une méthode dans game manager gérant la boucle
	}
	
	
	@FXML //PLATEAU
	public static void selectionner(MouseEvent e) {
		Node source = (Node) e.getSource();
		int ligne = GridPane.getRowIndex(source);
		System.out.println(ligne);
		int colonne = GridPane.getColumnIndex(source);
		System.out.println("L: " + ligne + "C: " + colonne);
		model.GameManager.selectionner(ligne, colonne);
		actif = source;
	}
	
	@FXML //RESERVE
	public void selectionnerReserve(MouseEvent e) throws ClassNotFoundException, IOException, InterruptedException {
		model.GameManager.selectionnerReserve(reserve.getSelectionModel().getSelectedIndex());
		updatePlateau();
		fenetre.setText(pseudo.getText() + "\nsera le premier à jouer");
	}
	
	@FXML
	public void acheter(ActionEvent e) {
		model.GameManager.getJoueur1().acheterUnite(box.getSelectionModel().getSelectedItem());
		reserve.getItems().add(model.GameManager.getJoueur1().getReserve().get(0).getUnite().getName());
	}
}
