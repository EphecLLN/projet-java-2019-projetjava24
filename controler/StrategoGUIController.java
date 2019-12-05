package controler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Joueur;

public class StrategoGUIController {

	@FXML
	private TextField solde;
	private Label pseudo;
	
	private Joueur j;
	
	@FXML
	private void Initialize() {
		solde.setText(String.valueOf(this.j.getSolde()));
		pseudo.setText(this.j.getPseudo());
	}
	
	@FXML
	private void addSolde() {
		solde.textProperty().addListener((observable,oldvalue,newvalue)
				->{
					newvalue = oldvalue + 25;
					this.j.setSolde(Integer.valueOf(newvalue));
				});
		this.j.genererSoldeParTour();
	}
	
	public void setJ(Joueur j) {
		this.j = j;
		solde.textProperty().bind(this.j.soldeProperty().asString());
		pseudo.textProperty().bind(this.j.pseudoProperty());
	}
	
}
