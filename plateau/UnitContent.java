package plateau;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UnitContent extends JPanel{
	
	JLabel Deplace,Strength;
	JButton Price;
	
	public UnitContent(int deplace,int strength) {
		super();
		this.showStat(deplace, strength);
		this.setBounds(0, 0, 540, 540);
		
		
	}
	
	private void showStat(int deplace,int strength) {
		Deplace = new JLabel();
		Strength = new JLabel();
		this.Deplace.setText("Déplacement : "+ String.valueOf(deplace));
		this.Strength.setText("Force : "+ String.valueOf(strength));
		this.Deplace.setBounds(400, 20, 90, 20);
		this.Strength.setBounds(100, 50, 90, 20);
		this.add(Deplace);
		this.add(Strength);
	}
	
	private void buyButton(int price) {
		
	}

}
