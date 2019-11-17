package unite;

public enum Unite {
	
	DRAPEAU("Drapeau",0,0,0,0,0,1),
	BOMBE("Bombe",8,0,2,2,100,3),
	DEMINEUR("D�mineur",3,3,1,1,160,3),
	ECLAIREUR("Eclaireur",2,5,1,1,100,5),
	GENERAL("G�n�rale",6,3,4,2,700,1),
	ESPION("Espion",1,3,2,1,500,1),
	CAPORAL("Caporale",4,2,3,2,360,5),
	SABOTEUR("Saboteur",5,2,3,1,500,1),
	TANK("Char d'assaut",7,1,6,3,1000,1);
	
	protected String nom;
	
	private int grade,deplacement,portee,force,prix,limit;
	
	
	Unite(String nom,int grade, int deplacement,int portee, int force, int prix, int limit) {
		this.nom = nom;
		this.grade = grade;
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
	
	public int getGrade() {return grade;}
	

	
	//m�thode de diff�renciation en combat
	
	public boolean estDetruit(Unite ennemi) 
	{
		switch(this.getName()) 
		{
		case "D�mineur": return ennemi.getName()=="Bombe";
		
		case "Espion": return ennemi.getName()=="G�n�rale";
		
		case "saboteur": return ennemi.getName()=="Char d'assaut";
		
		default: return false;
		}
		
		
	}
	
	


}
