package src;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
	
	private ObjectProperty<Unite> uProperty = new ObjectProperty<Unite>() {

		@Override
		public void bind(ObservableValue<? extends Unite> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isBound() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void unbind() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getBean() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void addListener(ChangeListener<? super Unite> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeListener(ChangeListener<? super Unite> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addListener(InvalidationListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeListener(InvalidationListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Unite get() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void set(Unite arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
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
	@FXML
	private TableView<Unite> reserve;
	@FXML
	private TableColumn<Unite, String> reserveUnite;
	
	private ObservableList<Unite> enReserve = FXCollections.observableArrayList();
	
	
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
	
	public ObservableList<Unite> getEnReserve(){
		return enReserve;
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
	
	public void creerPion(Unite u,int x, int y) {
		//partie model
		Pion soldat = new Pion(u);
		Case c = new Case();
		c.setCoordX(x);
		c.setCoordY(y);
		p.placerPion(soldat, c);
		
		//partie GUI
		terrain.add(new Label(soldat.getUnite().getName()), x, y);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
