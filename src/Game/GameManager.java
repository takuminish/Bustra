package Game;

import java.util.ArrayList;

import Game.Drop.Drop;
import Game.Board;

// 盤面の管理を行うよ
// コンボの判定、残り時間の測定はこのクラスで行うよ
public class GameManager {

	private Board board;             // Dropクラスの2次元配列
	
	
	public GameManager(final Board board) {
		int[] x = new int[3];
		int[] y = new int[3];
		
		x[0] = y[0] = 1;
		x[1] = y[1] = 2;
		x[2] = y[2] = 3;
		this.board = board;
		this.board.dropDelete(x,y);
	}
}
