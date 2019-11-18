/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * @author Crenier Amaury
 *
 */
public class Stratego extends JFrame {
	
	private Panneau panneau = new Panneau();
	private JButton bouton = new JButton("Start Game");
	
	public Stratego() {
		this.setVisible(true);
		this.setTitle("Stratego Remastered");
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(panneau);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(bouton, BorderLayout.NORTH);
				
		this.setVisible(true);	
	}
}
