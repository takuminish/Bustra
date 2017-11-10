package Game.Enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import Base.GameEnvironment;
import Base.Panel;
public class Enemy extends Panel{
	
	protected BufferedImage image;               // ���̕ϐ��ɑΉ�����摜�������
	private GameEnvironment environment;
	protected int id;                            // Drop�̎�ނ��Ƃ�ID������U���
	private int x;                               // Drop��x���W������
	private int y;                               // Drop��y���W������
	private int width;
	private int height;
	
	public Enemy() {
		this.x = 100;
		this.y = 25;
		this.width = 150;
		this.height = 150;
	}
	
	// �摜��image�ϐ��ɓ����(�摜�t�@�C���������Ƃ���)
		public BufferedImage Image(File f) {
			BufferedImage image = null;              // �ŏ���null�ɂ��Ă�����
			try {
				  image = ImageIO.read(f);           // �摜���Q�Ƃł���Ή摜��image�ϐ��ɓ�����
				} catch (Exception e) {
				  e.printStackTrace();               // �G���[�o�͂��s����
				  image = null;                      // �G���[��������image�ϐ���null�̂܂܂���
				}
			return image;                            // image�ϐ���Ԃ���
		}

		public void paintComponent(Graphics g) {
			
			this.setBounds(this.x, this.y, this.width, this.height);     // �w�肵��x,y���W�Əc���̑傫������\������ʒu�����߂��
			g.drawImage(this.image,0,0,this.width,this.height,null); //image�ϐ��̉摜��\�������
		}
}
