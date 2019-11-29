package model;

public enum Unite {
	
	DRAPEAU("Drapeau",0,0,0),
	BOMBE("Bombe",8,0,100),
	DEMINEUR("D�mineur",1,3,160),
	ECLAIREUR("Eclaireur",3,5,100),
	GENERAL("G�n�ral",6,3,700),
	ESPION("Espion",4,3,500),
	CAPORAL("Caporal",5,2,360),
	SABOTEUR("Saboteur",2,2,500),
	TANK("Char d'assaut",7,1,1000);
	
	private String nom;
	
	private int grade,deplacement,prix;
	
	
	Unite(String nom, int grade,int deplacement,int prix) {
		this.nom = nom;
		this.grade = grade;
		this.deplacement = deplacement;
		this.prix = prix;
	
		
	}
	
	

	public String getName() {return nom;}

	public int getDeplace() {return deplacement;}

	public int getGrade() {return grade;}

	public int getPrice() {return prix;}
	
	public static Unite convertirStrUnite(String unite) {
		switch (unite) {
		case "drapeau": return Unite.DRAPEAU;
		case "bombe": return Unite.BOMBE;
		case "d�mineur": return Unite.DEMINEUR;
		case "�claireur": return Unite.ECLAIREUR;
		case "g�n�ral": return Unite.GENERAL;
		case "espion": return Unite.ESPION;
		case "caporal": return Unite.CAPORAL;
		case "saboteur": return Unite.SABOTEUR;
		case "char d'assaut": return Unite.TANK;
		default: return null;
		}
	}



}
