package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

public class FireDrop extends Drop{
		
	public FireDrop(int x,int y) {
		super(x,y);
		super.id = 0;
		File f = new File("image/fire.png");
		this.image = this.Image(f);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}

}
