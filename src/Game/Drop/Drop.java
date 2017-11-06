package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Base.Panel;
import Game.GameEnvironment;

// Panel�N���X���p������Drop�N���X������
public class Drop extends Panel{
	
	private GameEnvironment environment;
	protected int id;                            // Drop�̎�ނ��Ƃ�ID������U���
	private final int diameter;                  // Drop�̒��a�̑傫������
	private int x;                               // Drop��x���W������
	private int y;                               // Drop��y���W������
	protected BufferedImage image;               // ���̕ϐ��ɑΉ�����摜�������
	private Boolean hold = false;                // ���݃}�E�X�Ŏ����Ă��邩�ǂ����̏�Ԃ�\��             
	
	// �R���X�g���N�^
	public Drop(int x, int y) {
		environment = new GameEnvironment();
		this.x = x;                                             // x���W���w�肷���
		this.y = y;                                             // y���W���w�肷���
		this.diameter = environment.getDropDiameter();
		this.setBounds(this.x, this.y, this.diameter, this.diameter);     // �w�肵��x,y���W�Əc���̑傫������\������ʒu�����߂��
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
		return this.diameter;
	}
	
	// �h���b�v�̏�Ԃ�Ԃ���
	public boolean getHold() {
		return this.hold;
	}

	// �h���b�v��\�������
	@Override
	public void paintComponent(Graphics g) {
		
		this.setBounds(this.x, this.y, this.diameter, this.diameter);     // �w�肵��x,y���W�Əc���̑傫������\������ʒu�����߂��
		g.drawImage(this.image,0,0,this.getDiameter(),this.getDiameter(),null); //image�ϐ��̉摜��\�������
	}
	
	// �h���b�v���폜�����
	public InvisibleDrop setInvisible() {
		this.image = null;
		InvisibleDrop invisibleDrop = new InvisibleDrop(this.x,this.y);
		return invisibleDrop;
	}
	
	// �h���b�v������
	public void hold(int x, int y) {
		this.hold = true;
		this.x = x;
		this.y = y;
		repaint();
	}
	
	
	// �h���b�v�𓮂�����
	public void move(int x, int y) {
		    this.x = x;
		    this.y = y;
		
		repaint();
	}
	
	// �h���b�v�������
		public void lost(int x, int y) {
			if (this.hold == true) {
			    this.x = x;
			    this.y = y;
			}
			this.hold = false;
			repaint();
		}
	
	
	
	

}
