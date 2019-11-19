package model;

import model.Pion;
import model.Unite;

public class Pion {

private Unite soldat;
public Placement position;

	/**Constructeur  de la class Pion
	 * @param nom un pion qui doit �tre d�fini dans l'enum Unite pou y r�cup�rer l'ensemble des donn�es
	 */
	public Pion(Unite nom) 
	{
		soldat =nom;
		position = new Placement(this);
		
	}
	
	
	/**
	 * @return
	 */
	public String getNom() {return soldat.getName();}
	
	/**
	 * @return
	 */
	public Unite getUnite() {return this.soldat;}
	
	public Placement getPosition() 
	{
		return position;
	}


}


	
	
	


