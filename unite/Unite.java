package unite;

public enum Unite {
	
	DRAPEAU("Drapeau",0,0,0,0,1),
	BOMBE("Bombe",0,2,2,100,3),
	DEMINEUR("Démineur",3,1,1,160,3),
	ECLAIREUR("Eclaireur",5,1,1,100,5),
	GENERAL("Génerale",3,4,2,700,1),
	ESPION("Espion",3,2,1,500,1),
	CAPORAL("Caporale",2,3,2,360,5),
	SABOTEUR("Saboteur",2,3,1,500,1),
	TANK("Char d'assaut",1,6,3,1000,1);
	
	private String nom;
	
	private int deplacement,portee,force,prix,limit;
	
	
	Unite(String nom, int deplacement,int portee, int force, int prix, int limit) {
		this.nom = nom;
		this.deplacement = deplacement;
		this.portee = portee;
		this.force = force;
		this.prix = prix;
		this.limit = limit;
		
	}

	public String getName() {return nom;}

	public int getDeplace() {return deplacement;}

	public int getStrength() {return force;}

	public int getPrice() {return prix;}
	
	public int getLimit() {return limit;}
	
	public int getPortee() {return portee;}


}
