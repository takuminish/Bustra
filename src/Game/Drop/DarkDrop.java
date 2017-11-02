// Game.Dropパッケージ
package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

// Dropクラスを継承して闇ドロップクラスを作るよ
public class DarkDrop extends Drop{
	
	// コンストラクタ
	public DarkDrop(int x,int y) {
		super(x,y);                          // 受け取ったx、yからx座標とy座標を決めるよ
		super.id = 3;                        // ドロップのIDだよ(闇ドロップは3)
		File f = new File("image/dark.png"); // Fileクラスに闇ドロップの画像を入れるよ
		this.image = this.Image(f);          // Dropクラスに定義されている関数からimageに画像を入れるよ
	}
	
	// 闇ドロップの表示
	public void paint(Graphics g) {
		super.paint(g);                      //Dropクラスのpaintを呼んでいるよ
	}

}

