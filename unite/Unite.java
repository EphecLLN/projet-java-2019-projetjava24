package unite;

public enum Unite {
	
	DRAPEAU("Drapeau",0,0,0,1),
	BOMBE("Bombe",0,2,100,3),
	DEMINEUR("Démineur",3,1,160,3),
	ECLAIREUR("Eclaireur",5,1,100,5),
	GENERAL("Génerale",3,4,700,1),
	ESPION("Espion",3,2,500,1),
	CAPORAL("Caporale",2,3,360,5),
	SABOTEUR("Saboteur",2,3,500,1),
	TANK("Char d'assaut",1,6,1000,1);
	
	private String name;
	private int deplace;
	private int strength;
	private int price;
	private int limit;
	
	Unite(String name, int deplace, int strength, int price, int limit) {
		this.name = name;
		this.deplace = deplace;
		this.strength = strength;
		this.price = price;
		this.limit = limit;
		
	}

	public String getName() {return name;}

	public int getDeplace() {return deplace;}

	public int getStrength() {return strength;}

	public int getPrice() {return price;}
	
	public int getLimit() {return limit;}


}
