// Game.Drop�p�b�P�[�W
package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

// Drop�N���X���p�����ĈŃh���b�v�N���X������
public class WoodDrop extends Drop{
	
	// �R���X�g���N�^
	public WoodDrop(int x,int y) {
		super(x,y);                          // �󂯎����x�Ay����x���W��y���W�����߂��
		super.id = 2;                        // �h���b�v��ID����(�؃h���b�v��2)
		File f = new File("image/wood.png"); // File�N���X�ɖ؃h���b�v�̉摜�������
		this.image = this.Image(f);          // Drop�N���X�ɒ�`����Ă���֐�����image�ɉ摜�������
	}
	
	// �؃h���b�v�̕\��
	public void paint(Graphics g) {
		super.paint(g);                      //Drop�N���X��paint���Ă�ł����
	}

}

