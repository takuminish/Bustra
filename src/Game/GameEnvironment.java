package Game;

// �Q�[���ɕK�v�Ȓl������GameEnvironment�N���X������
public class GameEnvironment {

	private final int BOARDWIDTH = 6;      // �Ֆʂ̉��̃h���b�v�̐����w��
	private final int BOARDHEIGHT = 5;     // �Ֆʂ̏c�̃h���b�v�̐����w��
	private final int DROPDIAMETER = 80;   // �h���b�v�̑傫�����w��
	
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
