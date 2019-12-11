package model;

public enum Unite {
	
	DRAPEAU("Drapeau",0,0,0,"drapeau.png"),
	BOMBE("Bombe",8,0,100,"bombe.png"),
	DEMINEUR("D�mineur",1,3,160,"demineur.png"),
	ECLAIREUR("Eclaireur",3,5,100,"eclaireur.png"),
	GENERAL("G�n�ral",6,3,700,"general.png"),
	ESPION("Espion",4,3,500,"espion.png"),
	CAPORAL("Caporal",5,2,360,"caporal.png"),
	SABOTEUR("Saboteur",2,2,500,"saboteur.png"),
	TANK("Char d'assaut",7,1,1000,"tank.png");
	
	private String nom,url;
	
	private int grade,deplacement,prix;
	
	
	Unite(String nom, int grade,int deplacement,int prix,String url) {
		this.nom = nom;
		this.grade = grade;
		this.deplacement = deplacement;
		this.prix = prix;
		this.url = url;
	
		
	}
	
	

	public String getName() {return nom;}

	public int getDeplace() {return deplacement;}

	public int getGrade() {return grade;}

	public int getPrice() {return prix;}
	
	public String getURL() {return url;}
	
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
