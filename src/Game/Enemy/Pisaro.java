package Game.Enemy;

import java.awt.Graphics;
import java.io.File;

public class Pisaro extends Enemy{

	public Pisaro() {
		super();
		this.id = 1;
		File f = new File("image/buspisaro.png"); // File�N���X�ɐ��h���b�v�̉摜�������
		this.image = this.Image(f);          // Drop�N���X�ɒ�`����Ă���֐�����image�ɉ摜�������
	}
	
	// �Ńh���b�v�̕\��
	public void paint(Graphics g) {
		super.paint(g);                      //Drop�N���X��paint���Ă�ł����
	}
}
