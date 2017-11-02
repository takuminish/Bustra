package Game;

import java.awt.Color;
import java.awt.Graphics;

import Base.Window;
import Game.Drop.FireDrop;

// Windowクラスを継承したGameWindowクラスを作るよ
// ゲーム画面を表示するクラスだよ(GameWindowクラスはBoardクラス、Fieldクラス、GameManagerクラスを持つ)
public class GameWindow extends Window{
	
	private Board board;               // Boardクラスを持つよ
	private GameManager manager;

	public GameWindow() {
		super(800,600);	                  // ゲーム画面の大きさを指定するよ	
		board = new Board(6,5,80);        // 横6ドロップ、縦5ドロップ、ドロップの直径80の盤面を作るよ
		manager = new GameManager(board); // GameManagerクラスを定義するよ
	}
	// ゲーム画面を表示するよ
	@Override
    public void paint(Graphics g){
        super.paint(g);
        this.add(this.board);            // 盤面をゲーム画面に乗せるよ
        
    }
}
