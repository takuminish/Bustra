package Game;

import java.util.ArrayList;

import Game.Drop.Drop;
import Game.Board;

// �Ֆʂ̊Ǘ����s����
// �R���{�̔���A�c�莞�Ԃ̑���͂��̃N���X�ōs����
public class GameManager {

	private Board board;             // Bpard�N���X�̃C���X�^���X
	private GameEnvironment environment;
	private int dropX;
	private int dropY;
	
	public GameManager(final Board board) {
		environment = new GameEnvironment();
		this.board = board;
	}
	
	// �}�E�X�̍��W���玝�h���b�v�����肵�h���b�v������
	public void holdManagement(int mouseX, int mouseY) {
		this.dropX = mouseX / this.environment.getDropDiameter();
		this.dropY = mouseY / this.environment.getDropDiameter();
		board.getBoard().get(this.dropY).get(this.dropX).hold(mouseX-40,mouseY-40);
		
	}
	
	// �����Ă���h���b�v���}�E�X�̍��W���Q�Ƃ��ē�������
	public void MoveManagement(int mouseX, int mouseY) {
		board.getBoard().get(this.dropY).get(this.dropX).move(mouseX-40,mouseY-40);
		
	}
	
	// �����Ă���h���b�v������ēK�؂ȏꏊ�ɒu����
		public void LostManagement() {
			
			board.getBoard().get(this.dropY).get(this.dropX).lost(this.dropX * this.environment.getDropDiameter(),this.dropY * this.environment.getDropDiameter());
			
		}
	
}
