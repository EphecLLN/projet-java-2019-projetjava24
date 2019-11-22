package model;

public enum Unite {
	
	DRAPEAU("Drapeau",0,0,0),
	BOMBE("Bombe",8,0,100),
	DEMINEUR("Démineur",1,3,160),
	ECLAIREUR("Eclaireur",3,5,100),
	GENERAL("Générale",6,3,700),
	ESPION("Espion",4,3,500),
	CAPORAL("Caporale",5,2,360),
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
	

	



}
