package Game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Base.Window;
import Game.Drop.FireDrop;
import Base.GameEnvironment;
import Game.Enemy.*;
import Game.Manager.GameManager;
import Game.Manager.*;
// Windowクラスを継承したGameWindowクラスを作るよ
// ゲーム画面を表示するクラスだよ(GameWindowクラスはBoardクラス、Fieldクラス、GameManagerクラスを持つ)
public class GameWindow extends Window{
	
	private Board board;               // Boardクラスを持つよ
	private BoardManager manager;       // GameManagerクラスを持つよ
	private GamePlayer gamePlayer;     // GamePlayerクラスを持つよ
	private Field field;
	public GameWindow(int width,int height) {

		super(width,height);	                  // ゲーム画面の大きさを指定するよ
		field = new Field();
		board = new Board();                              // 横6ドロップ、縦5ドロップ、ドロップの直径80の盤面を作るよ
		manager = new BoardManager(board);                            // GameManagerクラスを定義するよ
		gamePlayer = new GamePlayer(manager);           // GamePlayerクラスを定義するよ
		addMouseListener(gamePlayer);            // MouseListenerを使えるようにするよ
		addMouseMotionListener(gamePlayer);      // MouseMotionListenerを使えるようにするよ
		addKeyListener(gamePlayer);      // MouseMotionListenerを使えるようにするよ
		setFocusable(true);
	}
	// ゲーム画面を表示するよ
	@Override
    public void paint(Graphics g){
        super.paint(g);
        this.add(this.board);            // 盤面をゲーム画面に乗せるよ
        this.add(this.field);            // 上の画面をゲーム画面に乗せるよ
    }
}
