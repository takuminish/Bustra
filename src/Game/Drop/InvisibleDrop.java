// Game.Drop�p�b�P�[�W
package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import Game.Drop.Drop;

// Drop�N���X���p�����Ė����h���b�v�N���X������
// ����������摜�͎����Ȃ���
public class InvisibleDrop extends Drop{
	
	// �R���X�g���N�^
	public InvisibleDrop(int x,int y) {
		super(x,y);                          // �󂯎����x�Ay����x���W��y���W�����߂��
		super.id = -1;                        // �h���b�v��ID����(�����h���b�v��-1)
		
	}
}

