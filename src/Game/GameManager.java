package Game;

import java.util.ArrayList;

import Game.Drop.Drop;
import Game.Board;

// 盤面の管理を行うよ
// コンボの判定、残り時間の測定はこのクラスで行うよ
public class GameManager {

	private Board board;                  // Bpardクラスのインスタンス
	private GameEnvironment environment;  // ゲームに必要な値を得るインスタンス
	private int BoardX;                   // 盤面の横のドロップの数
	private int BoardY;                   // 盤面の縦のドロップの数
	private int dropDiameter;             // ドロップの大きさ
	private int dropX;
	private int dropY;
	
	public GameManager(Board board) {
		environment = new GameEnvironment();
		this.board = board;
		this.BoardX = this.environment.getBourdWidth();
		this.BoardY = this.environment.getBourdHeight();
		this.dropDiameter = this.environment.getDropDiameter();
		ArrayList<Drop> drop = new ArrayList<Drop>();
	//	drop.add(this.board.getBoard().get(1).get(1));
	//	drop.add(this.board.getBoard().get(2).get(2));
	//	this.board.dropDelete(drop);
	}
	
	// マウスの座標から持つドロップを決定しドロップを持つよ
	public void holdManagement(int mouseX, int mouseY) {
		this.dropX = mouseX / this.dropDiameter;  // マウスの座標から左から何番目のドロップなのかを取得
		this.dropY = mouseY / this.dropDiameter;  // マウスの座標から上から何番目のドロップなのかを取得
		board.getBoard().get(this.dropY).get(this.dropX).hold(mouseX - (this.dropDiameter / 2),mouseY - (this.dropDiameter / 2));  // ドロップを持つよ
		
	}
	
	// 持っているドロップをマウスの座標を参照して動かすよ
	public void MoveManagement(int mouseX, int mouseY) {
		
		// 左と入れ替えるよ
		if (mouseX < this.dropX * this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX-1, this.dropY); // 左のドロップと入れ替える
		} 
		// 右と入れ替えるよ
		else if (mouseX > this.dropX * this.dropDiameter + this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX+1, this.dropY); // 右のドロップと入れ替える
		} 
		// 上と入れ替えるよ
		else if (mouseY < this.dropY * this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX, this.dropY-1); // 上のドロップと入れ替える
		} 
		// 下と入れ替えるよ
		else if (mouseY > this.dropY * this.dropDiameter + this.dropDiameter ) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX, this.dropY+1); // 下のドロップと入れ替える
		}

		this.dropX = board.getHoldDropX();  // 現在の持っているドロップのX座標を取ってくるよ
		this.dropY = board.getHoldDropY();  // 現在の持っているドロップのY座標を取ってくるよ
		board.getBoard().get(this.dropY).get(this.dropX).move(mouseX - (this.dropDiameter / 2),mouseY - (this.dropDiameter / 2));  // ドロップを動かすよ
		
	}
	
	// 持っているドロップを放して適切な場所に置くよ
	public void LostManagement() {

		board.getBoard().get(this.dropY).get(this.dropX).lost(this.dropX * this.dropDiameter,this.dropY * this.dropDiameter);
			
	}
	
	// コンボ判定を行うよ
	public ArrayList<Drop> comboDicision() {
		ArrayList<Drop> tmp = new ArrayList<Drop>();    // コンボの結果消すドロップを格納するよ
		
		//---- みたこーが作るとこ

		
		
		return tmp;
	}
	
	// ドロップを削除
	public void dropDelete(ArrayList<Drop> drop) {
		
		this.board.dropDelete(drop);
	}
	
	// 時間を測定するよ
	// ナカンディが作るところ
	/*
	hogehoge() {
		
	}
	*/
}
