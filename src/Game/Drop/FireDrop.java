// Game.Dropパッケージ
package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

// Dropクラスを継承して火ドロップクラスを作るよ
public class FireDrop extends Drop{
	
	// コンストラクタ
	public FireDrop(int x,int y) {
		super(x,y);                          // 受け取ったx、yからx座標とy座標を決めるよ
		super.id = 0;                        // ドロップのIDだよ(火ドロップは0)
		File f = new File("image/fire.png"); // Fileクラスに火ドロップの画像を入れるよ
		this.image = this.Image(f);          // Dropクラスに定義されている関数からimageに画像を入れるよ
	}
	
	// 火ドロップの表示
	public void paint(Graphics g) {
		super.paint(g);                      //Dropクラスのpaintを呼んでいるよ
	}

}

