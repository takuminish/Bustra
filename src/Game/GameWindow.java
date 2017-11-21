package Game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Base.Window;
import Game.Drop.FireDrop;
import Base.GameEnvironment;
import Game.Enemy.*;
import Game.Manager.BoardManager;
import Game.Manager.FieldManager;
import Game.Thread.DropThread;
import Game.Thread.SleepThread;

// Windowクラスを継承したGameWindowクラスを作るよ
// ゲーム画面を表示するクラスだよ(GameWindowクラスはBoardクラス、Fieldクラス、GameManagerクラスを持つ)
public class GameWindow extends Window{

	private Board board;               // Boardクラスを持つよ
	private Field field;
	private BoardManager Bmanager;
	private FieldManager Fmanager;

	public GameWindow(int width,int height,String deficult) {

		super(width,height);	                  // ゲーム画面の大きさを指定するよ
		this.board = new Board();
		this.field = new Field(3,deficult);
		this.Bmanager = new BoardManager(this.board);
		this.Fmanager = new FieldManager(this.field,3);
		setFocusable(true);
		this.add(this.board);            // 盤面をゲーム画面に乗せるよ
		this.add(this.field);            // 上の画面をゲーム画面に乗せるよ
		this.board.setBounds(GameEnvironment.BOARDX,GameEnvironment.BOARDY,GameEnvironment.BOARDWIDTH * GameEnvironment.DROPDIAMETER,GameEnvironment.BOARDHEIGHT * GameEnvironment.DROPDIAMETER);
		this.field.setBounds(GameEnvironment.FIELDX,GameEnvironment.FIELDY,GameEnvironment.FIELDWIDTH,GameEnvironment.FIELDHEIGHT);
	}
	// ゲーム画面を表示するよ
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}

	public void dropHold(int mouseX,int mouseY) {
		mouseY -= GameEnvironment.BOARDY;
		this.Bmanager.holdManagement(mouseX, mouseY);
	}

	// GameManagerのメソッドを呼び出してドロップを動かすよ
	public void dropMove(int mouseX,int mouseY) {
		mouseY -= GameEnvironment.BOARDY;
		this.Bmanager.MoveManagement(mouseX, mouseY);
	}

	// GameManagerのメソッドを呼び出してドロップを放すよ
	public void dropLost() {
		this.Bmanager.LostManagement();
		this.Bmanager.comboDicision(() ->  this.Fmanager.DamageDecision(this.Bmanager.getCombo()));
	}
}
