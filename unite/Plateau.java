package unite;

import java.util.ArrayList;

public class Plateau{
	
	private int nbLig;
	private int nbCol;
	private int[][] grille;

   /*Il faudra utiliser des array via ArrayList()
    * 
    * Car int[][] n'est pas modifiable
    * 
    * ou alors on le passe en paramètre
    * 
    * */
   
   public Plateau(int l,int c) 
   {
	   nbLig = l;
	   nbCol =c;
	   grille = this.getGrille();
   }
    public String getCase() 
    {
    	
    	return "";
    }
    
    public void setGrille(int l, int c) {
    	
    
    }
    
    public int[][] getGrille()
    {
    	return grille;
    }
   

//elements visuel du plateau
  
  

}
