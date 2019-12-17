package model;

public enum Unite {
	
	DRAPEAU("Drapeau",9,0,0),
	BOMBE("Bombe",8,0,100),
	DEMINEUR("Démineur",1,1,160),
	ECLAIREUR("Eclaireur",3,10,100),
	GENERAL("Général",6,1,700),
	ESPION("Espion",4,1,500),
	CAPORAL("Caporal",5,1,360),
	SABOTEUR("Saboteur",2,1,500),
	TANK("Tank",7,1,1000);
	
	private String nom;
	
	private int grade,deplacement,prix;
	
	
	/**
	 * Constructeur avec param
	 * @param nom
	 * @param grade
	 * @param deplacement
	 * @param prix
	 */
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
	
	/**
	 * 
	 * @param unite
	 * @return
	 */
	public static Unite convertirStrUnite(String unite) {
		switch (unite) {
		case "drapeau": return Unite.DRAPEAU;
		case "bombe": return Unite.BOMBE;
		case "démineur": return Unite.DEMINEUR;
		case "éclaireur": return Unite.ECLAIREUR;
		case "général": return Unite.GENERAL;
		case "espion": return Unite.ESPION;
		case "caporal": return Unite.CAPORAL;
		case "saboteur": return Unite.SABOTEUR;
		case "Tank": return Unite.TANK;
		default: return null;
		}
	}



}
