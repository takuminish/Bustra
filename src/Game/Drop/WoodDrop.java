// Game.Dropパッケージ
package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

// Dropクラスを継承して闇ドロップクラスを作るよ
public class WoodDrop extends Drop{
	
	// コンストラクタ
	public WoodDrop(int x,int y) {
		super(x,y);                          // 受け取ったx、yからx座標とy座標を決めるよ
		super.id = 2;                        // ドロップのIDだよ(木ドロップは2)
		File f = new File("image/wood.png"); // Fileクラスに木ドロップの画像を入れるよ
		this.image = this.Image(f);          // Dropクラスに定義されている関数からimageに画像を入れるよ
	}
	
	// 木ドロップの表示
	public void paint(Graphics g) {
		super.paint(g);                      //Dropクラスのpaintを呼んでいるよ
	}

}

