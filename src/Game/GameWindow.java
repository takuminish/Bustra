package Game;

import java.awt.Color;
import java.awt.Graphics;

import Base.Window;
import Game.Drop.FireDrop;

// Windowクラスを継承したGameWindowクラスを作るよ
// ゲーム画面を表示するクラスだよ(GameWindowクラスはBoardクラス、Fieldクラス、GameManagerクラスを持つ)
public class GameWindow extends Window{
	
	private Board board;               // Boardクラスを持つよ
	private GameManager manager;       // GameManagerクラスを持つよ
	private GamePlayer gamePlayer;     // GamePlayerクラスを持つよ

	public GameWindow() {
		super(800,600);	                  // ゲーム画面の大きさを指定するよ
		
		board = new Board();                              // 横6ドロップ、縦5ドロップ、ドロップの直径80の盤面を作るよ
		manager = new GameManager(board);                            // GameManagerクラスを定義するよ
		gamePlayer = new GamePlayer(manager);           // GamePlayerクラスを定義するよ
		addMouseListener(gamePlayer);            // MouseListenerを使えるようにするよ
		addMouseMotionListener(gamePlayer);      // MouseMotionListenerを使えるようにするよ
	}
	// ゲーム画面を表示するよ
	@Override
    public void paint(Graphics g){
        super.paint(g);
        this.add(this.board);            // 盤面をゲーム画面に乗せるよ
        
    }
}
