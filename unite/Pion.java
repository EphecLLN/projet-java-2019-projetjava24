package unite;

public class Pion {

private Unite id;
	

	public Pion(Unite id) 
	{
		this.id =id;
		

	}
	
	public String getName() {return id.getName();}

	public int getDeplace() {return id.getDeplace();}

	public int getStrength() {return id.getStrength();}

	public int getPrice() {return id.getPrice();}
	
	public int getLimit() {return id.getLimit();}
}
