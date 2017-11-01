package Game.Drop;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Drop extends JPanel{
	
	private final int WIDTH = 40;
	private final int HEIGHT = 40;
	private int x;
	private int y;
	
	public Drop(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public BufferedImage Image(File f) {
		BufferedImage image = null;
		try {
			  image = ImageIO.read(f);
			} catch (Exception e) {
			  e.printStackTrace();
			  image = null;
			}
		return image;
	}

}
