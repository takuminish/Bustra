package Game;

import java.awt.Color;
import java.awt.Graphics;

import Base.Window;
import Game.Drop.FireDrop;

// Windowクラスを継承したGameWindowクラスを作るよ
// ゲーム画面を表示するクラスだよ(GameWindowクラスはBoardクラスとFieldクラスを持つ)
public class GameWindow extends Window{
	
	private Board board;               // Boardクラスを持つよ

	public GameWindow() {
		super();		
		board = new Board(6,5);        // 横6ドロップ、縦5ドロップの盤面を作るよ
	}
	// ゲーム画面を表示するよ
	@Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBounds(0, 0, 800, 600);  // 指定した位置と大きさの位置に表示するよ
        this.add(this.board);            // 盤面をゲーム画面に乗せるよ
        
    }
}
