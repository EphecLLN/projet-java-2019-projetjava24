package unit;

public abstract class Unite {
	
	public  void hasAttackedBy(int strength) {
		if((this instanceof Weak)&&((getStrength())/2)==strength) {
			System.out.println(getName()+" s'est fait éliminé");
		}else {
			if(this.getStrength() >= strength) {
				System.out.println(getName()+" a gagné");
			}else {
				System.out.println(getName()+" a perdu");
			}
		}
	}
	
	
	public void deplace(String direction,int deplace) {
		if(getDeplace() >= deplace) {
		
			switch(direction) {
			case "Up":System.out.println(getName()
					+" Move "+direction);
				break;
			case "Down":System.out.println(getName()
					+" Move "+direction);
				break;
			case "Left":System.out.println(getName()
					+" Move "+direction);
				break;
			case "Right":System.out.println(getName()
					+" Move "+direction);
				break;
			default:System.out.println("Error type");
				break;
			
			}
		}else {
			System.out.println("Not Enough Deplace");
		}
	}
	
	private String name;
	private int deplace;
	private int strength;
	private int price;
	private int limit;
	
	public Unite(String name, int deplace, int strength, int price, int limit) {
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
