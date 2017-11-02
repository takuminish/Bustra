package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

public class LightDrop extends Drop{
		
	public LightDrop(int x,int y) {
		super(x,y);
		super.id = 2;
		File f = new File("image/light.png");
		this.image = this.Image(f);
		System.out.println("a");
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}

}
