package Base;

// ゲームに必要な値を持つGameEnvironmentクラスを作るよ
public class GameEnvironment {

	public static final int BOARDWIDTH = 6;      // 盤面の横のドロップの数を指定
	public static final int BOARDHEIGHT = 5;     // 盤面の縦のドロップの数を指定
	public static final int DROPDIAMETER = 60;   // ドロップの大きさを指定
	public static final int WINDOWWIDTH = 377;   // 画面の横の長さを指定するよ
	public static final int WINDOWHEIGHT = 600;  // 画面の縦の長さを指定するよ
	public static final int ENEMYWIDTH = 150;
	public static final int ENEMYHEIGHT = 150;
	public static final int ENEMYX = (GameEnvironment.WINDOWWIDTH - GameEnvironment.ENEMYWIDTH) / 2;
	public static final int ENEMYY = 40;
	public static final int TEXTFRAMEWIDTH = 200;
	public static final int TEXTFRAMEHEIGHT = 50;
	public static final int TEXTWIDTH = 200;
	public static final int TEXTHEIGHT = 50;
	public static final int TEXTX = 10;
	public static final int TEXTY = 0;
	public static final int TEXTFRAMEX = (GameEnvironment.WINDOWWIDTH - GameEnvironment.TEXTFRAMEWIDTH) / 2;
	public static final int TEXTFRAMEY = 200;
	public static final int BOARDX = 0;
	public static final int BOARDY = 260;
	public static final int FIELDX = 0;
	public static final int FIELDY = 0;
	public static final int FIELDWIDTH = 360;
	public static final int FIELDHEIGHT = 300;
	
	public static void sleep(int time) {
		try{
			Thread.sleep(time); 
			}catch(InterruptedException e){}
	}

}
