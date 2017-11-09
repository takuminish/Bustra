package Base;

// �Q�[���ɕK�v�Ȓl������GameEnvironment�N���X������
public class GameEnvironment {

	private final int BOARDWIDTH = 6;      // �Ֆʂ̉��̃h���b�v�̐����w��
	private final int BOARDHEIGHT = 5;     // �Ֆʂ̏c�̃h���b�v�̐����w��
	private final int DROPDIAMETER = 60;   // �h���b�v�̑傫�����w��
	private final int WINDOWWIDTH = 377;   // ��ʂ̉��̒������w�肷���
	private final int WINDOWHEIGHT = 600;  // ��ʂ̏c�̒������w�肷���
	private final int BOARDPOSITION = 260; // �Ֆʂ̈ʒu���w�肷��� 
	
	// �Ֆʂ̈ʒu��Ԃ���
	public int getBoardPosition() {
		return this.BOARDPOSITION;
	}
	
	// ��ʂ̉��̒�����Ԃ���
	public int getWindowWidth() {
		return this.WINDOWWIDTH;
	}
		
	// ��ʂ̏c�̒�����Ԃ���
	public int getWindowHeight() {
		return this.WINDOWHEIGHT;
	}
	
	// �Ֆʂ̉��̃h���b�v�̐���Ԃ���
	public int getBourdWidth() {
		return this.BOARDWIDTH;
	}
	
	// �Ֆʂ̏c�̃h���b�v�̐���Ԃ���
	public int getBourdHeight() {
		return this.BOARDHEIGHT;
	}
	
	// �h���b�v�̑傫����Ԃ���
	public int getDropDiameter() {
		return this.DROPDIAMETER;
	}
}
