// Game.Drop�p�b�P�[�W
package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

// Drop�N���X���p�����ĈŃh���b�v�N���X������
public class DarkDrop extends Drop{
	
	// �R���X�g���N�^
	public DarkDrop(int x,int y) {
		super(x,y);                          // �󂯎����x�Ay����x���W��y���W�����߂��
		super.id = 3;                        // �h���b�v��ID����(�Ńh���b�v��3)
		File f = new File("image/dark.png"); // File�N���X�ɈŃh���b�v�̉摜�������
		this.image = this.Image(f);          // Drop�N���X�ɒ�`����Ă���֐�����image�ɉ摜�������
	}
	
	// �Ńh���b�v�̕\��
	public void paint(Graphics g) {
		super.paint(g);                      //Drop�N���X��paint���Ă�ł����
	}

}

