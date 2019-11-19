package model;

public enum Unite {
	
	DRAPEAU("Drapeau",0,0,0,1),
	BOMBE("Bombe",8,0,100,3),
	DEMINEUR("Démineur",1,3,160,3),
	ECLAIREUR("Eclaireur",3,5,100,5),
	GENERAL("Générale",6,3,700,1),
	ESPION("Espion",4,3,500,1),
	CAPORAL("Caporale",5,2,360,5),
	SABOTEUR("Saboteur",2,2,500,1),
	TANK("Char d'assaut",7,1,1000,1);
	
	private String nom;
	
	private int grade,deplacement,prix,limit;
	
	
	Unite(String nom, int grade,int deplacement,int prix, int limit) {
		this.nom = nom;
		this.grade = grade;
		this.deplacement = deplacement;
		this.prix = prix;
		this.limit = limit;
		
	}
	
	

	public String getName() {return nom;}

	public int getDeplace() {return deplacement;}

	public int getGrade() {return grade;}

	public int getPrice() {return prix;}
	
	public int getLimit() {return limit;}
	
	//méthode de différenciation en combat
	
	public boolean estDetruit(Unite ennemi) 
	{
		switch(this.getName()) 
		{
		case "Démineur": return ennemi.getName()=="Bombe";
		
		case "Espion": return ennemi.getName()=="Générale";
		
		case "saboteur": return ennemi.getName()=="Char d'assaut";
		
		default: return false;
		}
		
		
	}
	
	


}
