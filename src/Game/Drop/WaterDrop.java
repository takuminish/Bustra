package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

// Drop�N���X���p�����Đ��h���b�v�N���X������
public class WaterDrop extends Drop{
	
	// �R���X�g���N�^
	public WaterDrop(int x,int y) {
		super(x,y);                          // �󂯎����x�Ay����x���W��y���W�����߂��
		super.id = 1;                        // �h���b�v��ID����(���h���b�v��1)
		File f = new File("image/water.png"); // File�N���X�ɐ��h���b�v�̉摜�������
		this.image = this.Image(f);          // Drop�N���X�ɒ�`����Ă���֐�����image�ɉ摜�������
	}
	
	// �Ńh���b�v�̕\��
	public void paint(Graphics g) {
		super.paint(g);                      //Drop�N���X��paint���Ă�ł����
	}

}

