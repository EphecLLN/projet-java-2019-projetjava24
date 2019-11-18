package model;

public enum Direction {
	
	HAUT(" a avanc� de "),
	BAS(" a recul� de "),
	DROITE(" a �t� sur la droite de "),
	GAUCHE("a �t� sur la gauche de ");
	
	private String msg;
	//ajout d'un message
	Direction(String msg)
	{
		this.msg = msg;
	}
	
	public String getMsg(){return msg;}

}
