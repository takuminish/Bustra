package Game;

import java.util.ArrayList;

import Game.Drop.Drop;
import Game.Board;

// �Ֆʂ̊Ǘ����s����
// �R���{�̔���A�c�莞�Ԃ̑���͂��̃N���X�ōs����
public class GameManager {

	private Board board;             // Drop�N���X��2�����z��
	
	
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
