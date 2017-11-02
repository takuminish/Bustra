// Game.Dropパッケージ
package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

// Dropクラスを継承して光ドロップクラスを作るよ
public class LightDrop extends Drop{
	
	// コンストラクタ
	public LightDrop(int x,int y) {
		super(x,y);                          // 受け取ったx、yからx座標とy座標を決めるよ
		super.id = 4;                        // ドロップのIDだよ(光ドロップは4)
		File f = new File("image/light.png"); // Fileクラスに光ドロップの画像を入れるよ
		this.image = this.Image(f);          // Dropクラスに定義されている関数からimageに画像を入れるよ
	}
	
	// 光ドロップの表示
	public void paint(Graphics g) {
		super.paint(g);                      //Dropクラスのpaintを呼んでいるよ
	}

}

