// Game.Drop�p�b�P�[�W
package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import Game.Drop.Drop;

// Drop�N���X���p�����ĉ΃h���b�v�N���X������
public class FireDrop extends Drop{
	
	// �R���X�g���N�^
	public FireDrop(int x,int y) {
		super(x,y);                          // �󂯎����x�Ay����x���W��y���W�����߂��
		super.id = 0;                        // �h���b�v��ID����(�΃h���b�v��0)
		URL url = getClass().getClassLoader().getResource("fire.png");
		this.image = this.Image(url);          // Drop�N���X�ɒ�`����Ă���֐�����image�ɉ摜�������
	}
	
	// �΃h���b�v�̕\��
	public void paint(Graphics g) {
		super.paint(g);                      //Drop�N���X��paint���Ă�ł����
	}

}

