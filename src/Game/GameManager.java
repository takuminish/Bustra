package Game;

import java.util.ArrayList;

import Game.Drop.Drop;
import Game.Board;

// �Ֆʂ̊Ǘ����s����
// �R���{�̔���A�c�莞�Ԃ̑���͂��̃N���X�ōs����
public class GameManager {

	private Board board;                  // Bpard�N���X�̃C���X�^���X
	private GameEnvironment environment;  // �Q�[���ɕK�v�Ȓl�𓾂�C���X�^���X
	private int BoardX;                   // �Ֆʂ̉��̃h���b�v�̐�
	private int BoardY;                   // �Ֆʂ̏c�̃h���b�v�̐�
	private int dropDiameter;             // �h���b�v�̑傫��
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
	
	// �}�E�X�̍��W���玝�h���b�v�����肵�h���b�v������
	public void holdManagement(int mouseX, int mouseY) {
		this.dropX = mouseX / this.dropDiameter;  // �}�E�X�̍��W���獶���牽�Ԗڂ̃h���b�v�Ȃ̂����擾
		this.dropY = mouseY / this.dropDiameter;  // �}�E�X�̍��W����ォ�牽�Ԗڂ̃h���b�v�Ȃ̂����擾
		board.getBoard().get(this.dropY).get(this.dropX).hold(mouseX - (this.dropDiameter / 2),mouseY - (this.dropDiameter / 2));  // �h���b�v������
		
	}
	
	// �����Ă���h���b�v���}�E�X�̍��W���Q�Ƃ��ē�������
	public void MoveManagement(int mouseX, int mouseY) {
		
		// ���Ɠ���ւ����
		if (mouseX < this.dropX * this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX-1, this.dropY); // ���̃h���b�v�Ɠ���ւ���
		} 
		// �E�Ɠ���ւ����
		else if (mouseX > this.dropX * this.dropDiameter + this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX+1, this.dropY); // �E�̃h���b�v�Ɠ���ւ���
		} 
		// ��Ɠ���ւ����
		else if (mouseY < this.dropY * this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX, this.dropY-1); // ��̃h���b�v�Ɠ���ւ���
		} 
		// ���Ɠ���ւ����
		else if (mouseY > this.dropY * this.dropDiameter + this.dropDiameter ) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX, this.dropY+1); // ���̃h���b�v�Ɠ���ւ���
		}

		this.dropX = board.getHoldDropX();  // ���݂̎����Ă���h���b�v��X���W������Ă����
		this.dropY = board.getHoldDropY();  // ���݂̎����Ă���h���b�v��Y���W������Ă����
		board.getBoard().get(this.dropY).get(this.dropX).move(mouseX - (this.dropDiameter / 2),mouseY - (this.dropDiameter / 2));  // �h���b�v�𓮂�����
		
	}
	
	// �����Ă���h���b�v������ēK�؂ȏꏊ�ɒu����
	public void LostManagement() {

		board.getBoard().get(this.dropY).get(this.dropX).lost(this.dropX * this.dropDiameter,this.dropY * this.dropDiameter);
			
	}
	
	// �R���{������s����
	public ArrayList<Drop> comboDicision() {
		ArrayList<Drop> tmp = new ArrayList<Drop>();    // �R���{�̌��ʏ����h���b�v���i�[�����
		
		//---- �݂����[�����Ƃ�

		
		
		return tmp;
	}
	
	// �h���b�v���폜
	public void dropDelete(ArrayList<Drop> drop) {
		
		this.board.dropDelete(drop);
	}
	
	// ���Ԃ𑪒肷���
	// �i�J���f�B�����Ƃ���
	/*
	hogehoge() {
		
	}
	*/
}
