package controler;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import model.Case;
import model.Joueur;
import model.Pion;
import model.Plateau;
import model.Unite;

public class StrategoGUIController {

	@FXML
	//partie Joueur -> solde joueur, nom joueur, pions joueur
	private TextField solde;
	@FXML
	private Label pseudoTag;
	@FXML
	private Circle colorTag;
	
	private Joueur j;
	
	//partie Unite -> achat & info Unite
	

	
	@FXML
	private ChoiceBox<Object> choiceUnite = new ChoiceBox<Object>(FXCollections.observableArrayList(Unite.DRAPEAU.getName(),
				new Separator(),Unite.DEMINEUR.getName(),Unite.BOMBE.getName(),Unite.ECLAIREUR,
				new Separator(),Unite.ESPION.getName(),Unite.GENERAL.getName(),Unite.CAPORAL.getName(),
				new Separator(),Unite.SABOTEUR.getName(),Unite.TANK.getName()));
	@FXML
	private Label soldeUnite;
	@FXML
	private Label forceLabel;
	@FXML
	private ProgressBar forceProgress;
	@FXML
	private Label deplaceLabel;
	@FXML
	private ProgressBar deplaceProgress;
	
	@FXML
	private Button acheter;
	
	private Unite u;
	
	

		
	//partie se Déplacer
	@FXML
	private Spinner<Integer> deplaceSelect;
	@FXML
	private Button up;
	@FXML
	private Button down;
	@FXML
	private Button rigth;
	@FXML
	private Button left;
	
	private Plateau p;
	
	
	//pions 
	@FXML 
	private GridPane terrain;
	
	
	
	private Group soldatGUI;
	private Pion soldat;
	
	
	@FXML
	private void Initialize() {
		
		pseudoTag.setText(this.j.getPseudo());
		colorTag.setFill(this.j.getCouleur());
		
		solde.textProperty().bind(this.j.soldeProperty().asString());
		choiceUnite.itemsProperty().set(FXCollections.observableArrayList(Unite.DRAPEAU,
				new Separator(),Unite.DEMINEUR,Unite.BOMBE,Unite.ECLAIREUR,
				new Separator(),Unite.ESPION,Unite.GENERAL,Unite.CAPORAL,
				new Separator(),Unite.SABOTEUR,Unite.TANK));
		choiceUnite.setOnAction(e->{this.setStat();});
		
		acheter.setOnAction(e->{this.acheter();});
		
		terrain.add(new Label("Test"), 0, 0);
		
		//reserveUnite.setCellValueFactory(e -> );
		

	}
	
	
	
	private void addSolde() {
		solde.textProperty().addListener((observable,oldvalue,newvalue)
				->{
					newvalue = oldvalue + 25;
					this.j.setSolde(Integer.valueOf(newvalue));
				});
		//this.j.genererSoldeParTour();
	}
	
	
	private void subSolde() {
		u = (Unite) choiceUnite.getValue();
		
		if(u.getPrice()> j.getSolde()) {
			solde.requestFocus();
			soldeUnite.setOpacity(0.5);
		}else {
			this.j.setSolde(this.j.getSolde() - u.getPrice());
			//reserve.getChildren().add(reserve.getChildren().size(), new Label(u.getName()));
		}
	}
	
	public void setModel(Joueur j) {
		this.j = j;
		this.Initialize();
		
		
	}
	
	//partie Unite info
	@FXML
	public void setStat() {
		u = (Unite) choiceUnite.getValue();
		forceLabel.setText("Force : " + u.getGrade());
		forceProgress.setProgress((double) u.getGrade()/10);
		
		deplaceLabel.setText("Déplacement : "+ u.getDeplace());
		deplaceProgress.setProgress((double) u.getDeplace()/10);
		
		soldeUnite.setText("Prix : " + u.getPrice());
		soldeUnite.setOpacity(1.0);
	}
	
	//partie se Déplacer
	@FXML
	public void coordChange() {
		
	}
	//pions
	@FXML
	public void acheter() {
		this.subSolde();
		
		u = (Unite) choiceUnite.getValue();
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
