package Game.Enemy;

import java.awt.Graphics;
import java.io.File;
import java.net.URL;

public class HardEnemy extends Enemy{

	public HardEnemy() {
		super();
		this.id = 1;
		this.name = "�o�X�s�T��";
		this.hp = 6;
		this.url = getClass().getClassLoader().getResource("buspisaro.png");
		this.image = this.Image(url);          // Drop�N���X�ɒ�`����Ă���֐�����image�ɉ摜�������
	    this.setNorma();	    
	}
	
	// �Ńh���b�v�̕\��
	public void paint(Graphics g) {
		super.paint(g);                      //Drop�N���X��paint���Ă�ł����
	}
	
	@Override
	public void setNorma() {
		for (int k = 0; k < this.hp; k++) {
		    this.damagenorma.add((int)(Math.random()*3) + 5);
		}
	}
	
}
