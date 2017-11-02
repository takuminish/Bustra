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
	private final int DIAMETER = 80;                // Drop�̒��a�̑傫������

	private int x;                               // Drop��x���W������
	private int y;                               // Drop��y���W������
	protected BufferedImage image;               // ���̕ϐ��ɑΉ�����摜�������
	
	// �R���X�g���N�^
	public Drop(int x, int y) {
		this.x = x;                              // x���W���w�肷���
		this.y = y;                              // y���W���w�肷���
		this.setBounds(x, y, DIAMETER, DIAMETER);     // �w�肵��x,y���W�Əc���̑傫������\������ʒu�����߂��
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
	
	// Drop�̒��a�̒���������Ă����
	public int getDiameter() {
		return this.DIAMETER;
	}

	// �h���b�v��\�������
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(this.image,0,0,this.getDiameter(),this.getDiameter(),null); //image�ϐ��̉摜��\�������
	}
	

}
