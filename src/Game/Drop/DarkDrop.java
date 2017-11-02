package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

public class DarkDrop extends Drop{
		
	public DarkDrop(int x,int y) {
		super(x,y);
		super.id = 1;
		File f = new File("image/dark.png");
		this.image = this.Image(f);
		System.out.println("a");
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}

}

