package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Base.Panel;

public class Drop extends Panel{
	
	protected int id;
	private final int WIDTH = 80;
	private final int HEIGHT = 80;
	private int x;
	private int y;
	private ImageObserver imageobserver = null;
	protected BufferedImage image;
	
	public Drop(int x, int y) {
		this.x = x;
		this.y = y;
		this.setBounds(x, y, WIDTH, HEIGHT);
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
	
	public int getWidth() {
		return this.WIDTH;
	}
	
	public int getHeight() {
		return this.HEIGHT;
	}
	
	public void paint(Graphics g) {
		g.drawImage(this.image,0,0,this.getWidth(),this.getHeight(),null);
	}
	

}
