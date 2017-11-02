package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Base.Panel;

// Panel�N���X���p������Drop�N���X������
public class Drop extends Panel{
	
	protected int id;                            // Drop�̎�ނ��Ƃ�ID������U���
	private final int WIDTH = 80;                // Drop�̉��̑傫������
	private final int HEIGHT = 80;               // Drop�̏c�̑傫������
	private int x;                               // Drop��x���W������
	private int y;                               // Drop��y���W������
	protected BufferedImage image;               // ���̕ϐ��ɑΉ�����摜�������
	
	// �R���X�g���N�^
	public Drop(int x, int y) {
		this.x = x;                              // x���W���w�肷���
		this.y = y;                              // y���W���w�肷���
		this.setBounds(x, y, WIDTH, HEIGHT);     // �w�肵��x,y���W�Əc���̑傫������\������ʒu�����߂��
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
	
	public int getWidth() {
		return this.WIDTH;
	}
	
	public int getHeight() {
		return this.HEIGHT;
	}
	
	public void paint(Graphics g) {
		g.drawImage(this.image,0,0,this.getWidth(),this.getHeight(),null);
	}
	

}
