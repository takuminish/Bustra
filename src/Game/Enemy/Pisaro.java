package Game.Enemy;

import java.awt.Graphics;
import java.io.File;

public class Pisaro extends Enemy{

	public Pisaro() {
		super();
		this.id = 1;
		File f = new File("image/buspisaro.png"); // Fileクラスに水ドロップの画像を入れるよ
		this.image = this.Image(f);          // Dropクラスに定義されている関数からimageに画像を入れるよ
	}
	
	// 闇ドロップの表示
	public void paint(Graphics g) {
		super.paint(g);                      //Dropクラスのpaintを呼んでいるよ
	}
}
