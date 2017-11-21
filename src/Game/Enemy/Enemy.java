package Game.Enemy;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.imageio.ImageIO;

import Base.GameEnvironment;
import Base.Panel;
public class Enemy extends Panel implements ActionListener{
	
	protected BufferedImage image;               // ���̕ϐ��ɑΉ�����摜�������
	protected int id;                            // Drop�̎�ނ��Ƃ�ID������U���
	private int x;                               // Drop��x���W������
	private int y;                               // Drop��y���W������
	private int width;
	private int height;
	protected String name;
	protected int hp;
	protected  ArrayList<Integer> damagenorma;
	protected 	Timer timer = new Timer(10 , this);
	protected URL url;
	
	int a = 1;
	int s = 0;
	public Enemy() {
		this.x = 100;
		this.y = 25;
		this.width = 150;
		this.height = 150;
		this.damagenorma = new ArrayList<>();
		
	}
	
	// �摜��image�ϐ��ɓ����(�摜�t�@�C���������Ƃ���)
		public BufferedImage Image(URL url) {
			BufferedImage image = null;              // �ŏ���null�ɂ��Ă�����
			try {
				  image = ImageIO.read(url);           // �摜���Q�Ƃł���Ή摜��image�ϐ��ɓ�����
				} catch (Exception e) {
				  e.printStackTrace();               // �G���[�o�͂��s����
				  image = null;                      // �G���[��������image�ϐ���null�̂܂܂���
				}
			return image;                            // image�ϐ���Ԃ���
		}

		public void paintComponent(Graphics g) {
			
			g.drawImage(this.image,0,0,this.width,this.height,null); //image�ϐ��̉摜��\�������
		}
		
		public void Damage() {
			this.hp--;
			timer.start();
			System.out.println(this.hp);
		}
		
		public int getNorma() {
			return this.damagenorma.get(this.hp-1);
		}
		
		public int getHp() {
			return this.hp;
		}
		
		public void clear() {
			this.url = getClass().getClassLoader().getResource("clear.png");
			this.image = this.Image(this.url);          // Drop�N���X�ɒ�`����Ă���֐�����image�ɉ摜�������
			repaint();
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (this.s >= 2) {
				this.timer.stop();
				this.s = 0;
			} else {
				s++;
				if (a == 1) {
					URL url = getClass().getClassLoader().getResource("black.png");
					this.image = this.Image(url);          // Drop�N���X�ɒ�`����Ă���֐�����image�ɉ摜�������
					a = 2;
				} else {
					this.image = Image(this.url);
					a = 1;
				}
				repaint();
			}
		}
		
		public String getName() {
			return this.name;
		}
		
		public void setNorma() {}
		
}
