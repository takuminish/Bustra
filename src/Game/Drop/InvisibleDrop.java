// Game.Dropパッケージ
package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

// Dropクラスを継承して無効ドロップクラスを作るよ
// 無効だから画像は持たないよ
public class InvisibleDrop extends Drop{
	
	// コンストラクタ
	public InvisibleDrop(int x,int y) {
		super(x,y);                          // 受け取ったx、yからx座標とy座標を決めるよ
		super.id = -1;                        // ドロップのIDだよ(無効ドロップは-1)
		
	}
}

