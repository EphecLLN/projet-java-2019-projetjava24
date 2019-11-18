package model;

public enum Direction {
	
	HAUT(" a avancé de "),
	BAS(" a reculé de "),
	DROITE(" a été sur la droite de "),
	GAUCHE("a été sur la gauche de ");
	
	private String msg;
	//ajout d'un message
	Direction(String msg)
	{
		this.msg = msg;
	}
	
	public String getMsg(){return msg;}

}
