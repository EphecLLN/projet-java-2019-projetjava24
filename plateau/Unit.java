package plateau;

import javax.swing.JFrame;

public class Unit extends JFrame{
	UnitContent unit;
	
	public Unit(String name,int deplace,int strength) {
		super(name);
		propUnit(deplace,strength);
	}
	
	private void propUnit(int deplace,int strength) {
		
		this.setSize(540,540);
		this.setResizable(false);
		this.setLocation(10, 10);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		unit = new UnitContent(deplace,strength);
		this.setContentPane(unit);
		
	}

}
