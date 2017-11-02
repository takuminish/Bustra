package Game;

// ゲームに必要な値を持つGameEnvironmentクラスを作るよ
public class GameEnvironment {

	private final int BOARDWIDTH = 6;      // 盤面の横のドロップの数を指定
	private final int BOARDHEIGHT = 5;     // 盤面の縦のドロップの数を指定
	private final int DROPDIAMETER = 80;   // ドロップの大きさを指定
	
	// 盤面の横のドロップの数を返すよ
	public int getBourdWidth() {
		return this.BOARDWIDTH;
	}
	
	// 盤面の縦のドロップの数を返すよ
	public int getBourdHeight() {
		return this.BOARDHEIGHT;
	}
	
	// ドロップの大きさを返すよ
	public int getDropDiameter() {
		return this.DROPDIAMETER;
	}
}
