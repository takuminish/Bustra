package Game.Drop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Base.GameEnvironment;
import Base.Panel;

// Panel�N���X���p������Drop�N���X������
public class Drop extends Panel{
	
	protected int id;                            // Drop�̎�ނ��Ƃ�ID������U���
	private final int diameter;                  // Drop�̒��a�̑傫������
	private int x;                               // Drop��x���W������
	private int y;                               // Drop��y���W������
	protected BufferedImage image;               // ���̕ϐ��ɑΉ�����摜�������
	protected BufferedImage invisibleImage;
	private Boolean hold = false;                // ���݃}�E�X�Ŏ����Ă��邩�ǂ����̏�Ԃ�\��             
	private Boolean visible = true;
	
	// �R���X�g���N�^
	public Drop(int x, int y) {
		this.x = x;                                             // x���W���w�肷���
		this.y = y;                                             // y���W���w�肷���
		this.diameter = GameEnvironment.DROPDIAMETER;
	}
	
	// �摜��image�ϐ��ɓ����(�摜�t�@�C���������Ƃ���)
	public BufferedImage Image(URL url) {
		BufferedImage image = null;              // �ŏ���null�ɂ��Ă�����
		try {
			  image = ImageIO.read(url);           // �摜���Q�Ƃł���Ή摜��image�ϐ��ɓ�����
			  invisibleImage = ImageIO.read( getClass().getClassLoader().getResource("invisible.png"));
			} catch (Exception e) {
			  e.printStackTrace();               // �G���[�o�͂��s����
			  image = null;                      // �G���[��������image�ϐ���null�̂܂܂���
			}
		return image;                            // image�ϐ���Ԃ���
	}

	// �h���b�v�̏�Ԃ�Ԃ���
	public boolean getHold() {
		return this.hold;
	}
	
	public void paint() {
		this.paint(this.getGraphics());
	}

	// �h���b�v��\�������
	@Override
	public void paintComponent(Graphics g) {
		if (this.visible) {
			this.setBounds(0, 0, this.diameter, this.diameter);     // �w�肵��x,y���W�Əc���̑傫������\������ʒu�����߂��
			g.drawImage(this.image,(this.x % this.diameter) - (this.diameter / 2),(this.y % this.diameter) - (this.diameter / 2),this.diameter,this.diameter,null); //image�ϐ��̉摜��\�������
		} else {
			this.setBounds(0, 0, this.diameter, this.diameter);     // �w�肵��x,y���W�Əc���̑傫������\������ʒu�����߂��
			g.drawImage(this.invisibleImage,(this.x % this.diameter) - (this.diameter / 2),(this.y % this.diameter) - (this.diameter / 2),this.diameter,this.diameter,null); //image�ϐ��̉摜��\�������
		}
	}
	
	// �h���b�v���폜�����
	public void setInvisible() {
		this.visible = false;
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
			System.out.println("a");
			repaint();
		}
		
		public boolean getVisible() {
			return this.visible;
		}
		
		public int getId() {
			return this.id;
		}
		public void setId() {
			this.id = -1;
		}
}