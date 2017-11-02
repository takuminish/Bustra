package Game;

import java.util.ArrayList;

import Game.Drop.Drop;
import Game.Board;

// 盤面の管理を行うよ
// コンボの判定、残り時間の測定はこのクラスで行うよ
public class GameManager {

	private Board board;             // Bpardクラスのインスタンス
	private GameEnvironment environment;
	private int dropX;
	private int dropY;
	
	public GameManager(final Board board) {
		environment = new GameEnvironment();
		this.board = board;
	}
	
	// マウスの座標から持つドロップを決定しドロップを持つよ
	public void holdManagement(int mouseX, int mouseY) {
		this.dropX = mouseX / this.environment.getDropDiameter();
		this.dropY = mouseY / this.environment.getDropDiameter();
		board.getBoard().get(this.dropY).get(this.dropX).hold(mouseX-40,mouseY-40);
		
	}
	
	// 持っているドロップをマウスの座標を参照して動かすよ
	public void MoveManagement(int mouseX, int mouseY) {
		board.getBoard().get(this.dropY).get(this.dropX).move(mouseX-40,mouseY-40);
		
	}
	
	// 持っているドロップを放して適切な場所に置くよ
		public void LostManagement() {
			
			board.getBoard().get(this.dropY).get(this.dropX).lost(this.dropX * this.environment.getDropDiameter(),this.dropY * this.environment.getDropDiameter());
			
		}
	
}
