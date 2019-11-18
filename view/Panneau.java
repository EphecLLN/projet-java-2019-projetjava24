/**
 * 
 */
package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Crenier Amaury
 *
 */
public class Panneau extends JPanel {
	
	public void paintComponent(Graphics g) {
		try {
			Image image = ImageIO.read(new File("stratego.jpg"));
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
