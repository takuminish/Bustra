package Game.Enemy;

import java.awt.Graphics;
import java.io.File;
import java.net.URL;

public class HardEnemy extends Enemy{

	public HardEnemy() {
		super();
		this.id = 1;
		this.name = "バスピサロ";
		this.hp = 6;
		this.url = getClass().getClassLoader().getResource("buspisaro.png");
		this.image = this.Image(url);          // Dropクラスに定義されている関数からimageに画像を入れるよ
	    this.setNorma();	    
	}
	
	// 闇ドロップの表示
	public void paint(Graphics g) {
		super.paint(g);                      //Dropクラスのpaintを呼んでいるよ
	}
	
	@Override
	public void setNorma() {
		for (int k = 0; k < this.hp; k++) {
		    this.damagenorma.add((int)(Math.random()*3) + 5);
		}
	}
	
}
