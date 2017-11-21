package Game.Enemy;

import java.awt.Graphics;
import java.io.File;
import java.net.URL;

public class NormalEnemy extends Enemy{

	public NormalEnemy() {
		super();
		this.id = 1;
		this.name = "�M���[�}�V��";
		this.hp = 5;
		this.url = getClass().getClassLoader().getResource("kira.png");
		this.image = this.Image(this.url);          // Drop�N���X�ɒ�`����Ă���֐�����image�ɉ摜�������
	    this.setNorma();	    
	}
	
	// �Ńh���b�v�̕\��
	public void paint(Graphics g) {
		super.paint(g);                      //Drop�N���X��paint���Ă�ł����
	}
	
	@Override
	public void setNorma() {
		for (int k = 0; k < this.hp; k++) {
		    this.damagenorma.add((int)(Math.random()*2)+3);
		}
	}
}