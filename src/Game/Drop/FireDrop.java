package Game.Drop;

import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

public class FireDrop extends Drop{
	
	public BufferedImage Image;
	
	public FireDrop(int x,int y) {
		super(x,y);
		File f = new File("fir.png");
		Image = this.Image(f);
	}

}
