package Game.Enemy;

import java.awt.Graphics;
import java.io.File;
import java.net.URL;

public class EasyEnemy extends Enemy{

	public EasyEnemy() {
		super();
		this.id = 1;
		this.hp = 3;
		
		this.name = "�Y���C��";
		this.url = getClass().getClassLoader().getResource("suraimu.png");
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
		    this.damagenorma.add((int)(Math.random()*2)+1);
		}
	}
}