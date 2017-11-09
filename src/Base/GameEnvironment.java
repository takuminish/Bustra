package Base;

// ゲームに必要な値を持つGameEnvironmentクラスを作るよ
public class GameEnvironment {

	private final int BOARDWIDTH = 6;      // 盤面の横のドロップの数を指定
	private final int BOARDHEIGHT = 5;     // 盤面の縦のドロップの数を指定
	private final int DROPDIAMETER = 60;   // ドロップの大きさを指定
	private final int WINDOWWIDTH = 377;   // 画面の横の長さを指定するよ
	private final int WINDOWHEIGHT = 600;  // 画面の縦の長さを指定するよ
	private final int BOARDPOSITION = 260; // 盤面の位置を指定するよ 
	
	// 盤面の位置を返すよ
	public int getBoardPosition() {
		return this.BOARDPOSITION;
	}
	
	// 画面の横の長さを返すよ
	public int getWindowWidth() {
		return this.WINDOWWIDTH;
	}
		
	// 画面の縦の長さを返すよ
	public int getWindowHeight() {
		return this.WINDOWHEIGHT;
	}
	
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
